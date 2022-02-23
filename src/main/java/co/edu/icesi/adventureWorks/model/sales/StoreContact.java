package co.edu.icesi.adventureWorks.model.sales;

import java.io.Serializable;
import java.time.LocalDate;

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
@NamedQuery(name = "StoreContact.findAll", query = "SELECT s FROM StoreContact s")
public class StoreContact implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * Primary key for Store contact rows
	 */
	@Id
	@SequenceGenerator(name = "STORECONTACT_STORECONTACTID_GENERATOR", allocationSize = 1, sequenceName = "STORECONTACT_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STORECONTACT_STORECONTACTID_GENERATOR")
	@Getter
	@Setter
	private Integer storeContactID;
	
	
	/**
	 * Contact type such as owner or purchasing agent.
	 */
	@Getter
	@Setter
	private ContactType contactType;
	
	
	/**
	 * Date the store contact was last updated.
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
	 * Contact, the store employee.
	 */
	@Getter
	@Setter
	private Contact contact;
	
}
