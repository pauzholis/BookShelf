package ru.testproject.bookshelf.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Активация пользователя
 */
@Entity
@Table(name = "user_activation")
public class UserActivation {
    /**
     * Идентификатор акцивации пользователя
     */
    @Id
    @Column(name = "id")
    private Long id;

    /**
     * Пользователь
     */
    @MapsId
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
    public UserActivation() {
    }

    public UserActivation(User user, String hash, Long id) {
        this.user = user;
        this.hash = hash;
        this.id = id;
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
