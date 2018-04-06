package org.escalade.demo.consumer.impl.rowmapper.spot;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.escalade.demo.model.bean.spot.Ville;
import org.springframework.jdbc.core.RowMapper;

public class VilleRM implements RowMapper<Ville> {

	public Ville mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Ville ville = new Ville();
		ville.setId(rs.getInt("id"));
		ville.setNom(rs.getString("nom"));
		ville.setCodePostal(rs.getInt("codePostal"));
		
		//rowMapper pour pays
		return ville;
	}

}
