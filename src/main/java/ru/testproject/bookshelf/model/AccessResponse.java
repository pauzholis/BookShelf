package ru.testproject.bookshelf.model;

/**
 * Ответ на запрос
 */
public class AccessResponse {
    /**
     * Запрос на который дается ответ
     */
    private AccessRequest accessRequest;

    /**
     * Текст ответа на запрос
     */
    private String massage;

    /**
     * Статус одобрения запроса
     */
    private Boolean approved;

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
}
