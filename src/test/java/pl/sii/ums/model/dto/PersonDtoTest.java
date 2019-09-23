package pl.sii.ums.model.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PersonDtoTest {

	@Test
	public void checkNoArgConstructor() {
		PersonDto person =  new PersonDto();
		assertEquals(PersonDto.class, person.getClass());
		assertEquals(null, person.getPersonId());
		assertEquals(null, person.getName());
		assertEquals(null, person.getSurname());
		assertEquals(0, person.getAge());
		assertEquals(0, person.getPesel());
		assertEquals(0, person.getPositionId());
	}
	
	@Test
	public void checkArgConstructor() {
		PersonDto person =  new PersonDto(1L, "Jan", "Nowak", 25, 90000000000L, 1);
		assertEquals(PersonDto.class, person.getClass());
		assertEquals(new Long(1), person.getPersonId());
		assertEquals("Jan", person.getName());
		assertEquals("Nowak", person.getSurname());
		assertEquals(25, person.getAge());
		assertEquals(90000000000L, person.getPesel());
		assertEquals(1, person.getPositionId());
	}
	
	@Test
	public void checkSetters() {
		PersonDto person =  new PersonDto();
		person.setPersonId(1L);
		person.setName("Jan");
		person.setSurname("Nowak");
		person.setAge(25);
		person.setPesel(90000000000L);
		person.setPositionId(1);
		assertEquals(new Long(1), person.getPersonId());
		assertEquals("Jan", person.getName());
		assertEquals("Nowak", person.getSurname());
		assertEquals(25, person.getAge());
		assertEquals(90000000000L, person.getPesel());
		assertEquals(1, person.getPositionId());
	}
}
