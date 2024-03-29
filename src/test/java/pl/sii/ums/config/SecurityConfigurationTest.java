package pl.sii.ums.config;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SecurityConfigurationTest {
	
    private TestRestTemplate restTemplate;
    private URL base;
    @LocalServerPort int port;
 
    @BeforeEach
    public void setUp() throws MalformedURLException {
        restTemplate = new TestRestTemplate("user", "password");
        base = new URL("http://localhost:" + String.valueOf(port) +"/projects");// + "0"
    }
    
    @Test
    public void loginUserTest()
     throws IllegalStateException, IOException {
        ResponseEntity<String> response 
          = restTemplate.getForEntity(base.toString(), String.class);  
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
 
    @Test
    public void badLoginUserTest() 
      throws Exception {
  
        restTemplate = new TestRestTemplate("user", "wrongpassword");
        ResponseEntity<String> response 
          = restTemplate.getForEntity(base.toString(), String.class);
  
        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
    }
}
