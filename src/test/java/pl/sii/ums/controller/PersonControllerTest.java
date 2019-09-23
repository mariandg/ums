package pl.sii.ums.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import pl.sii.ums.model.dto.PersonDto;
import pl.sii.ums.model.dto.ProjectDto;
import pl.sii.ums.services.db.impl.PersonServiceImpl;

@DisplayName("PersonController Test")
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(Lifecycle.PER_CLASS)
public class PersonControllerTest {

    @MockBean
	private PersonServiceImpl personService;
    
    @Autowired
    private TestRestTemplate restTemplate;

    private List<PersonDto> allPersonsDto;
    
    @Nested
    @DisplayName("Get Projects Method Test")
    class getPersons {
    	
        @SuppressWarnings({ "unchecked", "rawtypes" })
        @Test
        @DisplayName("List is equal to null")
        public void noElementsProjectsControllerTest()
          throws Exception {

        	when(personService.findAll()).thenReturn(null);
        	restTemplate.withBasicAuth("user", "password");
        	
        	ResponseEntity<List> response = restTemplate.getForEntity("/persons/all",List.class);
        	assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        	assertThat(response.getBody()).isEqualTo(null);

        }
        
        @SuppressWarnings("rawtypes")
        @Test
        @DisplayName("List have 2 elements")
        public void twoElementsProjectsControllerTest()
          throws Exception {
        	
            PersonDto personDto = new PersonDto(1L,"test", "test", 21, 90000000000L, 1);
            PersonDto personDto2 = new PersonDto(2L,"test2", "test2", 21, 90000000001L, 1);
            
            allPersonsDto = Arrays.asList(personDto, personDto2);
        	when(personService.findAll()).thenReturn(allPersonsDto);

        	restTemplate.withBasicAuth("user", "password");
        	ResponseEntity<List> response = restTemplate.getForEntity("/persons/all",List.class);
        	assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        	assertThat(response.getBody().size()).isEqualTo(2);
        	assertThat(response.getBody().equals(allPersonsDto));

        }
    }

    
    @Nested
    @DisplayName("Get Project By Id Method Test")
    class getPersonById {
    	
         @Test
         @DisplayName("Get By Id")
         public void byIdProjectsControllerTest()
           throws Exception {
         	
            Optional<PersonDto> personDto = Optional.of(new PersonDto(1L,"test", "test", 21, 90000000000L, 1));
             
         	when(personService.findById(1L)).thenReturn(personDto);

        	restTemplate.withBasicAuth("user", "password");
         	ResponseEntity<ProjectDto> response = restTemplate.getForEntity("/persons/1",ProjectDto.class);
         	assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
         	assertTrue(personDto.isPresent());
         	assertThat(response.getBody().equals(personDto.get()));

         }
         
         @Test
         @DisplayName("Get By Id with empty result")
         public void byIdEmptyPersonsControllerTest()
           throws Exception {
         	
        	 Optional<PersonDto> personDto = Optional.empty();
             
         	when(personService.findById(1L)).thenReturn(personDto);

        	restTemplate.withBasicAuth("user", "password");
         	ResponseEntity<ProjectDto> response = restTemplate.getForEntity("/persons/1",ProjectDto.class);
         	assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
         	assertFalse(personDto.isPresent());
         	personDto = null;
         	assertNull(personDto);

         }
    }

}
