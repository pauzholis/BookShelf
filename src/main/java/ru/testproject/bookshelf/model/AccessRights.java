package ru.testproject.bookshelf.model;

import javax.persistence.*;
import java.util.Date;


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
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    /**
     * Дата окончания действия права доступа к книге
     */
    @Temporal(value = TemporalType.DATE)
    @Column(name = "active_date")
    private Date activeDate;

    /**
     * Служебное поле hibernate
     */
    @Version
    private Integer version;

    /**
     * Конструктор для hibernate
     */
    public AccessRights() {
    }

    public AccessRights(Book book,User user, Date activeDate) {
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

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
