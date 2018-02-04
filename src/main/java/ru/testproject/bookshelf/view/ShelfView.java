package ru.testproject.bookshelf.view;


public class ShelfView {
    public Long id;
    public String name;
    public String description;

    public ShelfView() {
    }

    public ShelfView(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
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
