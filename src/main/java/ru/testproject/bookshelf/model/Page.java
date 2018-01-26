package ru.testproject.bookshelf.model;

/**
 * Страница
 */
public class Page {

    /**
     * Идентификатор страницы
     */
    private Long id;

    /**
     *Книга, которой принадлежит страница
     */
    private Book book;

    /**
     * Номер страницы
     */
    private Integer number;

    /**
     * Содержимое страницы
     */
    private String content;

    public Page() {
    }

    public Page(Book book, Integer number, String content) {
        this.book = book;
        this.number = number;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public Integer getNumber() {
        return number;
    }

    public String getContent() {
        return content;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
