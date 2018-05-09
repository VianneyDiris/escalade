package org.escalade.demo.business.contract.manager.topo;

import java.util.List;

import org.escalade.demo.model.bean.topo.Commentaire;
import org.escalade.demo.model.exception.NotFoundException;

public interface CommentaireManager {
	
	// ==================== Commmentaire ====================
	List<Commentaire> getListCommentaire();
		
	//renvoie le commentaire grâce à son id
	Commentaire getCommentaire(Integer id) throws NotFoundException;
	
	Commentaire findCommentbySpotId(Integer id) throws NotFoundException;
	
	Commentaire findCommentbyTopoId(Integer id) throws NotFoundException;

}
