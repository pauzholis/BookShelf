package ru.testproject.bookshelf.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.testproject.bookshelf.dao.ShelfDao;
import ru.testproject.bookshelf.model.Shelf;
import ru.testproject.bookshelf.service.ShelfService;
import ru.testproject.bookshelf.view.ShelfView;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class ShelfServiceImpl implements ShelfService {
    private final ShelfDao shelfDao;

    @Autowired
    public ShelfServiceImpl(ShelfDao shelfDao) {
        this.shelfDao = shelfDao;
    }

    @Override
    @Transactional
    public ShelfView getShelf(Long id) {
        Shelf shelf = shelfDao.findOne(id);
        return new ShelfView(shelf.getName(), shelf.getDescription());
    }

    @Override
    @Transactional
    public List<ShelfView> getAllShelves() {
        List<Shelf> shelves = shelfDao.findAll();
        Function<Shelf, ShelfView> mapShelf = s -> {
            ShelfView shelfView = new ShelfView();
            shelfView.id = s.getId();
            shelfView.name = s.getName();
            shelfView.description = s.getDescription();
            return shelfView;
        };
        return shelves.stream().map(mapShelf).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void save(ShelfView view) {
        Shelf shelf = new Shelf(view.getName(), view.getDescription());
        shelfDao.save(shelf);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        shelfDao.delete(id);
    }
}