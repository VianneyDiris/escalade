package org.escalade.demo.consumer.contract.dao.topo;

import java.util.List;

import org.escalade.demo.model.bean.topo.Commentaire;

public interface CommentaireDao {

	List<Commentaire> listCommentaire();
	
	Commentaire find(int id);
	
	List<Commentaire> listCommentaireBySpot(Integer id);
	
	List<Commentaire> listCommentaireByTopo(Integer id);	
	
	void addCommentaire(Commentaire commentaire);
	
	void updateCommentaire(Commentaire commentaire);
	
	void deleteCommentaire(Integer id);
	
	void deleteCommentaireByUser(Integer id);
	
	void deleteCommentaireByTopo(Integer id);
	
	void deleteCommentaireBySpot(Integer id);
}
