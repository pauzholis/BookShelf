package ru.testproject.bookshelf.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Активация пользователя
 */
@Embeddable
@Table(name = "user_activation")
public class UserActivation {
    /**
     * Пользователь
     */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    /**
     * Строка активации пользователя
     */
    @Column(name = "hash")
    private String hash;

    /**
     * Строка активации пользователя
     */
    @Column(name = "active_data")
    @Temporal(value = TemporalType.DATE)
    private Date activeDate;

    /**
     * Служебное поле hibernate
     */
    @Version
    private Integer version;

    /**
     * Конструктор для hibernate
     */
    public UserActivation() {
    }

    public UserActivation(User user, String hash, Date createDate, Date acriveDate) {
        this.user = user;
        this.hash = hash;
        this.activeDate = acriveDate;
    }

    public User getUser() {
        return user;
    }

    public String getHash() {
        return hash;
    }

    public Date getActiveDate() {
        return activeDate;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public void setAtriveDate(Date acriveDate) {
        this.activeDate = acriveDate;
    }

    public void setActiveDate(Date activeDate) {
        this.activeDate = activeDate;
    }
}
