package org.escalade.demo.business.impl.manager.topo;

import java.util.List;

import org.escalade.demo.business.contract.manager.topo.CommentaireManager;
import org.escalade.demo.business.impl.AbstractManagerImpl;
import org.escalade.demo.model.bean.topo.Commentaire;
import org.escalade.demo.model.exception.NotFoundException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CommentaireManagerImpl extends AbstractManagerImpl implements CommentaireManager {
	static final Log logger = LogFactory.getLog(CommentaireManagerImpl.class);

	@Override
	public List<Commentaire> getListCommentaire() {
		logger.debug("CommentaireManagerImpl méthode getListCommentaire()");
		// TODO Auto-generated method stub
		return getDaoFactory().getCommentaireDao().listCommentaire();
	}

	@Override
	public Commentaire getCommentaire(Integer id) throws NotFoundException {
		logger.debug("CommentaireManagerImpl méthode getCommentaire(id) "+id);
		// TODO Auto-generated method stub
		return getDaoFactory().getCommentaireDao().find(id);
	}

	@Override
	public void deleteCommentaire(Integer id) throws NotFoundException{
		logger.debug("CommentaireManagerImpl méthode deleteCommentaire(id) "+id);
		// TODO Auto-generated method stub
		getDaoFactory().getCommentaireDao().deleteCommentaire(id);
		
	}

	@Override
	public void updateCommentaire(Commentaire commentaire) {
		logger.debug("CommentaireManagerImpl méthode updateCommentaire(commentaire) "+commentaire.getId());
		// TODO Auto-generated method stub
		getDaoFactory().getCommentaireDao().updateCommentaire(commentaire);
		
	}

	@Override
	public void deleteCommentaireByUser(Integer id) throws NotFoundException {
		logger.debug("CommentaireManagerImpl méthode deleteCommentaireByUser(id) id = "+id);
		// TODO Auto-generated method stub
		getDaoFactory().getCommentaireDao().deleteCommentaireByUser(id);
		
	}

	@Override
	public void deleteCommentaireByTopo(Integer id) throws NotFoundException {
		logger.debug("CommentaireManagerImpl méthode deleteCommentaireByTopo(id) id = "+id);
		// TODO Auto-generated method stub
		getDaoFactory().getCommentaireDao().deleteCommentaireByTopo(id);
		
	}

	@Override
	public void deleteCommentaireBySpot(Integer id) throws NotFoundException {
		logger.debug("CommentaireManagerImpl méthode deleteCommentaireBySpot(id) id = "+id);
		// TODO Auto-generated method stub
		getDaoFactory().getCommentaireDao().deleteCommentaireBySpot(id);
		
	}

	@Override
	public List<Commentaire> getListCommentaireByTopo(Integer id) throws NotFoundException {
		// TODO Auto-generated method stub
		return getDaoFactory().getCommentaireDao().listCommentaireByTopo(id);
	}

	@Override
	public List<Commentaire> getListCommentaireBySpot(Integer id) throws NotFoundException {
		// TODO Auto-generated method stub
		return getDaoFactory().getCommentaireDao().listCommentaireBySpot(id);
	}

	@Override
	public void addCommentaire(Commentaire commentaire) {
		// TODO Auto-generated method stub
		getDaoFactory().getCommentaireDao().addCommentaire(commentaire);
	}

}
