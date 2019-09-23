package pl.sii.ums.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import pl.sii.ums.model.dto.ProjectDto;
import pl.sii.ums.model.repository.entity.Project;
import pl.sii.ums.services.converter.impl.ProjectConverter;
import pl.sii.ums.services.db.impl.ProjectServiceImpl;

@RestController
public class ProjectController {

	@Autowired
	private ProjectServiceImpl projectService;
		
	@GetMapping("/projects/dict")
	public Map<Long, String> getProjectsAsDictionary() {
		
		Map<Long, String> projectsDictionary = projectService.findAllAsDict();
		return projectsDictionary;
	}
	
	@GetMapping("/projects")
	public List <ProjectDto> getProjects() {
		
		List<ProjectDto> projectsDto = projectService.findAll();
		return projectsDto;
	}
	
	@GetMapping("/projects/{id}")
	public ProjectDto getProjectById(@PathVariable Long id) {
		
		ProjectDto projectDto = null;
		if(projectService.findById(id).isPresent())
			projectDto = projectService.findById(id).get();
		return projectDto;
	}
}
