package org.escalade.demo.consumer.impl.dao.spot;

import java.util.List;

import org.escalade.demo.consumer.contract.dao.spot.VilleDao;
import org.escalade.demo.consumer.impl.dao.AbstractDaoImpl;
import org.escalade.demo.consumer.impl.rowmapper.spot.VilleRM;
import org.escalade.demo.model.bean.spot.Ville;
import org.springframework.jdbc.core.JdbcTemplate;

public class VilleDaoImpl extends AbstractDaoImpl implements VilleDao {

	@Override
	public List<Ville> listVille() {
		// TODO Auto-generated method stub
		String vsql = "SELECT * FROM public.ville WHERE id>1";
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		VilleRM rowVille = new VilleRM();
		
		List<Ville> listVilles = vJdbcTemplate.query(vsql, rowVille);
		return listVilles;
	}

	@Override
	public void addVille(Ville ville) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateVille(Ville ville) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteVille(Ville ville) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Ville find(int id) {
		// TODO Auto-generated method stub
		String vsql ="SELECT * FROM public.ville WHERE id= ?";
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		Ville ville=(Ville)vJdbcTemplate.queryForObject(vsql, new Object[] { id }, new VilleRM());
		
		return ville;
	}

}
