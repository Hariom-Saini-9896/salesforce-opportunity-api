package com.example.opportunity.model;

import java.util.Map;

public class OpportunityDTO {
    private String id;
    private String accountId;
    private String name;
    private String stageName;
    private String closeDate;
    private Map<String, Object> attributes; // <- New field

    public OpportunityDTO(String id, String accountId, String name, String stageName, String closeDate, Map<String, Object> attributes) {
        this.id = id;
        this.accountId = accountId;
        this.name = name;
        this.stageName = stageName;
        this.closeDate = closeDate;
        this.attributes = attributes;
    }

    // Getters and setters (or use Lombok @Data if preferred)

    public String getId() { return id; }
    public String getAccountId() { return accountId; }
    public String getName() { return name; }
    public String getStageName() { return stageName; }
    public String getCloseDate() { return closeDate; }
    public Map<String, Object> getAttributes() { return attributes; }

    public void setId(String id) { this.id = id; }
    public void setAccountId(String accountId) { this.accountId = accountId; }
    public void setName(String name) { this.name = name; }
    public void setStageName(String stageName) { this.stageName = stageName; }
    public void setCloseDate(String closeDate) { this.closeDate = closeDate; }
    public void setAttributes(Map<String, Object> attributes) { this.attributes = attributes; }
}
