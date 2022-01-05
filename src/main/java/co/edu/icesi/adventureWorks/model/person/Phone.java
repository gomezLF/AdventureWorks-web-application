package co.edu.icesi.adventureWorks.model.person;

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

import lombok.Getter;
import lombok.Setter;

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
	@Getter
	@Setter
	private Integer id;
	
	
	/**
	 * Contact's phone number.
	 */
	@Getter
	@Setter
	private String phoneNumber;
	
	
	/**
	 * Last date on which the phone was modified.
	 */
	@Getter
	@Setter
	private LocalDateTime modifieddate;
	
	
	/**
	 * Contact to which the phone belongs.
	 */
	// bi-directional one-to-one association to Contact
	@ManyToOne
	@JoinColumn(name = "contactID")
	@Getter
	@Setter
	private Contact contact;
	
	
	
	public Phone() {
		setModifieddate(LocalDateTime.now());
	}
}
