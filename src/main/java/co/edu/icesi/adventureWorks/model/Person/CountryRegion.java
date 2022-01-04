package co.edu.icesi.adventureWorks.model.Person;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NamedQuery(name = "CountryRegion.findAll", query = "SELECT c FROM CountryRegion c")
public class CountryRegion implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * Primary key for address rows.
	 */
	@Id
	@SequenceGenerator(name = "COUNTRYREGION_COUNTRYREGIONID_GENERATOR", allocationSize = 1, sequenceName = "COUNTRYREGION_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COUNTRYREGION_COUNTRYREGIONID_GENERATOR")
	@Getter
	@Setter
	private Integer countryRegionID;
	
	
	/**
	 * Standard code identifying countries and regions.
	 */
	@Getter
	@Setter
	private String countryRegionCode;


	/**
	 * Country or region name.
	 */
	@Getter
	@Setter
	private String name;
	
	
	/**
	 * Date the country-region was last updated.
	 */
	@Getter
	@Setter
	private LocalDateTime modifiedDate;
	
	
	/**
	 * List of state-provinces that use the current country-region
	 */
	@OneToMany(mappedBy = "countryregion")
	@Getter
	@Setter
	private List<StateProvince> stateProvinces;
	
	
	
	public CountryRegion() {
		setStateProvinces(new ArrayList<StateProvince>());
		setModifiedDate(LocalDateTime.now());
	}
	
	
	
	/**
	 * Adds a state-province, created prior to calling this function, to a state-province list. It then return the added state-province.
	 * @param stateProvince - THe state-province to be added.
	 * @return The state-province added.
	 */
	public StateProvince addStateProvince(StateProvince stateProvince) {
		getStateProvinces().add(stateProvince);
		stateProvince.setCountryRegionCode(this);
		
		return stateProvince;
	}

}
