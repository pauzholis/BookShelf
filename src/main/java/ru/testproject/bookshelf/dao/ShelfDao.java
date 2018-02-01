package ru.testproject.bookshelf.dao;


import org.springframework.data.repository.CrudRepository;
import ru.testproject.bookshelf.model.Shelf;

public interface ShelfDao extends CrudRepository<Shelf, Long> {
}
