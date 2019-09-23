package pl.sii.ums.model.repository.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table
public class TimeShit {

		@Getter
		@Setter
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "TimeShitId")
		private Long timeShitId;

		@Getter
		@Setter
		@Column(name = "Day")
		private int day;

		@Getter
		@Setter
		@Column(name = "WorkedHours")
		private double workedHours;

		@Getter
		@Setter
	    @ManyToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "ProjectId", referencedColumnName = "ProjectId")
		private Project project;

	    @ManyToOne
	    @Getter
	    @Setter
	    @JoinColumn(name = "TimeShitMonthId", referencedColumnName = "TimeShitMonthId")
	    private TimeShitMonth timeShitMonth;
}
