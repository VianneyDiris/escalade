package org.escalade.demo.consumer.impl.dao.spot;

import java.util.List;

import org.escalade.demo.consumer.contract.dao.spot.OrientationDao;
import org.escalade.demo.consumer.impl.dao.AbstractDaoImpl;
import org.escalade.demo.consumer.impl.rowmapper.spot.OrientationRM;
import org.escalade.demo.model.bean.spot.Orientation;
import org.springframework.jdbc.core.JdbcTemplate;

public class OrientationDaoImpl extends AbstractDaoImpl implements OrientationDao {

	@Override
	public List<Orientation> listOrientation() {
		// TODO Auto-generated method stub
		String vsql = "SELECT * FROM public.orientation";
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		OrientationRM rowOrientation = new OrientationRM();
		
		List<Orientation> listOrientations = vJdbcTemplate.query(vsql, rowOrientation);
		
		return listOrientations;
	}
	@Override
	public Orientation find(int id) {
		// TODO Auto-generated method stub
		String vsql ="SELECT * FROM public.orientation WHERE id= ?";
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		Orientation orientation=(Orientation)vJdbcTemplate.queryForObject(vsql, new Object[] { id }, new OrientationRM());
		
		return orientation;
	}


	@Override
	public void addOrientation(Orientation orientation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOrientation(Orientation orientation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteOrientation(Orientation orientation) {
		// TODO Auto-generated method stub
		
	}

}
