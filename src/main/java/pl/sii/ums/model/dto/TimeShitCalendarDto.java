package pl.sii.ums.model.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class TimeShitCalendarDto {

	public TimeShitCalendarDto(int daysInMonth, int firstDayInMonth, List<TimeShitWeekDto> weeks) {
		this.daysInMonth = daysInMonth;
		this.firstDayInMonth = firstDayInMonth;
		this.weeks = weeks;
	}
	@Getter
	@Setter
	private int daysInMonth;
	
	@Getter
	@Setter
	private int firstDayInMonth;

	@Getter
	@Setter
	private int cellNumber;
	
	@Getter
	@Setter
	private List<TimeShitWeekDto> weeks;
	
}
