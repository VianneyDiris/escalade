package org.escalade.demo.business.contract.manager.topo;

import java.util.List;

import org.escalade.demo.model.bean.topo.Reservation;
import org.escalade.demo.model.exception.NotFoundException;

public interface ReservationManager {
	
	// ==================== Reservation ====================
	List<Reservation> getListReservation();
		
	//renvoie la réservation grâce à son id
	Reservation getReservation(Integer id) throws NotFoundException;

}