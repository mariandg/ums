package pl.sii.ums.services.db;

import java.util.List;
import java.util.Optional;

import pl.sii.ums.model.repository.entity.Position;

public interface IPositionService {
	
	public List<Position> findAll();
	public Optional<Position> findById(Long id);
}
