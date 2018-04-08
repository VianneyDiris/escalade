package org.escalade.demo.business.impl.manager.spot;

import java.util.List;

import org.escalade.demo.business.contract.manager.spot.OrientationManager;
import org.escalade.demo.business.impl.AbstractManagerImpl;
import org.escalade.demo.model.bean.spot.Orientation;
import org.escalade.demo.model.exception.NotFoundException;

public class OrientationManagerImpl extends AbstractManagerImpl implements OrientationManager {

	@Override
	public List<Orientation> getListOrientation() {
		// TODO Auto-generated method stub
		return getDaoFactory().getOrientationDao().listOrientation();
	}

	@Override
	public Orientation getOrientation(Integer id) throws NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
