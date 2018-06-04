package org.escalade.demo.business.contract.manager.topo;

import java.util.List;

import org.escalade.demo.model.bean.topo.Reservation;
import org.escalade.demo.model.exception.NotFoundException;

public interface ReservationManager {
	
	// ==================== Reservation ====================
	List<Reservation> getListReservation();
		
	//renvoie la réservation grâce à son id
	Reservation getReservation(Integer id) throws NotFoundException;
	
	List<Reservation> listReservationByTopo(Integer id) throws NotFoundException;
	
	void deleteReservationByTopo(Integer id)throws NotFoundException;
	
	void deleteReservationByUser(Integer id)throws NotFoundException;
	
	void addReservation(Reservation reservation);

}
