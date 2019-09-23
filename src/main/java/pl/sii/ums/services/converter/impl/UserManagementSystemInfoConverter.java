package pl.sii.ums.services.converter.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import pl.sii.ums.model.dto.UserManagementSystemInfoDto;
import pl.sii.ums.model.repository.entity.UserManagementSystemInfo;
import pl.sii.ums.services.converter.IGenericConverter;

@Service
public class UserManagementSystemInfoConverter implements IGenericConverter <UserManagementSystemInfo, UserManagementSystemInfoDto> {

	@Override
	public UserManagementSystemInfo createFromDto(UserManagementSystemInfoDto dto) {
		return updateEntity(new UserManagementSystemInfo(), dto);
	}

	@Override
	public UserManagementSystemInfoDto createFromEntity(UserManagementSystemInfo entity) {
		UserManagementSystemInfoDto personDto = new UserManagementSystemInfoDto();
		BeanUtils.copyProperties(entity, personDto);
		return personDto;
	}

	@Override
	public UserManagementSystemInfo updateEntity(UserManagementSystemInfo entity, UserManagementSystemInfoDto dto) {
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

}
