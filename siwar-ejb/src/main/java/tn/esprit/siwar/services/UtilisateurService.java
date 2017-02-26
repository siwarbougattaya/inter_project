package tn.esprit.siwar.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.siwar.persistence.Utilisateur;

/**
 * Session Bean implementation class UtilisateurService
 */
@Stateless
@LocalBean
public class UtilisateurService implements UtilisateurServiceRemote, UtilisateurServiceLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	EntityManager em;

    public UtilisateurService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void ajouterUtilisateur(Utilisateur u) {
		
		em.persist(u);
		
	}

	@Override
	public void activerUtilisateur(Utilisateur u) {
		
		u.setStatus(1);
		em.merge(u);
	}

	@Override
	public void desactiverUtilisateur(Utilisateur u) {
		u.setStatus(0);
		em.merge(u);
	}

	@Override
	public void modifierUtilisateur(Utilisateur u) {
		
		em.merge(u);
		
	}

	@Override
	public void supprimerUtilisateur(Utilisateur u) {
		em.remove(em.merge(u));
	}

	@Override
	public Utilisateur findById(int id) {
		return em.find(Utilisateur.class,id);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Utilisateur> findAll() {
		return em.createQuery("select u from Utilisateur u").getResultList();
	}

	@Override
	public Utilisateur getRandomBuyer() {
		String q="select count(u) from Utilisateur u where u.role='vendeur'";
		Query query=em.createQuery(q);
		Number countResult=(Number) query.getSingleResult();
	    int random = (int) (Math.random()*countResult.intValue());
	
	    return (Utilisateur) em.createQuery("select u from Utilisateur u where u.role='vendeur'")
				 .setFirstResult(random)
		            .setMaxResults(1)
		            .getSingleResult();
		 
	}

	@Override
	public List<Utilisateur> recupererComptesNonValidees() {
		return em.createQuery("select u from Utilisateur u where u.status=0").getResultList();
	}

}
