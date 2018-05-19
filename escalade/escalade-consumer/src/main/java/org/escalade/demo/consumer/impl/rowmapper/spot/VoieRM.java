package org.escalade.demo.consumer.impl.rowmapper.spot;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.escalade.demo.consumer.impl.dao.spot.CotationDaoImpl;
import org.escalade.demo.consumer.impl.dao.spot.OrientationDaoImpl;
import org.escalade.demo.consumer.impl.dao.spot.SecteurDaoImpl;
import org.escalade.demo.model.bean.spot.Voie;
import org.springframework.jdbc.core.RowMapper;

public class VoieRM implements RowMapper<Voie> {

	public Voie mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Voie voie = new Voie();
		voie.setId(rs.getInt("id"));
		voie.setNom(rs.getString("nom"));
		voie.setNbLongueur(rs.getInt("nb_longueur"));
		
		//rowMapper cotation, orientation, secteur
		CotationDaoImpl cotationDao = new CotationDaoImpl();
		OrientationDaoImpl orientationDao = new OrientationDaoImpl();
		SecteurDaoImpl secteurDao = new SecteurDaoImpl();
		voie.setCotation(cotationDao.find(rs.getInt("cotation_id")));
		voie.setOrientation(orientationDao.find(rs.getInt("orientation_id")));
		voie.setSecteur(secteurDao.find(rs.getInt("secteur_id")));
		
		return voie;
	}

}
