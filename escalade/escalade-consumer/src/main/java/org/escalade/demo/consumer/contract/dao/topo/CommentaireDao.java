package org.escalade.demo.consumer.contract.dao.topo;

import java.util.List;

import org.escalade.demo.model.bean.topo.Commentaire;

public interface CommentaireDao {

	List<Commentaire> listCommentaire();
	
	void addCommentaire(Commentaire commentaire);
	
	void updateCommentaire(Commentaire commentaire);
	
	void deleteCommentaire(Commentaire commentaire);
}
