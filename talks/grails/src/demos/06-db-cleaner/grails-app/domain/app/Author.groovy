package app

class Author {
    static hasMany = [books: Book]
    String name
    Integer age

    String toString() {
        name
    }

    static constraints = {
        age(min: 1, max: 99)
    }

}
