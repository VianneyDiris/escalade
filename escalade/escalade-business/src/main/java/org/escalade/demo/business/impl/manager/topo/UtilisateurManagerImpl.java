package org.escalade.demo.business.impl.manager.topo;

import java.util.List;

import org.escalade.demo.business.contract.manager.topo.UtilisateurManager;
import org.escalade.demo.business.impl.AbstractManagerImpl;
import org.escalade.demo.model.bean.topo.Utilisateur;
import org.escalade.demo.model.exception.NotFoundException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class UtilisateurManagerImpl extends AbstractManagerImpl implements UtilisateurManager {
	 static final Log logger = LogFactory.getLog(UtilisateurManagerImpl.class);
	
	
	@Override
	public List<Utilisateur> getListUtilisateur() {
		// TODO Auto-generated method stub
		logger.debug("UtilisateurManagerImpl méthode getListUtilisateur()");
		return getDaoFactory().getUtilisateurDao().listUtilisateur();
	}

	@Override
	public Utilisateur getUtilisateur(Integer id) throws NotFoundException {
		// TODO Auto-generated method stub
		logger.debug("UtilisateurManagerImpl méthode getUtilisateur() avec un id: "+id);
		return getDaoFactory().getUtilisateurDao().find(id);
	}

	@Override
	public Utilisateur getUtilisateur(String pseudo, String password) throws NotFoundException {
		// TODO Auto-generated method stub
		logger.debug("UtilisateurManagerImpl méthode getUtilisateur() avec pseudo: "+pseudo);
		return getDaoFactory().getUtilisateurDao().search(pseudo, password);
	}

	@Override
	public void addUtilisateur(Utilisateur user) {
		// TODO Auto-generated method stub
		logger.debug("UtilisateurManagerImpl méthode addUtilisateur()"); 
        getDaoFactory().getUtilisateurDao().addUtilisateur(user);
	}

	@Override
	public void deleteUtilisateur(Utilisateur user) {
		// TODO Auto-generated method stub
		logger.debug("UtilisateurManagerImpl méthode deleteUtilisateur() avec id: "+user.getId());
		getDaoFactory().getUtilisateurDao().deleteUtilisateur(user.getId());
		
	}

	@Override
	public void updateUtilisateur(Utilisateur user) {
		// TODO Auto-generated method stub
		logger.debug("UtilisateurManagerImpl méthode updateUtilisateur() avec id: "+user.getId());
		getDaoFactory().getUtilisateurDao().updateUtilisateur(user);
		
	}
		

}
