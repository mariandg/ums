package pl.sii.ums.services.db.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import pl.sii.ums.MockitoExtension;
import pl.sii.ums.model.dto.ProjectDto;
import pl.sii.ums.model.repository.IProjectRepository;
import pl.sii.ums.model.repository.entity.Project;
import pl.sii.ums.services.converter.impl.ProjectConverter;

@ExtendWith(MockitoExtension.class)
public class ProjectServiceImplTest {

    @Mock
    private ProjectServiceImpl projectServiceImpl = mock(ProjectServiceImpl.class);
    
    @Mock
    private IProjectRepository projectRepository;

    private ProjectConverter projectConverter = new ProjectConverter();
    
    private ProjectDto project;

    private ProjectDto project2;
    
    
    @Nested
    class RepositoryTest {
    	
    	private Optional<Project> project;
    	
    	@BeforeEach
    	public void setUp() {
    		
    		Project projectTmp = new Project();
    		projectTmp.setProjectId(1L);
    		projectTmp.setName("Projekt A");
    		projectTmp.setDescription("Nowy");
    		projectTmp.setTimeShits(null);
    		project = Optional.of(projectTmp);
    		
    		when(projectRepository.findById(1L)).thenReturn(project);
    	}
    	
    	@Test
    	public void findByIdTest() {
    		Optional<Project> projectEntity = projectRepository.findById(1L);
    		
    		assertTrue(projectEntity.isPresent());    		
    		
    		ProjectDto projectDto = projectConverter.createFromEntity(projectEntity.get());
    		
    		assertEquals(new Long(1), projectEntity.get().getProjectId());
    		assertEquals("Projekt A", projectEntity.get().getName());
    		assertEquals("Nowy", projectEntity.get().getDescription());
    		assertEquals(null, projectEntity.get().getTimeShits());

    		assertEquals(new Long(1), projectDto.getProjectId());
    		assertEquals("Projekt A", projectDto.getName());
    		assertEquals("Nowy", projectDto.getDescription());
    		assertEquals(null, projectDto.getTimeShits());
    		
    	}
    	
    	@Test
    	public void findByIdEmptyTest() {

    		project = Optional.empty();
    		when(projectRepository.findById(1L)).thenReturn(project);
    		Optional<Project> projectEntity = projectRepository.findById(1L);
    		
    		assertFalse(projectEntity.isPresent());    		

    		assertEquals(Optional.empty(), projectEntity);
    		
    	}
    }
    
    
    
    @BeforeEach
    public void setUp() {
    	
    	project = new ProjectDto();
        project.setProjectId(1L);
        project.setName("Projekt A");
        project.setDescription("Opis");
        project.setTimeShits(null);
        Optional<ProjectDto> optProject = Optional.of(project);

    	project2 = new ProjectDto();
        project2.setProjectId(2L);
        project2.setName("Projekt B");
        project2.setDescription("Opis");
        project2.setTimeShits(null);
        
        List<ProjectDto> projects = new ArrayList<ProjectDto>();
        projects.add(project);
        projects.add(project2);

        when(projectServiceImpl.findAll()).thenReturn(projects);
        
        when(projectServiceImpl.findById(project.getProjectId())).thenReturn(optProject);
        

    }
    
    @Test
    public void findProjectByIdAndCompareDataTest() {

        Optional<ProjectDto> optionalProject = projectServiceImpl.findById(1L);
        assertTrue(optionalProject.isPresent());
        assertThat(optionalProject.get().getName()).isEqualTo(project.getName());
        assertThat(optionalProject.get().getDescription()).isEqualTo(project.getDescription());
        assertThat(optionalProject.get().getTimeShits()).isEqualTo(project.getTimeShits());

    }
    
    @Test
    public void findProjectByIdEmptyTest() {

        Optional<ProjectDto> optionalProject = Optional.empty();
        assertFalse(optionalProject.isPresent());
        optionalProject = null;
        assertNull(optionalProject);

    }
    
    @Test
    public void findProjectAllAndCompareDataTest() {

        Iterable<ProjectDto> iterableProjects = projectServiceImpl.findAll();        
        Iterator<ProjectDto> itr = iterableProjects.iterator();
        
        assertTrue(itr.hasNext());        
        ProjectDto projectToCheck = itr.next();
        
        assertThat(projectToCheck.getName()).isEqualTo(project.getName());
        assertThat(projectToCheck.getDescription()).isEqualTo(project.getDescription());
        assertThat(projectToCheck.getTimeShits()).isEqualTo(project.getTimeShits());
        

        assertTrue(itr.hasNext());        
        projectToCheck = itr.next();
        
        assertThat(projectToCheck.getName()).isEqualTo(project2.getName());
        assertThat(projectToCheck.getDescription()).isEqualTo(project2.getDescription());
        assertThat(projectToCheck.getTimeShits()).isEqualTo(project2.getTimeShits());

    }
}
