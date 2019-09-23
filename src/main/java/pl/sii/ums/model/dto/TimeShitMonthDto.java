package pl.sii.ums.model.dto;

import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class TimeShitMonthDto {
	
	@Getter
	private Long timeShitMonthid;

	@Getter
	@Setter
	private String name;
	
	@Getter
	@Setter
	private String description;
	
	@Getter
	@Setter
	private String period;
	
	@Getter
	@Setter
	private List<TimeShitDto> timeShit;
}
