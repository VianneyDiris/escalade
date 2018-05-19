package org.escalade.demo.business.impl.manager.spot;

import java.util.List;

import org.escalade.demo.business.contract.manager.spot.SecteurManager;
import org.escalade.demo.business.impl.AbstractManagerImpl;
import org.escalade.demo.model.bean.spot.Secteur;
import org.escalade.demo.model.exception.NotFoundException;

public class SecteurManagerImpl extends AbstractManagerImpl implements SecteurManager {

	@Override
	public List<Secteur> getListSecteur() {
		// TODO Auto-generated method stub
		return getDaoFactory().getSecteurDao().listSecteur();
	}

	@Override
	public Secteur getSecteur(Integer id) throws NotFoundException {
		// TODO Auto-generated method stub
		return getDaoFactory().getSecteurDao().find(id);
	}

	@Override
	public void deleteSecteur(Secteur secteur) throws NotFoundException {
		// TODO Auto-generated method stub
		getDaoFactory().getSecteurDao().deleteSecteur(secteur);
	}

	@Override
	public List<Secteur> listSecteurBySpot(Integer id) throws NotFoundException {
		// TODO Auto-generated method stub
		return getDaoFactory().getSecteurDao().listSecteurBySpot(id);
	}

}
