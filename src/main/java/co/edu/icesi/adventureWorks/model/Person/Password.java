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

import lombok.Getter;
import lombok.Setter;

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
	@Getter
	@Setter
	private Integer id;
	
	
	/**
	 * Contact's password for the e-mail account.
	 */
	@Getter
	@Setter
	private String passoword;
	
	
	/**
	 * Random value concatenated with the password string before the password is hashed.
	 */
	@Getter
	@Setter
	private String passwordsalt;
	
	
	/**
	 * Last date on which the password was modified.
	 */
	@Getter
	@Setter
	private LocalDateTime moddifieddate;
	
	
	/**
	 * 
	 */
	@OneToOne
	@JoinColumn(name = "contactID")
	@Getter
	@Setter
	private Contact contact;
	
	
	
	public Password() {
		setModdifieddate(LocalDateTime.now());
	}
	
}
