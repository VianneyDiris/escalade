package org.escalade.demo.consumer.impl.rowmapper.spot;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.escalade.demo.consumer.impl.DaoFactoryImpl;
import org.escalade.demo.model.bean.spot.Voie;
import org.springframework.jdbc.core.RowMapper;

public class VoieRM implements RowMapper<Voie> {

	public Voie mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Voie voie = new Voie();
		voie.setId(rs.getInt("id"));
		voie.setNom(rs.getString("nom"));
		voie.setNbLongueur(rs.getInt("nbLongueur"));
		
		//rowMapper cotation, orientation, secteur
		DaoFactoryImpl daoFactory = new DaoFactoryImpl();
		voie.setCotation(daoFactory.getCotationDao().find(rs.getInt("cotation_id")));
		voie.setOrientation(daoFactory.getOrientationDao().find(rs.getInt("orientation_id")));
		voie.setSecteur(daoFactory.getSecteurDao().find(rs.getInt("secteur_id")));
		
		return voie;
	}

}
