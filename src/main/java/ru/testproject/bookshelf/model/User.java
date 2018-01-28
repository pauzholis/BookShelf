package ru.testproject.bookshelf.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Пользователь
 */
@Entity
@Table(name = "user")
public class User {
    /**
     * Идентификатор пользователя
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    /**
     * email пользователя
     */
    @Column(name = "email")
    private String email;

    /**
     * Пароль пользователя
     */
    @Column(name = "password")
    private String password;

    /**
     * Статус регистрации
     */
    @Column(name = "active")
    private Boolean active;

    /**
     * Список книг пренадлежащих пользователю
    * */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Book> book = new HashSet<>();

    @OneToMany
    @JoinTable(name = "current_page", joinColumns = @JoinColumn (name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "page_id"))
    private Set<Page> page = new HashSet<>();

    @ManyToMany(mappedBy = "user")
    private Set<AccessRights> accessRights = new HashSet<>();




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
