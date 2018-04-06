package org.escalade.demo.consumer.impl.rowmapper.topo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.escalade.demo.model.bean.topo.Topo;
import org.springframework.jdbc.core.RowMapper;

public class TopoRM implements RowMapper<Topo>{

	public Topo mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Topo topo = new Topo();
		topo.setId(rs.getInt("id"));
		topo.setNom(rs.getString("nom"));
		topo.setDescription(rs.getString("description"));
		topo.setPhoto(rs.getString("photo"));
		topo.setPrive(rs.getBoolean("prive"));
		topo.setReserve(rs.getBoolean("reserve"));
		
		return topo;
	}

}
