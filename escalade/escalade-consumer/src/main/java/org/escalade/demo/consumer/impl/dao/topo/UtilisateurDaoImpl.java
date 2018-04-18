package org.escalade.demo.consumer.impl.dao.topo;

import java.util.List;

import org.escalade.demo.consumer.contract.dao.topo.UtilisateurDao;
import org.escalade.demo.consumer.impl.dao.AbstractDaoImpl;
import org.escalade.demo.consumer.impl.rowmapper.topo.UtilisateurRM;
import org.escalade.demo.model.bean.topo.Utilisateur;
import org.springframework.jdbc.core.JdbcTemplate;

public class UtilisateurDaoImpl extends AbstractDaoImpl implements UtilisateurDao {

	@Override
	public List<Utilisateur> listUtilisateur() {
		// TODO Auto-generated method stub
		String vsql="SELECT * FROM public.utilisateur";
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		UtilisateurRM rowUtilisateur = new UtilisateurRM();
		
		List<Utilisateur> listUtilisateurs = vJdbcTemplate.query(vsql, rowUtilisateur);
		
		return listUtilisateurs;
	}

	@Override
	public void addUtilisateur(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUtilisateur(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUtilisateur(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Utilisateur find(int id) {
		// TODO Auto-generated method stub
		String vsql ="SELECT * FROM public.utilisateur WHERE id= ?";
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		Utilisateur utilisateur=(Utilisateur)vJdbcTemplate.queryForObject(vsql, new Object[] { id }, new UtilisateurRM());
		
		return utilisateur;
	}

}
