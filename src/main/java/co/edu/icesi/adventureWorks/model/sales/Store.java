package co.edu.icesi.adventureWorks.model.sales;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;

import lombok.Getter;
import lombok.Setter;

@Entity
@NamedQuery(name = "Store.findAll", query = "SELECT s FROM Store s")
public class Store implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Name of the store.
	 */
	@Getter
	@Setter
	private String name;
	
	
	/**
	 * Demographic information about the store such as the number of employees, annual sales and store type. 
	 */
	@Getter
	@Setter
	private String demographics;
	
	
	/**
	 * Date the store was last updated.
	 */
	@Getter
	@Setter
	private LocalDate modifiedDate;
	
	
	/**
	 * 
	 */
	@Getter
	@Setter
	private Customer customer;
	
	
	/**
	 * 
	 */
	@Getter
	@Setter
	private List<SalesPerson> salesPerson;
	
	
	
	public Store() {
		setSalesPerson(new ArrayList<SalesPerson>());
		setModifiedDate(LocalDate.now());
	}
}
