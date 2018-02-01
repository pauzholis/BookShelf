package ru.testproject.bookshelf.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Страница книги
 */
@Entity
@Table(name = "page")
public class Page {
    /**
     * Идентификатор страницы
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    /**
     * Книга, которой принадлежит страница
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id")
    private Book book;

    /**
     * Номер страницы
     */
    @Column(name = "number")
    private Integer number;

    /**
     * Содержимое страницы
     */
    @Column(name = "content")
    private String content;

    /**
     * Служебное поле hibernate
     */
    @Version
    private Integer version;

    /**
     * Пользователи просматривающий текущую страницу
     */
    @ManyToMany()
    private Set<User> user;

    /**
     * Конструктор для hibernate
     */
    public Page() {
    }

    public Page(Book book, Integer number, String content) {
        this.book = book;
        this.number = number;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public Integer getNumber() {
        return number;
    }

    public String getContent() {
        return content;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Set<User> getUser() {
        return user;
    }

    public void setUser(Set<User> user) {
        this.user = user;
    }
}
