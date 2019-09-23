package pl.sii.ums.services.db.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.sii.ums.model.dto.ProjectDto;
import pl.sii.ums.model.repository.IProjectRepository;
import pl.sii.ums.model.repository.entity.Project;
import pl.sii.ums.services.converter.impl.ProjectConverter;
import pl.sii.ums.services.db.IProjectService;

@Component
public class ProjectServiceImpl implements IProjectService{
	
	@Autowired
	private IProjectRepository projectRepository;
	
	@Autowired
	private ProjectConverter projectConverter;
	
	public List<ProjectDto> findAll() {		
		
		List<Project> projects = StreamSupport.stream(projectRepository.findAll().spliterator(),false)
											.collect(Collectors.toList());
		if(projects.size()>0)
			return projectConverter.createDtoFromEntities(projects);
		else return null;
	}

	@Override
	public Optional<ProjectDto> findById(Long id) {
		
		Optional<Project> project = projectRepository.findById(id);
		if(project.isPresent())
			return Optional.of(projectConverter.createFromEntity(project.get()));
		else return Optional.empty();
	}

	@Override
	public Map<Long, String> findAllAsDict() {
		
		Map<Long, String> dictionaryList = new HashMap<Long, String>();
		List<ProjectDto> projects = findAll();		
		dictionaryList = projects.stream()
								 .collect(Collectors.toMap(p-> p.getProjectId(), p-> p.getName()));
		return dictionaryList;		
	}
}
