package tn.esprit.siwar.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.siwar.persistence.Utilisateur;

@Remote
public interface UtilisateurServiceRemote {
	
	void ajouterUtilisateur(Utilisateur u);
	void activerUtilisateur(Utilisateur u);
	void desactiverUtilisateur(Utilisateur u);
	void modifierUtilisateur(Utilisateur u);
	void supprimerUtilisateur(Utilisateur u);
	Utilisateur findById(int id);
	List<Utilisateur> findAll();
	Utilisateur getRandomBuyer();
	List<Utilisateur> recupererComptesNonValidees();




	
	

}
