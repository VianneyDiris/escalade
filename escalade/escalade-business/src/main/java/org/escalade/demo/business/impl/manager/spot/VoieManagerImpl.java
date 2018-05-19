package org.escalade.demo.business.impl.manager.spot;

import java.util.List;

import org.escalade.demo.business.contract.manager.spot.VoieManager;
import org.escalade.demo.business.impl.AbstractManagerImpl;
import org.escalade.demo.model.bean.spot.Secteur;
import org.escalade.demo.model.bean.spot.Voie;
import org.escalade.demo.model.exception.NotFoundException;

public class VoieManagerImpl extends AbstractManagerImpl implements VoieManager {

	@Override
	public List<Voie> getListVoie() {
		// TODO Auto-generated method stub
		return getDaoFactory().getVoieDao().listVoie();
	}

	@Override
	public Voie getVoie(Integer id) throws NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Voie> listVoieBySecteur(Secteur secteur) throws NotFoundException {
		// TODO Auto-generated method stub
		return getDaoFactory().getVoieDao().listVoieBySecteur(secteur);
	}

	@Override
	public void deleteVoie(Voie voie) throws NotFoundException {
		// TODO Auto-generated method stub
		getDaoFactory().getVoieDao().deleteVoie(voie);
	}

}
