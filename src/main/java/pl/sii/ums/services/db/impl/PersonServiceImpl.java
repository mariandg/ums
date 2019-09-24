package pl.sii.ums.services.db.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.sii.ums.model.dto.PersonDto;
import pl.sii.ums.model.repository.IPersonRepository;
import pl.sii.ums.model.repository.entity.Person;
import pl.sii.ums.services.converter.impl.PersonConverter;
import pl.sii.ums.services.db.IPersonService;

//Serwis pobierający dane z bazy danych oraz konwertujący DAO - > DTO
//Dodatkowo w tej warstwie powinny znależć się metody odpowiedzialne 
//Za implementację logiki biznesowej
@Service
public class PersonServiceImpl implements IPersonService{
	
	@Autowired
	private IPersonRepository personRepository;

	@Autowired
	private PersonConverter personConverter;
	
	public List<PersonDto> findAll() {		
		List<Person> persons = (List<Person>) personRepository.findAll();
		
		if(persons != null && persons.size() > 0)
			return personConverter.createDtoFromEntities(persons);
		else return null;
	}

	@Override
	public Optional<PersonDto> findById(Long id) {
		Optional<Person> person = personRepository.findById(id);
		
		if(person.isPresent())
			return Optional.of(personConverter.createFromEntity(person.get()));
		else return Optional.empty();
	}
}
