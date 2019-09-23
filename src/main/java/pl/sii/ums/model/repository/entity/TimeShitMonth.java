package pl.sii.ums.model.repository.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table
public class TimeShitMonth {
	

	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TimeShitMonthId")
	private Long timeShitMonthid;

	@Getter
	@Setter
	@Column(name = "Name")
	private String name;
	
	@Getter
	@Setter
	@Column(name = "Description")
	private String description;
	
	@Getter
	@Setter
	@Column(name = "Period")
	private String period;
	
	@Getter
	@Setter
    @OneToMany(mappedBy = "timeShitMonth", cascade = CascadeType.ALL)
	private List<TimeShit> timeShit;
}
