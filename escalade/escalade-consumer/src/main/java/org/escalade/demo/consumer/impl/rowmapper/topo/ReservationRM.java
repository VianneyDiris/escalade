package org.escalade.demo.consumer.impl.rowmapper.topo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.escalade.demo.model.bean.topo.Reservation;
import org.springframework.jdbc.core.RowMapper;

public class ReservationRM implements RowMapper<Reservation> {

	public Reservation mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Reservation reservation = new Reservation();
		reservation.setId(rs.getInt("id"));
		reservation.setDateDebut(rs.getDate("dateDebut"));
		reservation.setDateFin(rs.getDate("dateFin"));
		
		//rowMapper topo + utilisateur
		return reservation;
	}

}
