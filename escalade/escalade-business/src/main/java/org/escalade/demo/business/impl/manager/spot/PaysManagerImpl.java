package org.escalade.demo.business.impl.manager.spot;

import java.util.List;

import org.escalade.demo.business.contract.manager.spot.PaysManager;
import org.escalade.demo.business.impl.AbstractManagerImpl;
import org.escalade.demo.model.bean.spot.Pays;
import org.escalade.demo.model.exception.NotFoundException;

public class PaysManagerImpl extends AbstractManagerImpl implements PaysManager {

	@Override
	public List<Pays> getListPays() {
		// TODO Auto-generated method stub
		return getDaoFactory().getPaysDao().listPays();
	}

	@Override
	public Pays getPays(Integer id) throws NotFoundException {
		// TODO Auto-generated method stub
		return getDaoFactory().getPaysDao().find(id);
	}

	@Override
	public List<Pays> allPays() {
		// TODO Auto-generated method stub
		return getDaoFactory().getPaysDao().allPays();
	}

}
