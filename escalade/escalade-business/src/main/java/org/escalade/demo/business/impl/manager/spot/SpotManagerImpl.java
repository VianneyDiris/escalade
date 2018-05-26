package org.escalade.demo.business.impl.manager.spot;

import java.util.List;

import org.escalade.demo.business.contract.manager.spot.SpotManager;
import org.escalade.demo.business.impl.AbstractManagerImpl;
import org.escalade.demo.model.bean.spot.Spot;
import org.escalade.demo.model.exception.NotFoundException;

public class SpotManagerImpl extends AbstractManagerImpl implements SpotManager {

	@Override
	public List<Spot> getListSpot() {
		// TODO Auto-generated method stub
		return getDaoFactory().getSpotDao().listSpot();
	}

	@Override
	public Spot getSpot(Integer id) throws NotFoundException {
		// TODO Auto-generated method stub
		return getDaoFactory().getSpotDao().find(id);
	}

	@Override
	public void deleteSpot(Integer id) throws NotFoundException {
		// TODO Auto-generated method stub
		getDaoFactory().getSpotDao().deleteSpot(id);		
	}

	@Override
	public List<Spot> allSpot() {
		// TODO Auto-generated method stub
		return getDaoFactory().getSpotDao().allSpot();
	}

	@Override
	public void updateSpot(Spot spot) {
		// TODO Auto-generated method stub
		getDaoFactory().getSpotDao().updateSpot(spot);
	}

}
