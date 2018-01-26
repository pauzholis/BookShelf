package ru.testproject.bookshelf.model;

import java.util.Date;

/**
 * Активация пользователя
 */
public class UserActivation {
    /**
     * Пользователь
     */
    private User user;

    /**
     * Строка активации пользователя
     */
    private String hash;



    /**
     * Строка активации пользователя
     */
    private Date acriveDate;

    public UserActivation(User user, String hash, Date createDate, Date acriveDate) {
        this.user = user;
        this.hash = hash;
        this.acriveDate = acriveDate;
    }

    public User getUser() {
        return user;
    }

    public String getHash() {
        return hash;
    }

    public Date getAcriveDate() {
        return acriveDate;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public void setAcriveDate(Date acriveDate) {
        this.acriveDate = acriveDate;
    }
}
