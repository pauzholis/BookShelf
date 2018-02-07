package ru.testproject.bookshelf.service;

/**
 * Сервис для получения хэша строки
 */
public interface DigestService {

    /**
     * Получить хэш строки в формате base64
     *
     * @param source исходная строка
     * @return хэш в формате base64
     */
    String hash(String source);
}
