package ru.testproject.bookshelf.service.Impl;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.testproject.bookshelf.dao.ShelfDao;
import ru.testproject.bookshelf.model.Shelf;
import ru.testproject.bookshelf.service.ShelfService;
import ru.testproject.bookshelf.view.ShelfView;

import java.util.ArrayList;
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
    /**
     * готово
     */
    public List<Shelf> getAllShelves() {
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
    public void update(ShelfView view) {

    }

    @Override
    public void delete(Long id) {

    }
}
