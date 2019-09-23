package pl.sii.ums.model.repository.entity;

import java.util.List;

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
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ProjectId")
	@Getter
	@Setter
	private Long projectId;

	@Column(name = "Name")
	@Getter
	@Setter
	private String name;

	@Column(name = "Description")
	@Getter
	@Setter
	private String description;

    @OneToMany(mappedBy = "project")
    @Getter
    @Setter
    private List<TimeShit> timeShits;
	
}
