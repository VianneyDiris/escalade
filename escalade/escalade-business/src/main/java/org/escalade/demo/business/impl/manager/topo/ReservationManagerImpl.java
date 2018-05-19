package org.escalade.demo.business.impl.manager.topo;

import java.util.List;

import org.escalade.demo.business.contract.manager.topo.ReservationManager;
import org.escalade.demo.business.impl.AbstractManagerImpl;
import org.escalade.demo.model.bean.topo.Reservation;
import org.escalade.demo.model.exception.NotFoundException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ReservationManagerImpl extends AbstractManagerImpl implements ReservationManager {
	static final Log logger = LogFactory.getLog(ReservationManagerImpl.class);

	@Override
	public List<Reservation> getListReservation() {
		logger.debug("ReservationManagerImpl méthode getListReservation()");
		// TODO Auto-generated method stub
		return getDaoFactory().getReservationDao().listReservation();
	}

	@Override
	public Reservation getReservation(Integer id) throws NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteReservationByTopo(Integer id) throws NotFoundException {
		logger.debug("ReservationManagerImpl méthode deleteReservationByTopo(Integer id) id = "+id);
		// TODO Auto-generated method stub
		getDaoFactory().getReservationDao().deleteReservationByTopo(id);
	}

	@Override
	public void deleteReservationByUser(Integer id) throws NotFoundException {
		logger.debug("ReservationManagerImpl méthode deleteReservationByUser(Integer id) id = "+id);
		// TODO Auto-generated method stub
		getDaoFactory().getReservationDao().deleteReservationByUser(id);
		
	}

}
