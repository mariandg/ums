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
@Table(name="Position")
public class Position {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PositionId")
	private Long positionId;
	

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
	@Column(name="Salary")
	private double salary;
	

	@Getter
	@Setter
	@Column(name="BonusGoal")
	private double bonusGoal;
	
}
