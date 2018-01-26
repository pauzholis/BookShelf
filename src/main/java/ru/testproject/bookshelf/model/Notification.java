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

    /**
     * Адресс электронной почты
     */
    private String adress;

    /**
     * Дата отправки сообщения
     */
    private String massage;

    public Notification() {
    }

    public Notification(Channel channel, Date date, String adress, String massage) {
        this.channel = channel;
        this.date = date;
        this.adress = adress;
        this.massage = massage;
    }

    public Long getId() {
        return id;
    }

    public Channel getChannel() {
        return channel;
    }

    public Date getDate() {
        return date;
    }

    public String getAdress() {
        return adress;
    }

    public String getMassage() {
        return massage;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }
}
