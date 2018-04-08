package org.escalade.demo.business.impl.manager.spot;

import java.util.List;

import org.escalade.demo.business.contract.manager.spot.CotationManager;
import org.escalade.demo.business.impl.AbstractManagerImpl;
import org.escalade.demo.model.bean.spot.Cotation;
import org.escalade.demo.model.exception.NotFoundException;

public class CotationManagerImpl extends AbstractManagerImpl implements CotationManager {

	@Override
	public List<Cotation> getListCotation() {
		// TODO Auto-generated method stub
		return getDaoFactory().getCotationDao().listCotation();
	}

	@Override
	public Cotation getCotation(Integer id) throws NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
