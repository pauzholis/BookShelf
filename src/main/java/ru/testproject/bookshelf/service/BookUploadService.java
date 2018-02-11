package ru.testproject.bookshelf.service;


import java.io.IOException;

public interface BookUploadService {
    /**
     * Создание страницы книги
     */
    void createBookPage(String filePath) throws IOException;

}
