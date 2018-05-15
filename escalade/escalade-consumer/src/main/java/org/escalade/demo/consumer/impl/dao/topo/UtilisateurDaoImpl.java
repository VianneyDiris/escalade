package org.escalade.demo.consumer.impl.dao.topo;

import java.util.List;

import org.escalade.demo.consumer.contract.dao.topo.UtilisateurDao;
import org.escalade.demo.consumer.impl.dao.AbstractDaoImpl;
import org.escalade.demo.consumer.impl.rowmapper.topo.UtilisateurRM;
import org.escalade.demo.model.bean.topo.Utilisateur;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCrypt;


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
		String vsql = "INSERT INTO public.utilisateur (nom,prenom,pseudo,mail,password,role_id) VALUES (?,?,?,?,?,?)";
		
		String hashed = BCrypt.hashpw(utilisateur.getPassword(), BCrypt.gensalt());
		System.out.println(hashed);
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

		vJdbcTemplate.update(vsql,utilisateur.getNom(),utilisateur.getPrenom(),utilisateur.getPseudo(),utilisateur.getMail(),hashed,utilisateur.getRole().getId());
	}

	@Override
	public void updateUtilisateur(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUtilisateur(Integer id) {
		// TODO Auto-generated method stub
		String vsql = "DELETE FROM public.utilisateur WHERE id=?";
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		vJdbcTemplate.update(vsql, new Object[] { id });
	}

	@Override
	public Utilisateur find(Integer id) {
		// TODO Auto-generated method stub
		String vsql ="SELECT * FROM public.utilisateur WHERE id=?";
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		Utilisateur utilisateur=(Utilisateur)vJdbcTemplate.query(vsql, new Object[] { id }, new UtilisateurRM());
		if(utilisateur==null) {
			return null;
		}
		return utilisateur;
	}

	@Override
	public Utilisateur search(String pseudo, String password) {
		// TODO Auto-generated method stub
		String vsql = "SELECT * FROM public.utilisateur WHERE pseudo=?";
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		Utilisateur utilisateur=(Utilisateur)vJdbcTemplate.queryForObject(vsql, new Object[] { pseudo }, new UtilisateurRM());
		if (BCrypt.checkpw(password, utilisateur.getPassword())) {
            System.out.println("Correct login credentials");
            return utilisateur;
        }
		else {
			return null;
		}
		
	}

}
