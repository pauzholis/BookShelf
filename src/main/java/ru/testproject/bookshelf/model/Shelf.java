package ru.testproject.bookshelf.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Полка
 */
@Entity
@Table(name = "shelf")
public class Shelf {
    /**
     * Идентификатор полки
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    /**
     * Название полки
     */
    @Column(name = "name")
    private String name;

    /**
     * Описание полки
     */
    @Column(name = "description")
    private String description;

    /**
     * Служебное поле hibernate
     */
    @Version
    private Integer version;

    /**
     * Список кник входящих в состав данной полки
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "shelf ", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Book> book = new HashSet<>();

    /**
     * Конструктор для hibernate
     */
    public Shelf() {
    }

    public Shelf(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Book> getBook() {
        return book;
    }

    public void setBook(Set<Book> book) {
        this.book = book;
    }
}
