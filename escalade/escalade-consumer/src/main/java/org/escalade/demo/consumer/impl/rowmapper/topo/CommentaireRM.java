package org.escalade.demo.consumer.impl.rowmapper.topo;

import java.sql.ResultSet;
import java.sql.SQLException;

//import org.escalade.demo.consumer.impl.DaoFactoryImpl;
import org.escalade.demo.consumer.impl.dao.spot.SpotDaoImpl;
import org.escalade.demo.consumer.impl.dao.topo.TopoDaoImpl;
import org.escalade.demo.consumer.impl.dao.topo.UtilisateurDaoImpl;
import org.escalade.demo.model.bean.topo.Commentaire;
import org.springframework.jdbc.core.RowMapper;

public class CommentaireRM implements RowMapper<Commentaire> {

	public Commentaire mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Commentaire commentaire = new Commentaire();
		commentaire.setId(rs.getInt("id"));
		commentaire.setContenue(rs.getString("contenue"));
		
		//rowMapper utilisateur, topo,spot
//		DaoFactoryImpl daoFactory = new DaoFactoryImpl();
		UtilisateurDaoImpl userDao = new UtilisateurDaoImpl();
		TopoDaoImpl topoDao = new TopoDaoImpl();
		SpotDaoImpl spotDao = new SpotDaoImpl();
		commentaire.setUtilisateur(userDao.find(rs.getInt("utilisateur_id")));
		commentaire.setTopo(topoDao.find(rs.getInt("topo_id")));
		commentaire.setSpot(spotDao.find(rs.getInt("spot_id")));
		
		
		return commentaire;
	}

}
