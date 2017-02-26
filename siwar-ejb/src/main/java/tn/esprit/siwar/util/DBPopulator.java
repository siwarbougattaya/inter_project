package tn.esprit.siwar.util;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import tn.esprit.siwar.persistence.Message;
import tn.esprit.siwar.persistence.Todo;
import tn.esprit.siwar.persistence.Utilisateur;
import tn.esprit.siwar.services.MessageServiceRemote;
import tn.esprit.siwar.services.TodoServiceLocal;
import tn.esprit.siwar.services.UtilisateurServiceRemote;

@Singleton
@Startup
public class DBPopulator {

	@EJB
	private TodoServiceLocal todoServiceLocal;
	@EJB
	private UtilisateurServiceRemote utilisateurserviceremote;	
	@EJB
	private MessageServiceRemote messageserviceremote;
	
	
	public DBPopulator() {
	}
	
	@PostConstruct
	public void init(){
		Todo t1 = new Todo("Learn JSF");
		Todo t2 = new Todo("Learn EJB");
		Todo t3 = new Todo("Learn JPA");
		todoServiceLocal.create(t1);
		todoServiceLocal.create(t2);
		todoServiceLocal.create(t3);
		
		
		Utilisateur u1 = new Utilisateur();
		Utilisateur u2 = new Utilisateur();
		utilisateurserviceremote.ajouterUtilisateur(u1);
		utilisateurserviceremote.ajouterUtilisateur(u2);
		Message m1 = new Message();
		m1.setDescription("saluttttt !!!!!!");
		m1.setSender(utilisateurserviceremote.findById(1));
		m1.setReceiver(utilisateurserviceremote.findById(2));
		messageserviceremote.ajouterMessage(m1);
		
	}
}
