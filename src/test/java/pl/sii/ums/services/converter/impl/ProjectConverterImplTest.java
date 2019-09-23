package pl.sii.ums.services.converter.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import pl.sii.ums.model.dto.ProjectDto;
import pl.sii.ums.model.repository.entity.Project;


@SpringBootTest
@DisplayName("Project Converter Test")
public class ProjectConverterImplTest {

    @Autowired
    private ProjectConverter projectConverter;

    @Test
    @DisplayName("Project Converter isNotNull Test")
    public void ProjectConverterIsNotNullTest() {
    	assertThat(projectConverter).isNotNull();
    }
    
    @Test
    @DisplayName("Project Converter Single Object Convertion Test")
    public void ProjectConvertionOfSingleObjectTest() {
    	assertThat(projectConverter.createFromDto(null)).isNull();
    	assertThat(projectConverter.createFromEntity(null)).isNull();
    	assertThat(projectConverter.createFromDto(new ProjectDto())).isNotNull();
    	assertThat(projectConverter.createFromEntity(new Project())).isNotNull();
    }
       
    @Test
    @DisplayName("Project Converter Multiple Object Convertion Test")
    public void ProjectConvertionOfMultipleObjectsTest() {
    	assertThat(projectConverter.createDtoFromEntities(null)).isNull();
    	assertThat(projectConverter.createEntityFromDtos(null)).isNull();
    	assertThat(projectConverter.createDtoFromEntities(new ArrayList<Project>())).isNotNull();
    	assertThat(projectConverter.createEntityFromDtos(new ArrayList<ProjectDto> ())).isNotNull();
    }
      
    
    @Nested
    @TestInstance(Lifecycle.PER_CLASS)
    @DisplayName("Nested Project Converter Data Test")
	class DetailedTest {
    	
    	private ProjectDto projectDtoToCheck = null;
    	private ProjectDto projectDtoToCheck2 = null;
    	private Project projectEntityToCheck = null;
    	private Project projectEntityToCheck2 = null;
    	private List<ProjectDto> projectsDto = null;
    	private List<Project> projectsEntity = null;
    	
    	
    	@BeforeAll
    	void setup() {
	    	projectDtoToCheck = new ProjectDto(1L,"Nazwa Projektu","Opis Projektu",null);
	    	projectDtoToCheck2 = new ProjectDto(2L,"Nazwa Projektu 2","Opis Projektu 2",null);
	    	projectEntityToCheck = new Project();
	    	projectEntityToCheck2 = new Project();
	    	
	    	projectsDto = new ArrayList<ProjectDto>();
	    	projectsDto.add(projectDtoToCheck);
	    	projectsDto.add(projectDtoToCheck2);

	    	projectEntityToCheck.setProjectId(1L);
	    	projectEntityToCheck.setName("Nazwa Projektu");
	    	projectEntityToCheck.setDescription("Opis Projektu");
	    	projectEntityToCheck.setTimeShits(null);
	    	
	    	projectEntityToCheck2.setProjectId(2L);
	    	projectEntityToCheck2.setName("Nazwa Projektu 2");
	    	projectEntityToCheck2.setDescription("Opis Projektu 2");
	    	projectEntityToCheck2.setTimeShits(null);
	    	
	    	projectsEntity = new ArrayList<Project>();
	    	projectsEntity.add(projectEntityToCheck);
	    	projectsEntity.add(projectEntityToCheck2);
    	}
    	
    	@RepeatedTest(1)
        @DisplayName("Project Converter Single Object Data Convertion Test")
	    public void ProjectConvertionOfSingleObjectDataTest() {
	    	
	    	//Check conversion from DTO
	    	assertThat(projectConverter.createFromDto(projectDtoToCheck).getProjectId()).isEqualTo(projectEntityToCheck.getProjectId());
	    	assertThat(projectConverter.createFromDto(projectDtoToCheck).getName()).isEqualTo(projectEntityToCheck.getName());
	    	assertThat(projectConverter.createFromDto(projectDtoToCheck).getDescription()).isEqualTo(projectEntityToCheck.getDescription());
	    	assertThat(projectConverter.createFromDto(projectDtoToCheck).getTimeShits()).isEqualTo(projectEntityToCheck.getTimeShits());
	    	
	    	//Check conversion from Entity
	    	assertThat(projectConverter.createFromEntity(projectEntityToCheck).getProjectId()).isEqualTo(projectDtoToCheck.getProjectId());
	    	assertThat(projectConverter.createFromEntity(projectEntityToCheck).getName()).isEqualTo(projectDtoToCheck.getName());
	    	assertThat(projectConverter.createFromEntity(projectEntityToCheck).getDescription()).isEqualTo(projectDtoToCheck.getDescription());
	    	assertThat(projectConverter.createFromEntity(projectEntityToCheck).getTimeShits()).isEqualTo(projectDtoToCheck.getTimeShits());

	    }
    	
    	@RepeatedTest(2)
        @DisplayName("Project Converter Multiple Object Data Convertion Test")
	    public void ProjectConvertionOfMultipleObjectDataTest(RepetitionInfo repetitionInfo) {
	    	
	    	//Check conversion from DTO
	    	assertThat(projectConverter.createEntityFromDtos(projectsDto).get(repetitionInfo.getCurrentRepetition()-1).getProjectId())
	    									.isEqualTo(projectsEntity.get(repetitionInfo.getCurrentRepetition()-1).getProjectId());
	    	assertThat(projectConverter.createEntityFromDtos(projectsDto).get(repetitionInfo.getCurrentRepetition()-1).getName())
	    									.isEqualTo(projectsEntity.get(repetitionInfo.getCurrentRepetition()-1).getName());
	    	assertThat(projectConverter.createEntityFromDtos(projectsDto).get(repetitionInfo.getCurrentRepetition()-1).getDescription())
											.isEqualTo(projectsEntity.get(repetitionInfo.getCurrentRepetition()-1).getDescription());
	    	assertThat(projectConverter.createEntityFromDtos(projectsDto).get(repetitionInfo.getCurrentRepetition()-1).getTimeShits())
											.isEqualTo(projectsEntity.get(repetitionInfo.getCurrentRepetition()-1).getTimeShits());
	    	
	    	//Check conversion from Entity
	    	assertThat(projectConverter.createDtoFromEntities(projectsEntity).get(repetitionInfo.getCurrentRepetition()-1).getProjectId())
	    									.isEqualTo(projectsDto.get(repetitionInfo.getCurrentRepetition()-1).getProjectId());
	    	assertThat(projectConverter.createDtoFromEntities(projectsEntity).get(repetitionInfo.getCurrentRepetition()-1).getName())
											.isEqualTo(projectsDto.get(repetitionInfo.getCurrentRepetition()-1).getName());
	    	assertThat(projectConverter.createDtoFromEntities(projectsEntity).get(repetitionInfo.getCurrentRepetition()-1).getDescription())
											.isEqualTo(projectsDto.get(repetitionInfo.getCurrentRepetition()-1).getDescription());
	    	assertThat(projectConverter.createDtoFromEntities(projectsEntity).get(repetitionInfo.getCurrentRepetition()-1).getTimeShits())
											.isEqualTo(projectsDto.get(repetitionInfo.getCurrentRepetition()-1).getTimeShits());
	    }
    }      

}
