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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
@NamedQuery(name = "Phone.findAll", query = "SELECT p FROM Phone p")
public class Phone implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Identifier of the telephone belonging to a contact.
	 */
	@Id
	@SequenceGenerator(name = "PHONE_ID_GENERATOR", allocationSize = 1, sequenceName = "PHONE_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PHONE_ID_GENERATOR")
	private Integer id;
	
	
	/**
	 * Contact's phone number.
	 */
	private String phoneNumber;
	
	
	/**
	 * Last date on which the phone was modified.
	 */
	private LocalDateTime modifieddate;
	
	
	/**
	 * Contact to which the phone belongs.
	 */
	// bi-directional one-to-one association to Contact
	@ManyToOne
	@JoinColumn(name = "contactID")
	private Contact contact;
	
	
	
	public Phone() {
		setModifieddate(LocalDateTime.now());
	}
	
	
	
	/**
	 * Returns the Identifier of the telephone belonging to a contact.
	 * @return An integer belonging to the identifier of the telephone belonging to a contact.
	 */
	public Integer getId() {
		return id;
	}
	
	/**
	 * Returns the contact's phone number.
	 * @return An Integer with the contact's phone number.
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	/**
	 * Returns the last date on which the phone was modified.
	 * @return A LocalDateTime which is the last date on which the phone was modified.
	 */
	public LocalDateTime getModifieddate() {
		return modifieddate;
	}
	
	/**
	 * Returns the contact to which the phone belongs.
	 * @return A Contact to which the phone belongs.
	 */
	public Contact getContact() {
		return contact;
	}


	
	/**
	 * Set the Identifier of the telephone belonging to a contact.
	 * @param id - the new identifier of the telephone belonging to a contact.
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * Set the contact's phone number.
	 * @param phoneNumber - the new contact's phone number.
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	/**
	 * Set the last date on which the phone was modified. 
	 * @param modifieddate - the new last date on which the phone was modified.
	 */
	public void setModifieddate(LocalDateTime modifieddate) {
		this.modifieddate = modifieddate;
	}
	
	/**
	 * Set the contact to which the phone belongs.
	 * @param contact - the new contact to which the phone belongs.
	 */
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	
	
	
	
}
