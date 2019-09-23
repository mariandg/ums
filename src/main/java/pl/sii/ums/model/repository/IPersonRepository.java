package pl.sii.ums.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.sii.ums.model.repository.entity.Person;

@Repository
public interface IPersonRepository extends CrudRepository<Person, Long>{

}
