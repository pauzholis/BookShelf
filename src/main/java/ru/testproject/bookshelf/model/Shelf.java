package ru.testproject.bookshelf.model;

/**
 * Полка
 */
public class Shelf {
    /**
     * Идентификатор полки
     */
    private Long id;

    /**
     * Название полки
     */
    private String name;

    /**
     * Описание полки
     */
    private String description;

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
}
