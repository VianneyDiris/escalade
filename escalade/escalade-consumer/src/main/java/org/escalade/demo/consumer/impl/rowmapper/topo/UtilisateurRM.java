package org.escalade.demo.consumer.impl.rowmapper.topo;

import java.sql.ResultSet;
import java.sql.SQLException;

//import org.escalade.demo.consumer.impl.DaoFactoryImpl;
import org.escalade.demo.consumer.impl.dao.topo.RoleDaoImpl;
import org.escalade.demo.model.bean.topo.Utilisateur;
import org.springframework.jdbc.core.RowMapper;

public class UtilisateurRM implements RowMapper<Utilisateur>{

	public Utilisateur mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Utilisateur user = new Utilisateur();
		user.setId(rs.getInt("id"));
		user.setNom(rs.getString("nom"));
		user.setPrenom(rs.getString("prenom"));
		user.setPseudo(rs.getString("pseudo"));
		user.setMail(rs.getString("mail"));
		user.setPassword(rs.getString("password"));
		
		//rowMapper role
//		DaoFactoryImpl daoFactory = new DaoFactoryImpl();
		RoleDaoImpl roleDao = new RoleDaoImpl();
		user.setRole(roleDao.find(rs.getInt("role_id")));
		
		return user;
	}

}
