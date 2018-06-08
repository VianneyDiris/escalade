package org.escalade.demo.business.contract.manager.topo;

import java.util.List;

import org.escalade.demo.model.bean.topo.Commentaire;
import org.escalade.demo.model.exception.NotFoundException;

public interface CommentaireManager {
	
	// ==================== Commmentaire ====================
	List<Commentaire> getListCommentaire();
		
	//renvoie le commentaire grâce à son id
	Commentaire getCommentaire(Integer id) throws NotFoundException;
	
	List<Commentaire> getListCommentaireByTopo(Integer id)throws NotFoundException;
	
	List<Commentaire> getListCommentaireBySpot(Integer id)throws NotFoundException;
	
	void deleteCommentaire(Integer id)throws NotFoundException;
	
	void deleteCommentaireByUser(Integer id)throws NotFoundException;
	
	void deleteCommentaireByTopo(Integer id)throws NotFoundException;
	
	void deleteCommentaireBySpot(Integer id)throws NotFoundException;
	
	void updateCommentaire(Commentaire commentaire);
	
	void addCommentaire(Commentaire commentaire);
	

}
