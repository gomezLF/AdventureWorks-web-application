package co.edu.icesi.adventureWorks.model.Person;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

import co.edu.icesi.adventureWorks.model.sales.SalesTerritory;
import lombok.Getter;
import lombok.Setter;

@Entity
@NamedQuery(name = "StateProvince.findAll", query = "SELECT s FROM StateProvince s")
public class StateProvince implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Primary key for address rows.
	 */
	@Id
	@SequenceGenerator(name = "ADDRESS_ADDRESSID_GENERATOR", allocationSize = 1, sequenceName = "ADDRESS_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ADDRESS_ADDRESSID_GENERATOR")
	@Getter
	@Setter
	private Integer stateProvinceID;
	
	
	/**
	 * State or province code.
	 */
	@Getter
	@Setter
	private String stateProvinceCode;

	
	/**
	 * True = StateProvinceCode exists. False = StateProvinceCode unavailable, use CountryRegionCode.
	 */
	@Getter
	@Setter
	private Boolean isOnlyStateProvinceFlag;

	
	/**
	 * State or province description.
	 */
	@Getter
	@Setter
	private String name;

	
	/**
	 * Date the state-province was last updated.
	 */
	@Getter
	@Setter
	private LocalDateTime modifiedDate;

	
	/**
	 * Country or region code.
	 */
	@ManyToOne
	@JoinColumn(name = "")
	@Getter
	@Setter
	private CountryRegion countryRegionCode;
	
	
	/**
	 * Sales territory in which the state or province is located.
	 */
	@ManyToOne
	@JoinColumn(name = "territoryID")
	@Getter
	@Setter
	private SalesTerritory salesTerritory;
	
	
	
	public StateProvince() {
		setModifiedDate(LocalDateTime.now());
	}
}
