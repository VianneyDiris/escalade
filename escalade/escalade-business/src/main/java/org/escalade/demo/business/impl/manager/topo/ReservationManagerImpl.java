package org.escalade.demo.business.impl.manager.topo;

import java.util.List;

import org.escalade.demo.business.contract.manager.topo.ReservationManager;
import org.escalade.demo.business.impl.AbstractManagerImpl;
import org.escalade.demo.model.bean.topo.Reservation;
import org.escalade.demo.model.exception.NotFoundException;

public class ReservationManagerImpl extends AbstractManagerImpl implements ReservationManager {

	@Override
	public List<Reservation> getListReservation() {
		// TODO Auto-generated method stub
		return getDaoFactory().getReservationDao().listReservation();
	}

	@Override
	public Reservation getReservation(Integer id) throws NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
