package pl.sii.ums.services.converter.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import pl.sii.ums.model.dto.ProjectDto;
import pl.sii.ums.model.repository.entity.Project;
import pl.sii.ums.services.converter.IGenericConverter;

@Service
public class ProjectConverter implements IGenericConverter <Project, ProjectDto> {

	@Override
	public Project createFromDto(ProjectDto dto) {
		return updateEntity(new Project(), dto);
	}

	@Override
	public ProjectDto createFromEntity(Project entity) {
		if(entity != null) {
			ProjectDto personDto = new ProjectDto();
			BeanUtils.copyProperties(entity, personDto);
			return personDto;
		}else return null;
	}

	@Override
	public Project updateEntity(Project entity, ProjectDto dto) {
		if(dto != null) {
			BeanUtils.copyProperties(dto, entity);
			return entity;
		}else return null;
	}

}
