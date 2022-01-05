package co.edu.icesi.adventureWorks.model.sales;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

import co.edu.icesi.adventureWorks.model.person.Contact;
import lombok.Getter;
import lombok.Setter;

@Entity
@NamedQuery(name = "Individual.findAll", query = "SELECT i FROM Individual i")
public class Individual implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Unique identifier of the individual.
	 */
	@Id
	@SequenceGenerator(name = "INDIVIDUAL_INDIVIDUALID_GENERATOR", allocationSize = 1, sequenceName = "INDIVIDUAL_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INDIVIDUAL_INDIVIDUALID_GENERATOR")
	@Getter
	@Setter
	private Integer individualID;
	
	
	/**
	 * Personal information, such as hobbies and income that is collected from online shoppers and used for sales analysis.
	 */
	@Getter
	@Setter
	private String demographic;
	
	
	/**
	 * Date the individual was last edited.
	 */
	@Getter
	@Setter
	private LocalDateTime  modifiedDate;
	
	
	/**
	 * Identifies the customer in the Contact table.
	 */
	@Getter
	@Setter
	private Contact contact;
	
	
	/**
	 * Unique customer identification number. 
	 */
	@Getter
	@Setter
	private Customer customer;
	
	
	
	public Individual() {
		setModifiedDate(LocalDateTime.now());
	}
	
}
