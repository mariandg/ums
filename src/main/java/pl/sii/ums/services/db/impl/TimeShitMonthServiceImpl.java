package pl.sii.ums.services.db.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.sii.ums.model.repository.ITimeShitMonthRepository;
import pl.sii.ums.model.repository.entity.TimeShitMonth;
import pl.sii.ums.services.db.ITimeShitMonthService;

@Service
public class TimeShitMonthServiceImpl implements ITimeShitMonthService{

	@Autowired
	private ITimeShitMonthRepository timeShitMonthRepository;

	@Override
	public List<TimeShitMonth> findAll() {		
		return (List<TimeShitMonth>) timeShitMonthRepository.findAll();
	}

	@Override
	public Optional<TimeShitMonth> findById(Long id) {
		return timeShitMonthRepository.findById(id);
	}

	@Override
	public Optional<TimeShitMonth> findByPeriod(String period) {		
		return timeShitMonthRepository.findByPeriod(period);
	}

	@Override
	public void save(TimeShitMonth entity) {
		timeShitMonthRepository.save(entity);
		
	}
	
	
}
