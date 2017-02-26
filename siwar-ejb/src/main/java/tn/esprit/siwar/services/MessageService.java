package tn.esprit.siwar.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.siwar.persistence.Message;

/**
 * Session Bean implementation class MessageService
 */
@Stateless
@LocalBean
public class MessageService implements MessageServiceRemote, MessageServiceLocal {

    /**
     * Default constructor. 
     */
	
	@PersistenceContext
	EntityManager em;
    public MessageService() {
    }

	@Override
	public void ajouterMessage(Message m) {
			em.persist(m);		
	}

	@Override
	public void modifierUtilisateur(Message m) {
		
		em.merge(m);
		
	}


	@Override
	public Message findById(int id) {
		return em.find(Message.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Message> findAll() {
		return em.createQuery("select m from Message m").getResultList();

	}

	@Override
	public void supprimerMessage(Message m) {
		
		em.remove(em.merge(m));
		
	}

}
