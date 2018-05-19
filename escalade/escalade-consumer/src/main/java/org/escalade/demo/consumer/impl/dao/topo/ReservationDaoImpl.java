package org.escalade.demo.consumer.impl.dao.topo;

import java.util.List;

import org.escalade.demo.consumer.contract.dao.topo.ReservationDao;
import org.escalade.demo.consumer.impl.dao.AbstractDaoImpl;
import org.escalade.demo.consumer.impl.rowmapper.topo.ReservationRM;
import org.escalade.demo.model.bean.topo.Reservation;
import org.springframework.jdbc.core.JdbcTemplate;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ReservationDaoImpl extends AbstractDaoImpl implements ReservationDao {
	static final Log logger = LogFactory.getLog(ReservationDaoImpl.class);

	@Override
	public List<Reservation> listReservation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reservation find(int id) {
		// TODO Auto-generated method stub
		String vsql ="SELECT * FROM public.reservation WHERE id= ?";
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		Reservation reservation=(Reservation)vJdbcTemplate.queryForObject(vsql, new Object[] { id }, new ReservationRM());
		
		return reservation;
	}

	@Override
	public void addReservation(Reservation reservation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateReservation(Reservation reservation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteReservation(Reservation reservation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteReservationByUser(Integer id) {
		// TODO Auto-generated method stub
		String vsql="DELETE FROM public.reservation WHERE utilisateur_id=?";
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		vJdbcTemplate.update(vsql,new Object[] { id });
		
	}

	@Override
	public void deleteReservationByTopo(Integer id) {
		logger.debug("ReservationDaoImpl méthode deleteReservationByTopo(Integer id) id = "+id);
		// TODO Auto-generated method stub
		String vsql="DELETE FROM public.reservation WHERE topo_id=?";
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		vJdbcTemplate.update(vsql,new Object[] { id });
	}

}
