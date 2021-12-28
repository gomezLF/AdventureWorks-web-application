package co.edu.icesi.adventureWorks.model.Person;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
@NamedQuery(name = "Password.findAll", query = "SELECT p FROM Password p")
public class Password implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * Identifier of the password belonging to a contact.
	 */
	@Id
	@SequenceGenerator(name = "PASSWORD_ID_GENERATOR", allocationSize = 1, sequenceName = "PASSWORD_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PASSWORD_ID_GENERATOR")
	private Integer id;
	
	
	/**
	 * Contact's password for the e-mail account.
	 */
	private String passoword;
	
	
	/**
	 * Random value concatenated with the password string before the password is hashed.
	 */
	private String passwordsalt;
	
	
	/**
	 * Last date on which the password was modified.
	 */
	private LocalDateTime moddifieddate;
	
	
	/**
	 * 
	 */
	@OneToOne
	@JoinColumn(name = "contactID")
	private Contact contact;
	
	
	
	public Password() {
		setModdifieddate(LocalDateTime.now());
	}
	
	
	
	/**
	 * Returns the Identifier of the password belonging to a contact.
	 * @return An Integer which is the Identifier of the password belonging to a contact.
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Returns the contact's password for the e-mail account.
	 * @return A String which is the contact's password for the e-mail account.
	 */
	public String getPassoword() {
		return passoword;
	}

	/**
	 * Returns the random value concatenated with the password string before the password is hashed.
	 * @return A String which is the random value concatenated with the password string before the password is hashed.
	 */
	public String getPasswordsalt() {
		return passwordsalt;
	}

	/**
	 * Returns the last date on which the password was modified.
	 * @return A LocalDateTime which is the last date on which the password was modified.
	 */
	public LocalDateTime getModdifieddate() {
		return moddifieddate;
	}


	
	/**
	 * Set the Identifier of the password belonging to a contact.
	 * @param id - the new identifier of the password belonging to a contact.
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Set the contact's password for the e-mail account.
	 * @param passoword - the new contact's password for the e-mail account.
	 */
	public void setPassoword(String passoword) {
		this.passoword = passoword;
	}

	/**
	 * Set the random value concatenated with the password string before the password is hashed.
	 * @param passwordsalt - the new random value concatenated with the password string before the password is hashed.
	 */
	public void setPasswordsalt(String passwordsalt) {
		this.passwordsalt = passwordsalt;
	}

	/**
	 * Set the last date on which the password was modified.
	 * @param moddifieddate - the new last date on which the password was modified.
	 */
	public void setModdifieddate(LocalDateTime moddifieddate) {
		this.moddifieddate = moddifieddate;
	}
	
	
	
	
}
