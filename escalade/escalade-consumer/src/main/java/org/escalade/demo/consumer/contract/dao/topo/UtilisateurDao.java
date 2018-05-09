package org.escalade.demo.consumer.contract.dao.topo;

import java.util.List;

import org.escalade.demo.model.bean.topo.Utilisateur;

public interface UtilisateurDao {
	
	List<Utilisateur> listUtilisateur();
	
	Utilisateur find(int id);
	
	Utilisateur search(String pseudo,String password);
	
	void addUtilisateur(Utilisateur utilisateur);
	
	void updateUtilisateur(Utilisateur utilisateur);
	
	void deleteUtilisateur(Utilisateur utilisateur);

}
