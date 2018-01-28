package ru.testproject.bookshelf.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Сообщение пользователю
 */
@Entity
@Table(name = "notification")
public class Notification {
    /**
     * Идентификатор сообщения
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    /**
     * Канал, посредством которого осуществляется передача сообщения
     */
    @Enumerated
    @Column(name = "channel")
    private Channel channel;

    /**
     * Дата активации сообщения
     */
    @Temporal(value = TemporalType.DATE)
    @Column(name = "date")
    private Date date;

    /**
     * Адресс электронной почты
     */
    @Column(name = "adress")
    private String adress;

    /**
     * Дата отправки сообщения
     */
    @Column(name = "message")
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
