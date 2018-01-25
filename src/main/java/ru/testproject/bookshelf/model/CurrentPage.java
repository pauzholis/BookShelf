package ru.testproject.bookshelf.model;

/**
 * Текущая страница
 */
public class CurrentPage {
    /**
     * Пользователь, читающий данную книгу
     */
    private User user;

    /**
     * Страница, которую читает пользователь
     */
    private Page page;

    public CurrentPage() {
    }

    public CurrentPage(User user, Page page) {
        this.user = user;
        this.page = page;
    }

    public User getUser() {
        return user;
    }

    public Page getPage() {
        return page;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
