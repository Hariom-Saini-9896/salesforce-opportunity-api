package com.example.opportunity.model;

public class OpportunityDTO {
    private String id;
    private String accountId;
    private String subject;
    private String status;
    private String dueDate;

    public OpportunityDTO() {}

    public OpportunityDTO(String id, String accountId, String subject, String status, String dueDate) {
        this.id = id;
        this.accountId = accountId;
        this.subject = subject;
        this.status = status;
        this.dueDate = dueDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
}
