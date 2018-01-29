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
     * Служебное поле hibernate
     */
    @Version
    private Integer version;

    /**
     * Список книг пренадлежащих пользователю
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Book> book = new HashSet<>();

    /**
     * Список страниц
     */
    @ManyToMany
    @JoinTable(name = "current_page", joinColumns = @JoinColumn (name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "page_id"))
    private Set<Page> page = new HashSet<>();

    /**
     *  Список прав доступа
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<AccessRights> accessRights = new HashSet<>();

    /**
     *  Список ответов на запросы от других пользователей
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<AccessRequest>accessRequests = new HashSet<>();

    /**
     * Конструктор для hibernate
     */
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

    public Set<Book> getBook() {
        return book;
    }

    public void setBook(Set<Book> book) {
        this.book = book;
    }

    public Set<Page> getPage() {
        return page;
    }

    public void setPage(Set<Page> page) {
        this.page = page;
    }

    public Set<AccessRights> getAccessRights() {
        return accessRights;
    }

    public void setAccessRights(Set<AccessRights> accessRights) {
        this.accessRights = accessRights;
    }

    public Set<AccessRequest> getAccessRequests() {
        return accessRequests;
    }

    public void setAccessRequests(Set<AccessRequest> accessRequests) {
        this.accessRequests = accessRequests;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
