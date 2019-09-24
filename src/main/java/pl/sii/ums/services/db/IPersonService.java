package pl.sii.ums.services.db;

import java.util.List;
import java.util.Optional;

import pl.sii.ums.model.dto.PersonDto;

//Interfejs definujący metody które będą używane przez serwis
public interface IPersonService {
	
	public List<PersonDto> findAll();
	public Optional<PersonDto> findById(Long id);
}
