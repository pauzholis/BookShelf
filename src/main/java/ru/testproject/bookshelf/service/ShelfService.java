package ru.testproject.bookshelf.service;


import ru.testproject.bookshelf.model.Shelf;
import ru.testproject.bookshelf.view.ShelfView;

import java.util.List;

public interface ShelfService {

    /**
     * Получить полку
     */
    ShelfView getShelf(Long id);

    /**
     * Получить все полки
     */
    List<ShelfView> getAllShelves();

    /**
     * Сохранить полку
     */
    void save(ShelfView view);

    /**
     * Удалить полку
     */
    void delete(Long id);

    Shelf getShelfByName(String name);
}
