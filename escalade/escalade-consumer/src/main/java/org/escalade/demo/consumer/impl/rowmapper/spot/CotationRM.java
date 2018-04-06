package org.escalade.demo.consumer.impl.rowmapper.spot;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.escalade.demo.model.bean.spot.Cotation;
import org.springframework.jdbc.core.RowMapper;

public class CotationRM implements RowMapper<Cotation> {

	@Override
	public Cotation mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Cotation cotation = new Cotation();
		cotation.setId(rs.getInt("id"));
		cotation.setCotation(rs.getString("cotation"));
		
		
		return cotation;
	}

}
