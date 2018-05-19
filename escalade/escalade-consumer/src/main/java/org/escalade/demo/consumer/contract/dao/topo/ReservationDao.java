package org.escalade.demo.consumer.contract.dao.topo;

import java.util.List;

import org.escalade.demo.model.bean.topo.Reservation;

public interface ReservationDao {

	List<Reservation> listReservation();
	
	Reservation find(int id);
	
	void addReservation(Reservation reservation);
	
	void updateReservation(Reservation reservation);
	
	void deleteReservation(Reservation reservation);
	
	void deleteReservationByUser(Integer id);
	
	void deleteReservationByTopo(Integer id);
}
