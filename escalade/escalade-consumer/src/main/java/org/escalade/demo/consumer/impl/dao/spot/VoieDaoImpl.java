package org.escalade.demo.consumer.impl.dao.spot;

import java.util.List;

import org.escalade.demo.consumer.contract.dao.spot.VoieDao;
import org.escalade.demo.consumer.impl.dao.AbstractDaoImpl;
import org.escalade.demo.consumer.impl.rowmapper.spot.VoieRM;
import org.escalade.demo.model.bean.spot.Secteur;
import org.escalade.demo.model.bean.spot.Voie;
import org.springframework.jdbc.core.JdbcTemplate;

public class VoieDaoImpl extends AbstractDaoImpl implements VoieDao {

	@Override
	public List<Voie> listVoie() {
		// TODO Auto-generated method stub
		String vsql = "SELECT * FROM public.voie";
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		VoieRM rowVoie = new VoieRM();
		
		List<Voie> listVoies = vJdbcTemplate.query(vsql, rowVoie);
		return listVoies;
	}

	@Override
	public void addVoie(Voie voie) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateVoie(Voie voie) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteVoie(Voie voie) {
		// TODO Auto-generated method stub
		String vsql ="DELETE FROM public.voie WHERE id=?";
		System.out.println(voie.getId()+" "+voie.getNom()+" "+voie.getNbLongueur());
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		vJdbcTemplate.update(vsql, new Object[] { voie.getId() });
		
	}

	@Override
	public Voie find(int id) {
		// TODO Auto-generated method stub
		String vsql ="SELECT * FROM public.voie WHERE id= ?";
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		Voie voie=(Voie)vJdbcTemplate.queryForObject(vsql, new Object[] { id }, new VoieRM());
		
		return voie;
	}

	@Override
	public List<Voie> listVoieBySecteur(Secteur secteur) {
		String vsql = "SELECT * FROM public.voie WHERE secteur_id=?";
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		VoieRM rowVoie = new VoieRM();
		
		List<Voie> listVoies = vJdbcTemplate.query(vsql,new Object[] { secteur.getId() } ,rowVoie);
		return listVoies;
	}

}
