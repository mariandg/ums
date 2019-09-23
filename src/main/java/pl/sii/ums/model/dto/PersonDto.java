package pl.sii.ums.model.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class PersonDto {

	@Getter 
	@Setter
	private Long personId;

	@Getter 
	@Setter
	private String name;

	@Getter 
	@Setter
	private String surname;

	@Getter 
	@Setter
	private int age;

	@Getter 
	@Setter
	private long pesel;

	@Getter 
	@Setter
	private int positionId;

}
