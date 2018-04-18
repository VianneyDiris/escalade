package org.escalade.demo.consumer.impl.rowmapper.spot;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.escalade.demo.consumer.impl.DaoFactoryImpl;
import org.escalade.demo.model.bean.spot.Secteur;
import org.springframework.jdbc.core.RowMapper;

public class SecteurRM implements RowMapper<Secteur>{

	public Secteur mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Secteur secteur = new Secteur();
		secteur.setId(rs.getInt("id"));
		secteur.setNom(rs.getString("nom"));
		
		//rowMapper spot
		DaoFactoryImpl daoFactory = new DaoFactoryImpl();
		secteur.setSpot(daoFactory.getSpotDao().find(rs.getInt("site_id")));
		
		return secteur;
	}

	

}
