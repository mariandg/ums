package pl.sii.ums.services.db;

import java.util.List;
import java.util.Optional;

import pl.sii.ums.model.repository.entity.TimeShit;

public interface ITimeShitService {

	public List<TimeShit> findAll();
	public Optional<TimeShit> findById(Long id);
	
}
