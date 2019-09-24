package pl.sii.ums.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import pl.sii.ums.model.dto.PersonDto;
import pl.sii.ums.services.db.impl.PersonServiceImpl;

@RestController
public class PersonController {

	//Pobieranie Bean-a serwisu do pobierania użytkowników
	@Autowired
	private PersonServiceImpl personService;

	//Przekazanie listy osób do REST kontrolera
	@GetMapping("/persons/all")
	public List<PersonDto> getAllPersons(Model model) throws JsonProcessingException {
		
		List<PersonDto> personsDto = personService.findAll();
		return personsDto;
	}

	//Przekazanie konkretnej osoby do REST kontrolera
	@GetMapping("/persons/{id}")
	public PersonDto getPersonById(@PathVariable(value = "id") Long personId, Model model) {
		Optional<PersonDto> person = personService.findById(personId);
		if(person.isPresent())
			return person.get();
		return null;
	}

}
