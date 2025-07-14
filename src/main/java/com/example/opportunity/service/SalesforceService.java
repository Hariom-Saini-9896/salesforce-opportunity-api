package com.example.opportunity.service;

import com.example.opportunity.model.OpportunityDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class SalesforceService {

    private final RestTemplate restTemplate;
    private final String instanceUrl;
    private final String accessToken;

    public SalesforceService(RestTemplate restTemplate,
                             @Value("${sf.instance-url}") String instanceUrl,
                             @Value("${sf.access-token}") String accessToken) {
        this.restTemplate = restTemplate;
        this.instanceUrl = instanceUrl;
        this.accessToken = accessToken;
    }

    public List<OpportunityDTO> fetchOpportunities() {
        try {
            String soql = "SELECT Id, AccountId, Name, StageName, CloseDate FROM Opportunity";
            String url = String.format("%s/services/data/v64.0/query?q=%s", instanceUrl,
                    URLEncoder.encode(soql, StandardCharsets.UTF_8));

            HttpHeaders headers = new HttpHeaders();
            headers.setBearerAuth(accessToken);
            HttpEntity<Void> entity = new HttpEntity<>(headers);

            ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.GET, entity, Map.class);

            List<Map<String, Object>> records = (List<Map<String, Object>>) response.getBody().get("records");
            if (records == null) {
                return Collections.emptyList();
            }

            return records.stream().map(rec -> new OpportunityDTO(
                    (String) rec.get("Id"),
                    (String) rec.get("AccountId"),
                    (String) rec.get("Name"),
                    (String) rec.get("StageName"),
                    (String) rec.get("CloseDate")
            )).toList();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
