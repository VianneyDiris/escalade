package org.escalade.demo.consumer.impl.dao.spot;

import java.util.List;

import org.escalade.demo.consumer.contract.dao.spot.SecteurDao;
import org.escalade.demo.consumer.impl.dao.AbstractDaoImpl;
import org.escalade.demo.consumer.impl.rowmapper.spot.SecteurRM;
import org.escalade.demo.model.bean.spot.Secteur;
import org.springframework.jdbc.core.JdbcTemplate;

public class SecteurDaoImpl extends AbstractDaoImpl implements SecteurDao {

	@Override
	public List<Secteur> listSecteur() {
		// TODO Auto-generated method stub
		String vsql = "SELECT * FROM public.secteur";
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		SecteurRM rowSecteur = new SecteurRM();
		
		List<Secteur> listSecteurs = vJdbcTemplate.query(vsql, rowSecteur);
		
		return listSecteurs;
	}

	@Override
	public void addSecteur(Secteur secteur) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateSecteur(Secteur secteur) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteSecteur(Secteur secteur) {
		// TODO Auto-generated method stub
		String vsql ="DELETE FROM public.secteur WHERE id= ?";
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		vJdbcTemplate.update(vsql, new Object[] { secteur.getId() });
		
	}

	@Override
	public Secteur find(Integer id) {
		// TODO Auto-generated method stub
		String vsql ="SELECT * FROM public.secteur WHERE id= ?";
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		Secteur secteur=(Secteur)vJdbcTemplate.queryForObject(vsql, new Object[] { id }, new SecteurRM());
		
		return secteur;
	}

	@Override
	public List<Secteur> listSecteurBySpot(Integer id) {
		// TODO Auto-generated method stub
		String vsql = "SELECT * FROM public.secteur WHERE site_id=?";
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		SecteurRM rowSecteur = new SecteurRM();
		
		List<Secteur> listSecteurs = vJdbcTemplate.query(vsql, new Object[] { id },rowSecteur);
		
		return listSecteurs;
	}

}
