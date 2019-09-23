package pl.sii.ums.services.db.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.sii.ums.model.repository.IPositionRepository;
import pl.sii.ums.model.repository.entity.Position;
import pl.sii.ums.services.db.IPositionService;

@Component
public class PositionServiceImpl implements IPositionService{

	@Autowired
	private IPositionRepository positionRepository;
	
	@Override
	public List<Position> findAll() {
		return (List<Position>) positionRepository.findAll();
	}

	@Override
	public Optional<Position> findById(Long id) {
		return positionRepository.findById(id);
	}

}
