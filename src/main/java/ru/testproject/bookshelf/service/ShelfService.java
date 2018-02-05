package ru.testproject.bookshelf.service;


import ru.testproject.bookshelf.model.Shelf;
import ru.testproject.bookshelf.view.ShelfView;

import java.util.List;

public interface ShelfService {
    ShelfView getShelf (Long id);
    List<Shelf> getAllShelves();
    void update (ShelfView view);
    void delete (Long id);
}
