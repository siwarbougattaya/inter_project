package tn.esprit.siwar.persistence;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Message
 *
 */
@Entity

public class Message implements Serializable {

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String description;
	private static final long serialVersionUID = 1L;
	@ManyToOne
	private Utilisateur sender;
	@ManyToOne
	private Utilisateur receiver;

	public Message() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public Utilisateur getSender() {
		return sender;
	}
	public void setSender(Utilisateur sender) {
		this.sender = sender;
	}
	public Utilisateur getReceiver() {
		return receiver;
	}
	public void setReceiver(Utilisateur receiver) {
		this.receiver = receiver;
	}
	
	
   
}
