package org.escalade.demo.business.impl.manager.topo;

import java.util.List;

import org.escalade.demo.business.contract.manager.topo.CommentaireManager;
import org.escalade.demo.business.impl.AbstractManagerImpl;
import org.escalade.demo.model.bean.topo.Commentaire;
import org.escalade.demo.model.exception.NotFoundException;

public class CommentaireManagerImpl extends AbstractManagerImpl implements CommentaireManager {

	@Override
	public List<Commentaire> getListCommentaire() {
		// TODO Auto-generated method stub
		return getDaoFactory().getCommentaireDao().listCommentaire();
	}

	@Override
	public Commentaire getCommentaire(Integer id) throws NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Commentaire findCommentbySpotId(Integer id) throws NotFoundException {
		// TODO Auto-generated method stub
		return getDaoFactory().getCommentaireDao().findCommentbySpotId(id);
	}

	@Override
	public Commentaire findCommentbyTopoId(Integer id) throws NotFoundException {
		// TODO Auto-generated method stub
		return getDaoFactory().getCommentaireDao().findCommentbyTopoId(id);
	}

}
