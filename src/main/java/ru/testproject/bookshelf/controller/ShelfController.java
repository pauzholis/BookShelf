package ru.testproject.bookshelf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.testproject.bookshelf.service.ShelfService;
import ru.testproject.bookshelf.view.ShelfView;

@Controller
@RequestMapping(value = "/")
public class ShelfController {
    private final ShelfService shelfService;

    @Autowired
    public ShelfController(ShelfService shelfService) {
        this.shelfService = shelfService;
    }

    @RequestMapping("shelf")
    public String getAllShelves(Model model) {
        model.addAttribute("shelfView", shelfService.getAllShelves());
        return "shelf";
    }

    /**
     * Страница добавления новой полки
     */
    @RequestMapping(value = {"shelf/addShelf"})
    public String showAddShelfPage(Model model) {
        model.addAttribute("shelfView", new ShelfView());
        return "addShelf";
    }

    /**
     * Добавление новой полки
     */
    @RequestMapping(value = "shelf/addShelf/submit", method = RequestMethod.POST)
    public String update(@ModelAttribute ShelfView shelfView) {
        String name = shelfView.getName();
        String description = shelfView.getDescription();
        ShelfView newShelf = new ShelfView(name, description);
        shelfService.save(newShelf);
        return "redirect:/shelf";
    }
}
