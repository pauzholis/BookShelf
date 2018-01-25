package ru.testproject.bookshelf.model;

/**
 * Книга
 */
public class Book {
    /**
     * Идентификатор книги
     */
    private Long id;

    /**
     * Полка на которой стоит книга
     */
    private Shelf shelf;

    /**
     * Пользователь которому принадлежит книга
     */
    private User user;

    /**
     * Место расположения книги
     */
    private String filePath;

    /**
     * Название книги
     */
    private String name;

    /**
     * Автор книги
     */
    private String author;

    /**
     * Описание книги
     */
    private String description;

    /**
     * ISBN книги
     */
    private Long isbn;

    public Book() {
    }

    public Book(Long id, Shelf shelf, User user, String filePath, String name, String author, String description,
                Long isbn) {
        this.id = id;
        this.shelf = shelf;
        this.user = user;
        this.filePath = filePath;
        this.name = name;
        this.author = author;
        this.description = description;
        this.isbn = isbn;
    }

    public Long getId() {
        return id;
    }

    public Shelf getShelf() {
        return shelf;
    }

    public User getUser() {
        return user;
    }

    public String getFilePath() {
        return filePath;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setShelf(Shelf shelf) {
        this.shelf = shelf;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }
}
