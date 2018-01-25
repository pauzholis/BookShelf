package ru.testproject.bookshelf.model;

import java.util.Date;

/**
 * Права доступа
 */
public class AccessRights {
    /**
     * Книга на которую запрашивается доступ
     */
    private Book book;

    /**
     * Пользователь
     */
    private User user;

    /**
     * Дата окончания действия права доступа к книге
     */
    private Date activeDate;

    public AccessRights() {
    }

    public AccessRights(Book book, User user, Date activeDate) {
        this.book = book;
        this.user = user;
        this.activeDate = activeDate;
    }

    public Book getBook() {
        return book;
    }

    public User getUser() {
        return user;
    }

    public Date getActiveDate() {
        return activeDate;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setActiveDate(Date activeDate) {
        this.activeDate = activeDate;
    }
}
