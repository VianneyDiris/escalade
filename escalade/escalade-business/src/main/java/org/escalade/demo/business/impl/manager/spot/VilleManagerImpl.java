package org.escalade.demo.business.impl.manager.spot;

import java.util.List;

import org.escalade.demo.business.contract.manager.spot.VilleManager;
import org.escalade.demo.business.impl.AbstractManagerImpl;
import org.escalade.demo.model.bean.spot.Ville;
import org.escalade.demo.model.exception.NotFoundException;

public class VilleManagerImpl extends AbstractManagerImpl implements VilleManager {

	@Override
	public List<Ville> getListVille() {
		// TODO Auto-generated method stub
		return getDaoFactory().getVilleDao().listVille();
	}

	@Override
	public Ville getVille(Integer id) throws NotFoundException {
		// TODO Auto-generated method stub
		return getDaoFactory().getVilleDao().find(id);
	}

	@Override
	public List<Ville> allVille() {
		// TODO Auto-generated method stub
		return getDaoFactory().getVilleDao().allVille();
	}

}
