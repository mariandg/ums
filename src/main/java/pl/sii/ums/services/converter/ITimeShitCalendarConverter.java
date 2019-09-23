package pl.sii.ums.services.converter;

import pl.sii.ums.model.dto.TimeShitCalendarDto;
import pl.sii.ums.model.repository.entity.TimeShitMonth;

public interface ITimeShitCalendarConverter {
	
	public TimeShitCalendarDto convertFromEntity(int yearNr, TimeShitMonth month);
	
	public TimeShitMonth convertFromDto (int monthNr, TimeShitCalendarDto calendar);
}
