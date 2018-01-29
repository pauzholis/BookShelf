package ru.testproject.bookshelf.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Запрос доступа
 */
@Entity
@Table(name = "access_request")
public class AccessRequest {
    /**
     * Идентификатор запроса
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    /**
     * Книга, к которой запрашивается доступ
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;

    /**
     * Пользователь, отправляющий запрос
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    /**
     * Сообщение запроса доступа
     */
    @Column(name = "massage")
    private String massage;

    /**
     * Служебное поле hibernate
     */
    @Version
    private Integer version;

    /**
     * Список ответов на запросы
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<AccessResponse> accessResponseSet = new HashSet<>();

   /**
    * Конструктор для hibernate
    */
    public AccessRequest() {
    }

    public AccessRequest(Long id, Book book, User user, String massage) {
        this.id = id;
        this.book = book;
        this.user = user;
        this.massage = massage;
    }

    public Long getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public User getUser() {
        return user;
    }

    public String getMassage() {
        return massage;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public Set<AccessResponse> getAccessResponseSet() {
        return accessResponseSet;
    }

    public void setAccessResponseSet(Set<AccessResponse> accessResponseSet) {
        this.accessResponseSet = accessResponseSet;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

}
