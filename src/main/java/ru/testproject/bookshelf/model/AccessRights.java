package ru.testproject.bookshelf.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Права доступа
 */
@Entity
@Table(name = "access_rights")
public class AccessRights {
    /**
     * Книга на которую запрашивается доступ
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;

    /**
     * Пользователь
     */
    @ManyToMany
    @JoinColumn(name = "user_id")
    private Set<User> user = new HashSet<>();


    /**
     * Дата окончания действия права доступа к книге
     */
    @Temporal(value = TemporalType.DATE)
    @Column(name = "active_date")
    private Date activeDate;

    public AccessRights() {
    }

    public AccessRights(Book book, Set<User> user, Date activeDate) {
        this.book = book;
        this.user = user;
        this.activeDate = activeDate;
    }

    public Book getBook() {
        return book;
    }

    public Set<User> getUser() {
        return user;
    }

    public Date getActiveDate() {
        return activeDate;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setUser(Set<User> user) {
        this.user = user;
    }

    public void setActiveDate(Date activeDate) {
        this.activeDate = activeDate;
    }
}
