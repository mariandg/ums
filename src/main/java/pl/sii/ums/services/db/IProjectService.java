package pl.sii.ums.services.db;

import java.util.Map;
import java.util.Optional;

import pl.sii.ums.model.dto.ProjectDto;
import pl.sii.ums.model.repository.entity.Project;

public interface IProjectService {

	public Iterable<ProjectDto> findAll();
	public Optional<ProjectDto> findById(Long id);
	public Map<Long, String> findAllAsDict();

}
