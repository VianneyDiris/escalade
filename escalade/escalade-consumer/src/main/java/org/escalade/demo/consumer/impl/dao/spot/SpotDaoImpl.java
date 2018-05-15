package org.escalade.demo.consumer.impl.dao.spot;

import java.util.List;

import org.escalade.demo.consumer.contract.dao.spot.SpotDao;
import org.escalade.demo.consumer.impl.dao.AbstractDaoImpl;
import org.escalade.demo.consumer.impl.rowmapper.spot.SpotRM;
import org.escalade.demo.model.bean.spot.Spot;
import org.springframework.jdbc.core.JdbcTemplate;

public class SpotDaoImpl extends AbstractDaoImpl implements SpotDao {

	@Override
	public List<Spot> listSpot() {
		// TODO Auto-generated method stub
		String vsql = "SELECT * FROM public.spot where id>1";
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		SpotRM rowSpot = new SpotRM();
		
		List<Spot> listSpots = vJdbcTemplate.query(vsql, rowSpot);
		
		return listSpots;
	}

	@Override
	public void addSpot(Spot spot) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateSpot(Spot spot) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteSpot(Integer id) {
		// TODO Auto-generated method stub
		String vsql="DELETE FROM public.spot WHERE id=?";
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		vJdbcTemplate.update(vsql,new Object[] { id });
		
	}

	@Override
	public Spot find(Integer id) {
		// TODO Auto-generated method stub
		String vsql ="SELECT * FROM public.spot WHERE id= ?";
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		Spot spot=(Spot)vJdbcTemplate.queryForObject(vsql, new Object[] { id }, new SpotRM());
		
		return spot;
	}

}
