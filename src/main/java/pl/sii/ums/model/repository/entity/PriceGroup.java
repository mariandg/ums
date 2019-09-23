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
@Table(name="PriceGroup")
public class PriceGroup {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	@Column(name="PriceGroupId")
	private Long priceGroupId;
	
	@Getter
	@Setter
	@Column(name="Earning")
	private double earning;
	
	@Getter
	@Setter
	@Column(name="Description")
	private String description;
	
	@Getter
	@Setter
	@Column(name="EarningsGroup")
	private Integer earningsGroup;
	
//	@Getter
//	@Setter
//    @OneToMany(mappedBy = "priceGroup")
//	private List<JobOffer> jobOffers;
	
}
