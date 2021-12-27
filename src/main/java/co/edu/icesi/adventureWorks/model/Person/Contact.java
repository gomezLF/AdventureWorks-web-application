package co.edu.icesi.adventureWorks.model.Person;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

@Entity
@NamedQuery(name = "Contact.findAll", query = "SELECT c FROM Contact c")
public class Contact {
	
	/**
	 * Primary key for Contact rows.
	 */
	@Id
	@SequenceGenerator(name = "CONTACT_CONTACTID_GENERATOR", allocationSize = 1, sequenceName = "CONTACT_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONTACT_CONTACTID_GENERATOR")
	private Integer contactID;
	
	/**
	 * A courtesy title. For example, Mr. or Ms.
	 */
	private String title;
	
	/**
	 * First name of the person.
	 */
	private String firstName;
	
	/**
	 * Middle name or middle initial of the person.
	 */
	private String middleName;
	
	/**
	 * Last name of the person.
	 */
	private String lastName;
	
	/**
	 * Surname suffix. For example, Sr. or Jr.
	 */
	private String suffix;
	
	/**
	 * False = Contact does not wish to receive e-mail promotions.
	 * True = Contact does wish to receive e-mail promotions.
	 */
	private Boolean emailPromotion;
	
	/**
	 * Indicates the column in which the family name is stored.
	 * 
	 * 0 = Family name is stored in LastName and the first name is stored in FirstName.
	 * 1 = .Family name is stored in FirstName and the first name is stored in LastName.
	 */
	private NameStyle nameStyle;
	
	/**
	 * E-mail addresses for the person.
	 */
	private List<EmailAddress> emailAddresses;
	
	/**
	 * Phone number associated with the person.
	 */
	private List<Phone> phones;
	
	/**
	 * Password for the e-mail account.
	 */
	private Password password;
	
	
	
	public Contact() {
		
	}



	public Integer getContactID() {
		return contactID;
	}

	public String getTitle() {
		return title;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getSuffix() {
		return suffix;
	}

	public Boolean getEmailPromotion() {
		return emailPromotion;
	}

	public NameStyle getNameStyle() {
		return nameStyle;
	}

	public List<EmailAddress> getEmailAddresses() {
		return emailAddresses;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public Password getPassword() {
		return password;
	}
	
	
	
	
}
