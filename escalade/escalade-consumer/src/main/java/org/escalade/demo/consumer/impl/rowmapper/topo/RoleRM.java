package org.escalade.demo.consumer.impl.rowmapper.topo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.escalade.demo.model.bean.topo.Role;
import org.springframework.jdbc.core.RowMapper;

public class RoleRM implements RowMapper<Role> {

	public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Role role = new Role();
		role.setId(rs.getInt("id"));
		role.setRole(rs.getString("role"));
		
		return role;
	}

	

}
