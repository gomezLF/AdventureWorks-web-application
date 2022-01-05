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
@NamedQuery(name = "EmailAddress.findAll", query = "SELECT e FROM EmailAddress e")
public class EmailAddress implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Identifier of the e-mail address in the contact to which it belongs.
	 */
	@Id
	@SequenceGenerator(name = "EMAILADDRESS_ID_GENERATOR", allocationSize = 1, sequenceName = "EMAILADDRESSS_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMAILADDRESS_ID_GENERATOR")
	@Getter
	@Setter
	private Integer id;
	
	
	/**
	 * E-mail address for the contact.
	 */
	@Getter
	@Setter
	private String emailaddress;
	
	
	/**
	 * Date and time the e-mail address was last updated.
	 */
	@Getter
	@Setter
	private LocalDateTime modifieddate;
	
	
	/**
	 * Contact to which the e-mail address belongs.
	 */
	// bi-directional many-to-one association to Contact.
	@ManyToOne
	@JoinColumn(name = "contactID")
	@Getter
	@Setter
	private Contact contact;
	
	
	
	public EmailAddress() {
		setModifieddate(LocalDateTime.now());
	}
	
}
