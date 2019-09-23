package pl.sii.ums.services.db.impl;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import pl.sii.ums.model.dto.PersonDto;
import pl.sii.ums.model.repository.IPersonRepository;
import pl.sii.ums.model.repository.entity.Person;
import pl.sii.ums.services.converter.impl.PersonConverter;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class PersonServiceImplTest {
	
	@Mock
	private IPersonRepository personRepository;

	@Mock
	private PersonConverter personConverter;
	
	@InjectMocks
	private PersonServiceImpl personServiceImpl;
	
	private Optional<Person> personEntityOpt;
	private Optional<Person> personEntityOptEmpty;
	private List<PersonDto> personDtoList;
	private List<Person> personList;
	private PersonDto personDto;
	
	@BeforeAll
	public void setUp() {
		Person personEntity = new Person();
		personEntity.setPersonId(1L);
		personEntity.setName("Tomasz");
		personEntity.setSurname("Tyry");
		personEntity.setAge(25);
		personEntity.setPesel(12345678901L);
		personEntity.setPositionId(1);

		Person personEntity2 = new Person();
		personEntity2.setPersonId(2L);
		personEntity2.setName("Jan");
		personEntity2.setSurname("Kajan");
		personEntity2.setAge(27);
		personEntity2.setPesel(12345678902L);
		personEntity2.setPositionId(2);
		
		personDto = new PersonDto(1L, "Tomasz", "Tyry", 25, 12345678901L, 1);
		PersonDto personDto2 = new PersonDto(2L, "Jan", "Kajan", 27, 12345678902L, 2);

		personList = new ArrayList<Person>();
		personList.add(personEntity);
		personList.add(personEntity2);
		
		personDtoList = new ArrayList<PersonDto>();
		personDtoList.add(personDto);
		personDtoList.add(personDto2);
		
		personEntityOpt = Optional.of(personEntity);
		personEntityOptEmpty = Optional.empty();
		
	}
	
	@Test
	public void findById() {
		when(personRepository.findById(1L)).thenReturn(personEntityOpt);
		when(personConverter.createFromEntity(personRepository.findById(1L).get())).thenReturn(personDto);

		Optional<PersonDto> personDtoTmp = personServiceImpl.findById(1L);

		assertTrue(personDtoTmp.isPresent());
		assertTrue(personEntityOpt.isPresent());
		assertEquals(personDto.getClass(), personDtoTmp.get().getClass());
		assertEquals(personEntityOpt.get().getPersonId(), personDtoTmp.get().getPersonId());
		assertEquals(personEntityOpt.get().getName(), personDtoTmp.get().getName());
		assertEquals(personEntityOpt.get().getSurname(), personDtoTmp.get().getSurname());
		assertEquals(personEntityOpt.get().getAge(), personDtoTmp.get().getAge());
		assertEquals(personEntityOpt.get().getPesel(), personDtoTmp.get().getPesel());
		assertEquals(personEntityOpt.get().getPositionId(), personDtoTmp.get().getPositionId());
	}

	@Test
	public void findByIdEmpty() {
		when(personRepository.findById(1L)).thenReturn(personEntityOptEmpty);		
		
		Optional<PersonDto> personTmp = personServiceImpl.findById(1L);
		
		assertFalse(personTmp.isPresent());
		assertEquals(Optional.empty(), personTmp);
	}
	
	@Test
	public void findAll() {
		when(personRepository.findAll()).thenReturn(personList);
		when(personConverter.createDtoFromEntities((List<Person>) personRepository.findAll())).thenReturn(personDtoList);

		List<PersonDto> personDtoListTmp = personServiceImpl.findAll();		
		assertEquals(2,personDtoListTmp.size());
	}
	
	@Test
	public void findAllEmpty() {
		List<Person> personListEmpty = new ArrayList<Person>();
		
		when(personRepository.findAll()).thenReturn(personListEmpty);
				
		List<Person> personsTmp = (List<Person>) personRepository.findAll();

		List<PersonDto> personDtoListTmp = personServiceImpl.findAll();
		assertFalse(personsTmp.size() > 0);
		assertEquals(null,personDtoListTmp);
	}
	
	@Test
	public void findAllNull() {		
		when(personRepository.findAll()).thenReturn(null);
				
		List<Person> personsTmp = (List<Person>) personRepository.findAll();

		List<PersonDto> personDtoListTmp = personServiceImpl.findAll();
		assertFalse(personsTmp != null);
		assertEquals(null,personDtoListTmp);
	}
}
