package pl.sii.ums.model.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class UserManagementSystemInfoDto {

	@Getter 
	private Long id;

	@Getter 
	@Setter
	private String name;

	@Getter 
	@Setter
	private String description;

	@Getter 
	@Setter
	private String aboutCompany;

}
