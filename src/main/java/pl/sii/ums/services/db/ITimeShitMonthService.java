package pl.sii.ums.services.db;

import java.util.List;
import java.util.Optional;

import pl.sii.ums.model.repository.entity.TimeShitMonth;

public interface ITimeShitMonthService {

	public List<TimeShitMonth> findAll();
	public Optional<TimeShitMonth> findById(Long id);
	public Optional<TimeShitMonth> findByPeriod(String period);
	public void save(TimeShitMonth entity);
	
}
