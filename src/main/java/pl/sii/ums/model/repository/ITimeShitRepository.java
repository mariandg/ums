package pl.sii.ums.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.sii.ums.model.repository.entity.TimeShit;

@Repository
public interface ITimeShitRepository extends CrudRepository<TimeShit, Long>{
	
}
