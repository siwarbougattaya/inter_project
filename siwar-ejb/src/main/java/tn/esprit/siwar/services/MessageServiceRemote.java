package tn.esprit.siwar.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.siwar.persistence.Message;

@Remote
public interface MessageServiceRemote {
	void ajouterMessage(Message m);
	void modifierUtilisateur(Message m);
	void supprimerMessage(Message m);
	Message findById(int id);
	List<Message> findAll();

}
