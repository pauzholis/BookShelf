package ru.testproject.bookshelf.model;

/**
 * Пользователь
 */
public class User {
    /**
     * Идентификатор пользователя
     */
    private Long id;

    /**
     * email пользователя
     */
    private String email;

    /**
     * Пароль пользователя
     */
    private String password;

    /**
     * Статус регистрации
     */
    private Boolean active;

    public User() {
    }

    public User(String email, String password, Boolean active) {
        this.email = email;
        this.password = password;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getActive() {
        return active;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
