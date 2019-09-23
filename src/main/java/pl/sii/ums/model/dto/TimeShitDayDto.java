package pl.sii.ums.model.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class TimeShitDayDto {

	public TimeShitDayDto(int dayInWeek, int dayNumber, boolean isCurrentMonth, List<TimeShitAnnotationDto> annotations) {
		this.dayInWeek = dayInWeek;
		this.dayNumber = dayNumber;
		this.annotations = annotations;
		this.currentMonth = isCurrentMonth;
	}
	
	@Getter
	@Setter
	private int dayInWeek;

	@Getter
	@Setter
	private int dayNumber;

	@Getter
	@Setter
	private boolean currentMonth;
	
	@Getter
	@Setter
	private List<TimeShitAnnotationDto> annotations;
}
