package app

class Author {
    static hasMany = [books: Book]
    String name

    String toString() {
        name
    }
}
