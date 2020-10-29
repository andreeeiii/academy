package com.academy.learning.account;

import com.academy.learning.model.Account;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Test class for {@link AccountService}
 */
public class AccountServicesShould {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final static String createAccountURL = "http://localhost:8082/account";
    private final static RestTemplate restTemplate = new RestTemplate();
    private final static HttpHeaders headers = new HttpHeaders();;
    private final static JSONObject accountJsonObject = new JSONObject();

    @BeforeClass
    public static void runBeforeAllTestMethods() throws JSONException {

        headers.setContentType(MediaType.APPLICATION_JSON);
        accountJsonObject.put("username", "testUsername");
        accountJsonObject.put("password", "testPassword");
        accountJsonObject.put("email", "testEmail");
    }

    @Test
    public void createAccount() {

        HttpEntity<String> request = new HttpEntity<>(accountJsonObject.toString(), headers);

        ResponseEntity<Account> response = restTemplate.postForEntity(createAccountURL, request, Account.class);
        //JsonNode root = objectMapper.readTree(response.getBody(), Account.class);

        //assertNotNull(response.getBody());
        //assertNotNull(root.path("name").asText());
    }
}
