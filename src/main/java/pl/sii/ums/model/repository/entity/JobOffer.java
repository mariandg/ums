package pl.sii.ums.model.repository.entity;

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
@Table(name="JobOffer")
public class JobOffer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	@Column(name="JobOfferId")
	private Long jobOfferId;
	
	@Getter
	@Setter
	@Column(name="Name")
	private String name;
	
	@Getter
	@Setter
	@Column(name="Description")
	private String description;
	
//	@Getter
//	@Setter 
//	@Column(name="PriceGroup")
//	@ManyToOne
//    @JoinColumn(name = "PriceGroupId", referencedColumnName = "PriceGroup")
//	private PriceGroup priceGroup;
}
