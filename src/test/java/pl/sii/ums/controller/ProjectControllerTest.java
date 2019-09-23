package pl.sii.ums.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

import pl.sii.ums.model.dto.ProjectDto;
import pl.sii.ums.services.db.impl.ProjectServiceImpl;

@DisplayName("ProjectController Test")
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(Lifecycle.PER_CLASS)
public class ProjectControllerTest {

    @MockBean
	private ProjectServiceImpl projectService;
    
    @Autowired
    private TestRestTemplate restTemplate;

    private List<ProjectDto> allProjectsDto;
    
    @BeforeAll
    private void setUp() {
    	restTemplate.withBasicAuth("user", "password");
    }
    
    @Nested
    @DisplayName("Get Projects Method Test")
    class getProjects {
    	
        @SuppressWarnings({ "unchecked", "rawtypes" })
        @Test
        @DisplayName("List is equal to null")
        public void noElementsProjectsControllerTest()
          throws Exception {

        	when(projectService.findAll()).thenReturn(null);
        	restTemplate.withBasicAuth("user", "password");
        	ResponseEntity<List> response = restTemplate.getForEntity("/projects",List.class);
        	assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        	assertThat(response.getBody()).isEqualTo(null);

        }
        
        @SuppressWarnings("rawtypes")
        @Test
        @DisplayName("List have 2 elements")
        public void twoElementsProjectsControllerTest()
          throws Exception {
        	
            ProjectDto projectDto = new ProjectDto(1L,"test","test",null);
            ProjectDto projectDto2 = new ProjectDto(2L,"test2","test2",null);
            
            allProjectsDto = Arrays.asList(projectDto,projectDto2);
        	when(projectService.findAll()).thenReturn(allProjectsDto);

        	restTemplate.withBasicAuth("user", "password");
        	ResponseEntity<List> response = restTemplate.getForEntity("/projects",List.class);
        	assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        	assertThat(response.getBody().size()).isEqualTo(2);
        	assertThat(response.getBody().equals(allProjectsDto));

        }
    }
    
    @Nested
    @DisplayName("Get Projects Dict Method Test")
    class getProjectsDict {
    	
        @SuppressWarnings({ "unchecked", "rawtypes" })
        @Test
        @DisplayName("List is equal to null")
        public void noElementsProjectsControllerTest()
          throws Exception {

        	when(projectService.findAllAsDict()).thenReturn(null);

        	restTemplate.withBasicAuth("user", "password");
        	ResponseEntity<Map> response = restTemplate.getForEntity("/projects/dict",Map.class);
        	assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        	assertThat(response.getBody()).isEqualTo(null);

        }
        
        @SuppressWarnings("rawtypes")
        @Test
        @DisplayName("List have 2 elements")
        public void twoElementsProjectsControllerTest()
          throws Exception {

            Map<Long, String> projectsDictionary = new HashMap<Long,String>();
            projectsDictionary.put(1L, "test");
            projectsDictionary.put(2L, "test2");

        	when(projectService.findAllAsDict()).thenReturn(projectsDictionary);

        	restTemplate.withBasicAuth("user", "password");
        	ResponseEntity<Map> response = restTemplate.getForEntity("/projects/dict",Map.class);
        	assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        	assertThat(response.getBody().size()).isEqualTo(2);
        	assertThat(response.getBody().equals(projectsDictionary));

        }
    }
    
    @Nested
    @DisplayName("Get Project By Id Method Test")
    class getProjectById {
    	
         @Test
         @DisplayName("Get By Id")
         public void byIdProjectsControllerTest()
           throws Exception {
         	
            Optional<ProjectDto> projectDto = Optional.of(new ProjectDto(1L,"test","test",null));
             
         	when(projectService.findById(1L)).thenReturn(projectDto);

        	restTemplate.withBasicAuth("user", "password");
         	ResponseEntity<ProjectDto> response = restTemplate.getForEntity("/projects/1",ProjectDto.class);
         	assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
         	assertTrue(projectDto.isPresent());
         	assertThat(response.getBody().equals(projectDto.get()));

         }
         
         @Test
         @DisplayName("Get By Id with empty result")
         public void byIdEmptyProjectsControllerTest()
           throws Exception {
         	
            Optional<ProjectDto> projectDto = Optional.empty();
             
         	when(projectService.findById(1L)).thenReturn(projectDto);

        	restTemplate.withBasicAuth("user", "password");
         	ResponseEntity<ProjectDto> response = restTemplate.getForEntity("/projects/1",ProjectDto.class);
         	assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
         	assertFalse(projectDto.isPresent());
         	projectDto = null;
         	assertNull(projectDto);

         }
    }

}
