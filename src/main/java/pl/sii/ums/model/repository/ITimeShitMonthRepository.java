package pl.sii.ums.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pl.sii.ums.model.repository.entity.TimeShitMonth;

@Repository
public interface ITimeShitMonthRepository extends CrudRepository<TimeShitMonth, Long>{
	
	@Query("FROM TimeShitMonth tsm WHERE tsm.period = :period")
	public Optional<TimeShitMonth> findByPeriod(@Param("period") String period);
	
}
