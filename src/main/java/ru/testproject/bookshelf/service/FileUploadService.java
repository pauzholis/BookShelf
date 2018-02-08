package ru.testproject.bookshelf.service;


import java.io.IOException;

public interface FileUploadService {
    /**
     * Загрузка файла книги
     */
    String uploadFile(byte[] fileContent, String fileName) throws IOException;
}
