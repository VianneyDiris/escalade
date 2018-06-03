package org.escalade.demo.consumer.impl.dao.spot;

import java.util.List;

import org.escalade.demo.consumer.contract.dao.spot.SpotDao;
import org.escalade.demo.consumer.impl.dao.AbstractDaoImpl;
import org.escalade.demo.consumer.impl.rowmapper.spot.SpotRM;
import org.escalade.demo.model.bean.spot.Pays;
import org.escalade.demo.model.bean.spot.Spot;
import org.escalade.demo.model.bean.spot.Ville;
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
		String vsql = "INSERT INTO public.spot (nom,description,photo,pays_id,ville_id) VALUES (?,?,?,?,?)";
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		
		vJdbcTemplate.update(vsql,spot.getNom(),spot.getDescription(),spot.getPhoto(),spot.getPays().getId(),spot.getVille().getId());
		
	}

	@Override
	public void updateSpot(Spot spot) {
		// TODO Auto-generated method stub
		String vSQL = "UPDATE public.spot SET nom =?, description=?,pays_id=?,ville_id=? WHERE id = ?";
		 
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
	    vJdbcTemplate.update(vSQL,spot.getNom(),spot.getDescription(),spot.getPays().getId(),spot.getVille().getId(),spot.getId());
		
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

	@Override
	public List<Spot> allSpot() {
		// TODO Auto-generated method stub
		String vsql = "SELECT * FROM public.spot";
				
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		SpotRM rowSpot = new SpotRM();
			
		List<Spot> listSpots = vJdbcTemplate.query(vsql, rowSpot);
			
		return listSpots;
	}

	@Override
	public List<Spot> listSpotByPays(Pays pays) {
		String vsql = "SELECT * FROM public.spot where pays_id=?";
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		SpotRM rowSpot = new SpotRM();
		
		List<Spot> listSpots = vJdbcTemplate.query(vsql,new Object[] { pays.getId() } ,rowSpot);
		
		return listSpots;
	}

	@Override
	public List<Spot> listSpotByVille(Ville ville) {
		String vsql = "SELECT * FROM public.spot where ville_id=?";
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		SpotRM rowSpot = new SpotRM();
		
		List<Spot> listSpots = vJdbcTemplate.query(vsql,new Object[] { ville.getId() } ,rowSpot);
		
		return listSpots;
	}

}
