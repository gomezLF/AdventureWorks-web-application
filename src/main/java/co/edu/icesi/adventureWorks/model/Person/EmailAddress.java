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

@Entity
@NamedQuery(name = "EmailAddress.findAll", query = "SELECT e FROM EmailAddress e")
public class EmailAddress implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Identifier of the e-mail address in the contact to which it belongs.
	 */
	@Id
	@SequenceGenerator(name = "EMAILADDRESS_ID_GENERATOR", allocationSize = 1, sequenceName = "EMAILADDRESSS_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMAILADDRESS_ID_GENERATOR")
	private Integer id;
	
	
	/**
	 * E-mail address for the contact.
	 */
	private String emailaddress;
	
	
	/**
	 * Date and time the class was last updated.
	 */
	private LocalDateTime modifieddate;
	
	
	/**
	 * Contact to which the e-mail address belongs.
	 */
	// bi-directional many-to-one association to Contact.
	@ManyToOne
	@JoinColumn(name = "contactID")
	private Contact contact;
	
	
	
	public EmailAddress() {
		setModifieddate(LocalDateTime.now());
	}


	
	/**
	 * Returns the email address identifier.
	 * @return An integer which is the identifier of the e-mail address. 
	 */
	public Integer getId() {
		return id;
	}
	
	/**
	 * Returns the contact's e-mai address. 
	 * @return An String wich is the contact's e-mai address.
	 */
	public String getEmailaddress() {
		return emailaddress;
	}
	
	/**
	 * Returns the last date on which the contact's email was edited.  
	 * @return A LocalDateTime on which the contact's email was edited.
	 */
	public LocalDateTime getModifieddate() {
		return modifieddate;
	}
	
	/**
	 * Returns the contact to which the e-mail address belongs.
	 * @return A Contact to which the e-mail address belongs.
	 */
	public Contact getContact() {
		return contact;
	}


	
	/**
	 * Set the current email address identifier. 
	 * @param id - the new email address identifier.
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * Set the current email address to a different one.
	 * @param emailaddress - the new email address.
	 */
	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}
	
	/**
	 * Set the current last date on which the contact's email was edited.
	 * @param modifieddate - the new last date on which the contact's email was edited.
	 */
	public void setModifieddate(LocalDateTime modifieddate) {
		this.modifieddate = modifieddate;
	}
	
	/**
	 * Set the current contact to which the e-mail address belongs.
	 * @param contact - new contact to which the email address will belong.
	 */
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	
	
	
	
}
