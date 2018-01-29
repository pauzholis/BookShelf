package ru.testproject.bookshelf.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Книга
 */
@Entity
@Table(name = "book")
public class Book {
    /**
     * Идентификатор книги
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    /**
     * Полка на которой стоит книга
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shelf_id")
    private Shelf shelf;

    /**
     * Пользователь которому принадлежит книга
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    /**
     * Место расположения книги
     */
    @Column(name = "file_path")
    private String filePath;

    /**
     * Название книги
     */
    @Column(name = "name")
    private String name;

    /**
     * Автор книги
     */
    @Column(name = "author")
    private String author;

    /**
     * Описание книги
     */
    @Column(name = "description")
    private String description;

    /**
     * ISBN книги
     */
    @Column(name = "isbn")
    private Long isbn;

    /** Список страниц*/
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Page> page = new HashSet<Page>();

    /** Список прав на чтение*/
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<AccessRights> accessRights = new HashSet<>();

    /** Список запросов на чтение от других пользователей*/
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<AccessRequest>accessRequests = new HashSet<>();



    public Book() {
    }

    public Book(Long id, Shelf shelf, User user, String filePath, String name, String author, String description,
                Long isbn) {
        this.id = id;
        this.shelf = shelf;
        this.user = user;
        this.filePath = filePath;
        this.name = name;
        this.author = author;
        this.description = description;
        this.isbn = isbn;
    }

    public Long getId() {
        return id;
    }

    public Shelf getShelf() {
        return shelf;
    }

    public User getUser() {
        return user;
    }

    public String getFilePath() {
        return filePath;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setShelf(Shelf shelf) {
        this.shelf = shelf;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
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
}
