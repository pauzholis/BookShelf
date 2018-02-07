package ru.testproject.bookshelf.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.testproject.bookshelf.model.Shelf;

import java.util.List;

public interface ShelfDao extends JpaRepository<Shelf, Long> {
    /**
     * Получить все полки
     */
    List<Shelf> findAll();
}



