package org.escalade.demo.consumer.impl.rowmapper.spot;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.escalade.demo.model.bean.spot.Pays;
import org.springframework.jdbc.core.RowMapper;

public class PaysRM implements RowMapper<Pays> {

	
	public Pays mapRow(ResultSet rs, int rowNum) throws SQLException {
		Pays pays = new Pays();
		pays.setId(rs.getInt("id"));
		pays.setNom(rs.getString("nom"));
		pays.setCodePays(rs.getString("codePays"));
		return pays;
	}

}
