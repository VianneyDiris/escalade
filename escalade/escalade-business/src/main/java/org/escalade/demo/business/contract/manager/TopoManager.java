package org.escalade.demo.business.contract.manager;

import java.util.List;

import org.escalade.demo.model.bean.topo.*;
import org.escalade.demo.model.exception.NotFoundException;

public interface TopoManager {
	
	// ==================== Utilisateur ====================	
	List<Utilisateur> getListUtilisateur();
	
	//renvoie l'utilisateur grâce à son id
	Utilisateur getUtilisateur(Integer id) throws NotFoundException;
	
	//renvoie l'utilisateur grâce à son couple pseudo/password
	Utilisateur getUtilisateur(String pseudo, String password) throws NotFoundException;
	
	
	// ==================== Role ====================
	List<Role> getListRole();
	
	//renvoie le role grâce à son id
	Role getRole(Integer id) throws NotFoundException;
	
	
	// ==================== Topo ====================
	List<Topo> getListTopo();
	
	//renvoie le topo grâce à son id
	Topo getTopo(Integer id) throws NotFoundException;
	
	
	// ==================== Reservation ====================
	List<Reservation> getListReservation();
	
	//renvoie la réservation grâce à son id
	Reservation getReservation(Integer id) throws NotFoundException;
	
	
	// ==================== Commmentaire ====================
	List<Commentaire> getListCommentaire();
	
	//renvoie le commentaire grâce à son id
	Commentaire getCommentaire(Integer id) throws NotFoundException;
	
	
	
	
	

}
