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

@Entity
@NamedQuery(name = "Contact.findAll", query = "SELECT c FROM Contact c")
public class Contact implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
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
	private Integer nameStyle;
	
	
	/**
	 * ROWGUIDCOL number uniquely identifying the row. Used to support a merge replication sample.
	 */
	private Integer rowguid;
	
	
	/**
	 * Date and time the row was last updated.
	 */
	private LocalDateTime modifiedDate;
	
	
	/**
	 * E-mail addresses for the person.
	 */
	//bi-directional many-to-one association to EmailAddress.
	@OneToMany(mappedBy = "contact")
	private List<EmailAddress> emailAddresses;
	
	
	/**
	 * Phone number associated with the person.
	 */
	// bi-directional many-to-one association to Phone.
	@OneToMany(mappedBy = "contact")
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
	
	
	
	public EmailAddress addEmailAddress(EmailAddress emailaddress) {
		getEmailAddresses().add(emailaddress);
		emailaddress.setContact(this);
		
		return emailaddress;
	}
	
	public Phone addPhone(Phone phone) {
		getPhones().add(phone);
		phone.setContact(this);
		
		return phone;
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

	public Integer getNameStyle() {
		return nameStyle;
	}
	
	public Integer getRowguid() {
		return rowguid;
	}
	
	public LocalDateTime getModifiedDate() {
		return modifiedDate;
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



	public void setContactID(Integer contactID) {
		this.contactID = contactID;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public void setEmailPromotion(Boolean emailPromotion) {
		this.emailPromotion = emailPromotion;
	}

	public void setNameStyle(Integer nameStyle) {
		this.nameStyle = nameStyle;
	}
	
	public void setRowguid(Integer rowguid) {
		this.rowguid = rowguid;
	}
	
	public void setModifiedDate(LocalDateTime modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public void setEmailAddresses(List<EmailAddress> emailAddresses) {
		this.emailAddresses = emailAddresses;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	public void setPassword(Password password) {
		this.password = password;
	}
	
	
	
	
}
