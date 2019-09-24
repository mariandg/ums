package pl.sii.ums.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.sii.ums.model.repository.entity.Person;

//Interfejs do komunikacji z Bazą danych dla tabeli Person. Interfejs rozszerzony o CrudRepository,
//daje nam zestaw metod do manipulacji tabelami w bazie danych 
//C - Create
//R - Read
//U - Update
//D - Delete
@Repository
public interface IPersonRepository extends CrudRepository<Person, Long> {

}
