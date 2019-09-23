package pl.sii.ums.services.converter.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import pl.sii.ums.model.dto.PersonDto;
import pl.sii.ums.model.repository.entity.Person;
import pl.sii.ums.services.converter.IGenericConverter;

@Service
public class PersonConverter implements IGenericConverter<Person, PersonDto> {

	@Override
	public Person createFromDto(PersonDto dto) {
		return updateEntity(new Person(), dto);
	}

	@Override
	public PersonDto createFromEntity(Person entity) {
		PersonDto personDto = new PersonDto();
		BeanUtils.copyProperties(entity, personDto);
		return personDto;
	}

	@Override
	public Person updateEntity(Person entity, PersonDto dto) {
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

}
