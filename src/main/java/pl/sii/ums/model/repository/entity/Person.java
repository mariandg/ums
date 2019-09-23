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
@Table(name="Person")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter 
	@Setter
	@Column(name="PersonId")
	private Long personId;

	@Getter 
	@Setter
	@Column(name="Name")
	private String name;

	@Getter 
	@Setter
	@Column(name="Surname")
	private String surname;

	@Getter 
	@Setter
	@Column(name="Age")
	private int age;

	@Getter 
	@Setter
	@Column(name="Pesel")
	private long pesel;

	@Getter 
	@Setter
	@Column(name="PositionId")
	private int positionId;

}
