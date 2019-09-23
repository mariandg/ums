package pl.sii.ums.model.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="UserManagementSystem")
public class UserManagementSystemInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter 
	@Column(name="Id")
	private Long id;

	@Getter 
	@Setter
	@Column(name="Name")
	private String name;

	@Getter 
	@Setter
	@Column(name="Description")
	private String description;

	@Getter 
	@Setter
	@Column(name="AboutCompany")
	private String aboutCompany;

}
