package org.escalade.demo.consumer.impl.rowmapper.spot;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.escalade.demo.model.bean.spot.Orientation;
import org.springframework.jdbc.core.RowMapper;

public class OrientationRM implements RowMapper<Orientation>{

	public Orientation mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Orientation orientation = new Orientation();
		orientation.setId(rs.getInt("id"));
		orientation.setOrientation(rs.getString("orientation"));
		return orientation;
	}

}
