package co.edu.icesi.adventureWorks.model.sales;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import co.edu.icesi.adventureWorks.model.person.Contact;
import co.edu.icesi.adventureWorks.model.person.ContactType;
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
	 * Store or individual who did business with Adventure Works representative.
	 */
	@OneToOne
	@JoinColumn(name = "customerID")
	@Getter
	@Setter
	private Customer customer;
	
	
	/**
	 * Contact, the store employees.
	 */
	@OneToMany(mappedBy = "storeContact")
	@Getter
	@Setter
	private List<Contact> contacts;
	
	
	
	public StoreContact() {
		setContacts(new ArrayList<Contact>());
		setModifiedDate(LocalDate.now());
	}
	
	
	
	/**}
	 * Adds a contact, created prior to calling this function, to the contacts list. It then returns contact added.
	 * @param contact - The contact to be added.
	 * @return The contact added.
	 */
	public Contact addContact(Contact contact) {
		getContacts().add(contact);
		contact.setStoreContact(this);
		
		return contact;
	}
	
}
