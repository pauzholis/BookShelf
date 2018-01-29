package ru.testproject.bookshelf.model;

import javax.persistence.*;

/**
 * Ответ на запрос
 */
@Entity
@Table(name = "access_response")
public class AccessResponse {
    /**
     * Запрос на который дается ответ
     */
    @ManyToOne
    @JoinColumn(name = "request_id")
    private AccessRequest accessRequest;

    /**
     * Текст ответа на запрос
     */
    @Column(name = "massage")
    private String massage;

    /**
     * Статус одобрения запроса
     */
    @Column(name = "approved")
    private Boolean approved;

    /**
     * Служебное поле hibernate
     */
    @Version
    private Integer version;

    /**
     * Конструктор для hibernate
     */
    public AccessResponse() {
    }

    public AccessResponse(AccessRequest accessRequest, String massage, Boolean approved) {
        this.accessRequest = accessRequest;
        this.massage = massage;
        this.approved = approved;
    }

    public AccessRequest getAccessRequest() {
        return accessRequest;
    }

    public String getMassage() {
        return massage;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public void setAccessRequest(AccessRequest accessRequest) {
        this.accessRequest = accessRequest;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
