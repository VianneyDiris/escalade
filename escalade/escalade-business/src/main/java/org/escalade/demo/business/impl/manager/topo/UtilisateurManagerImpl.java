package org.escalade.demo.business.impl.manager.topo;

import java.util.List;

import org.escalade.demo.business.contract.manager.topo.UtilisateurManager;
import org.escalade.demo.business.impl.AbstractManagerImpl;
import org.escalade.demo.model.bean.topo.Utilisateur;
import org.escalade.demo.model.exception.NotFoundException;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

public class UtilisateurManagerImpl extends AbstractManagerImpl implements UtilisateurManager {
	
	private PlatformTransactionManager platformTransactionManager;

	@Override
	public List<Utilisateur> getListUtilisateur() {
		// TODO Auto-generated method stub
		return getDaoFactory().getUtilisateurDao().listUtilisateur();
	}

	@Override
	public Utilisateur getUtilisateur(Integer id) throws NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utilisateur getUtilisateur(String pseudo, String password) throws NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addUtilisateur(Utilisateur user) {
		// TODO Auto-generated method stub
		TransactionTemplate vTransactionTemplate = new TransactionTemplate(platformTransactionManager);
		vTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
   
		void getDaoFactory().getUtilisateurDao().addUtilisateur(user);
	}
	
}

}
