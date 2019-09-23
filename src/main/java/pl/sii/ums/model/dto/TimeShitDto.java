package pl.sii.ums.model.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class TimeShitDto {

	@Getter
	private Long timeShitId;

	@Getter
	@Setter
	private int day;

	@Getter
	@Setter
	private int workedHours;

	@Getter
	@Setter
	private ProjectDto project;

    @Getter
    @Setter
    private TimeShitMonthDto timeShitMonth;
}
