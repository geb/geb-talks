package app

class Book {
    static belongsTo = Author

    String title
    Author author

    String toString() {
        title
    }
}
