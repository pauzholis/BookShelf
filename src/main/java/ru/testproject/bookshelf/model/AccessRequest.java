package ru.testproject.bookshelf.model;

/**
 * Запрос доступа
 */
public class AccessRequest {
    /**
     * Идентификатор запроса
     */
    private Long id;

    /**
     * Книга к которой запрашивается доступ
     */
    private Book book;

    /**
     * Пользователь отправляющий запрос
     */
    private User user;

    /**
     * Сообщение запроса доступа
     */
    private String massage;

    public AccessRequest() {
    }

    public AccessRequest(Long id, Book book, User user, String massage) {
        this.id = id;
        this.book = book;
        this.user = user;
        this.massage = massage;
    }

    public Long getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public User getUser() {
        return user;
    }

    public String getMassage() {
        return massage;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }
}
