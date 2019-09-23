package pl.sii.ums.model.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class ProjectDto {

	@Getter
	@Setter
	private Long projectId;

	@Getter
	@Setter
	private String name;

	@Getter
	@Setter
	private String description;

    @Getter
    @Setter
    @JsonBackReference
    private List<TimeShitDto> timeShits;
	
}
