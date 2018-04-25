package org.escalade.demo.consumer.impl.dao.spot;

import java.util.List;

import org.escalade.demo.consumer.contract.dao.spot.PaysDao;
import org.escalade.demo.consumer.impl.dao.AbstractDaoImpl;
import org.escalade.demo.consumer.impl.rowmapper.spot.PaysRM;
import org.escalade.demo.model.bean.spot.Pays;
import org.springframework.jdbc.core.JdbcTemplate;

public class PaysDaoImpl extends AbstractDaoImpl implements PaysDao {

	@Override
	public List<Pays> listPays() {
		// TODO Auto-generated method stub
		String vsql ="SELECT * FROM public.pays";
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		PaysRM rowPays = new PaysRM();
		
		List<Pays> listPays = vJdbcTemplate.query(vsql, rowPays);
		
		return listPays;
	}

	@Override
	public void addPays(Pays pays) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePays(Pays pays) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePays(Pays pays) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pays find(int id) {
		// TODO Auto-generated method stub
		String vsql ="SELECT * FROM public.pays WHERE id=?";
		System.out.println("méthode find");
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		Pays pays=(Pays)vJdbcTemplate.queryForObject(vsql, new Object[] { id }, new PaysRM());
		
		return pays;
	}

}
