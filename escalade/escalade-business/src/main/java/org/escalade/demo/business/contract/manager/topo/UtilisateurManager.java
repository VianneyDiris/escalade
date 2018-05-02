package org.escalade.demo.business.contract.manager.topo;

import java.util.List;

import org.escalade.demo.model.bean.topo.Utilisateur;
import org.escalade.demo.model.exception.NotFoundException;

public interface UtilisateurManager {
	
	// ==================== Utilisateur ====================	
	List<Utilisateur> getListUtilisateur();
	
	//renvoie l'utilisateur grâce à son id
	Utilisateur getUtilisateur(Integer id) throws NotFoundException;
	
	//renvoie l'utilisateur grâce à son couple pseudo/password
	Utilisateur getUtilisateur(String pseudo, String password) throws NotFoundException;
	
	void addUtilisateur(Utilisateur user);

}
