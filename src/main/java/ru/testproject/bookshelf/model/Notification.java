package ru.testproject.bookshelf.model;

import java.util.Date;

/**
 * Сообщение пользователю
 */
public class Notification {
    /**
     * Идентификатор сообщения
     */
    private Long id;

    /**
     * Канал, посредством которого осуществляется передача сообщения
     */
    private Channel channel;

    /**
     * Дата отправки сообщения
     */
    private Date date;


}
