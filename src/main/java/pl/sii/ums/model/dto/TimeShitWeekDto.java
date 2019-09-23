package pl.sii.ums.model.dto;

import lombok.Getter;
import lombok.Setter;

public class TimeShitWeekDto {

	public TimeShitWeekDto(int dayInWeek, int weekNumber, TimeShitDayDto[] days) {
		this.dayInWeek = dayInWeek;
		this.weekNumber = weekNumber;
		this.days = new TimeShitDayDto[7];
		this.days = days;
	}
	
	@Getter
	@Setter
	private int dayInWeek;

	@Getter
	@Setter
	private int weekNumber;
	

	@Getter
	@Setter
	private TimeShitDayDto[] days;

}
