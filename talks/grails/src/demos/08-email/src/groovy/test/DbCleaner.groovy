package test
import groovy.sql.Sql

class DbCleaner {
    def sessionFactory
    def dataSource

    void clean() {
        sessionFactory.currentSession.flush()
        def db = new Sql(dataSource)
        db.withBatch { stmt ->
            stmt.addBatch("SET REFERENTIAL_INTEGRITY FALSE")
            db.eachRow("SELECT table_name FROM INFORMATION_SCHEMA.tables WHERE table_schema = 'PUBLIC' AND table_type = 'TABLE'") {
                if (!it.table_name.toLowerCase().startsWith('databasechangelog'))
                    stmt.addBatch("TRUNCATE table " + it.table_name)
            }
            stmt.addBatch("SET REFERENTIAL_INTEGRITY TRUE")
        }
        sessionFactory.currentSession.clear()
    }
}
