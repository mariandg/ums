package pl.sii.ums.model.dto;

import lombok.Getter;
import lombok.Setter;

public class TimeShitAnnotationDto {
	
	public TimeShitAnnotationDto(String name, double hours) {
		this.name = name;
		this.hours = hours;
	}
	
	@Getter
	@Setter
	private String name;
	
	@Getter
	@Setter
	private double hours;
	
	
}
