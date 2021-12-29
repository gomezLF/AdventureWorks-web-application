package co.edu.icesi.adventureWorks.model.Person;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;

@Entity
@NamedQuery(name = "Contact.findAll", query = "SELECT c FROM Contact c")
public class Contact implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Primary key for Contact rows.
	 * 
	 */
	@Id
	@SequenceGenerator(name = "CONTACT_CONTACTID_GENERATOR", allocationSize = 1, sequenceName = "CONTACT_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONTACT_CONTACTID_GENERATOR")
	@Getter
	@Setter
	private Integer contactID;
	
	/**
	 * A courtesy title. For example, Mr. or Ms.
	 */
	@Getter
	@Setter
	private String title;
	
	
	/**
	 * First name of the person.
	 */
	@Getter
	@Setter
	private String firstName;
	
	
	/**
	 * Middle name or middle initial of the person.
	 */
	@Getter
	@Setter
	private String middleName;
	
	
	/**
	 * Last name of the person.
	 */
	@Getter
	@Setter
	private String lastName;
	
	
	/**
	 * Surname suffix. For example, Sr. or Jr.
	 */
	@Getter
	@Setter
	private String suffix;
	
	
	/**
	 * False = Contact does not wish to receive e-mail promotions.
	 * True = Contact does wish to receive e-mail promotions.
	 */
	@Getter
	@Setter
	private Boolean emailPromotion;
	
	
	/**
	 * Indicates the column in which the family name is stored.
	 * 
	 * 0 = Family name is stored in LastName and the first name is stored in FirstName.
	 * 1 = .Family name is stored in FirstName and the first name is stored in LastName.
	 */
	@Getter
	@Setter
	private Integer nameStyle;
	
	
	/**
	 * Date and time the row was last updated.
	 */
	@Getter
	@Setter
	private LocalDateTime modifiedDate;
	
	
	/**
	 * E-mail addresses for the person.
	 */
	//bi-directional many-to-one association to EmailAddress.
	@OneToMany(mappedBy = "contact")
	@Getter
	@Setter
	private List<EmailAddress> emailAddresses;
	
	
	/**
	 * Phone number associated with the person.
	 */
	// bi-directional many-to-one association to Phone.
	@OneToMany(mappedBy = "contact")
	@Getter
	@Setter
	private List<Phone> phones;
	
	
	/**
	 * Password for the e-mail account.
	 */
	// bi-directional one-to-one association to Password.
	@OneToOne(mappedBy = "contact")
	private Password password;
	
	
	
	public Contact() {
		setEmailAddresses(new ArrayList<EmailAddress>());
		setPhones(new ArrayList<Phone>());
		
		setModifiedDate(LocalDateTime.now());
	}
	
	
	/**
	 * Adds an e-mail address, created prior to calling this function, to an e-mail list. It then returns the added address.
	 * @param emailaddress - The e-mail address to be added.
	 * @return The e-mail address added. 
	 */
	public EmailAddress addEmailAddress(EmailAddress emailaddress) {
		getEmailAddresses().add(emailaddress);
		emailaddress.setContact(this);
		
		return emailaddress;
	}
	
	
	/**
	 * Adds a phone, created prior to calling this function, to a phone list. It then returns the added phone.
	 * @param phone - The phone to be added.
	 * @return The phone added. 
	 */
	public Phone addPhone(Phone phone) {
		getPhones().add(phone);
		phone.setContact(this);
		
		return phone;
	}
	
	
	
	
}
