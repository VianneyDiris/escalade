package org.escalade.demo.consumer.impl.dao.topo;

import java.util.List;

import org.escalade.demo.consumer.contract.dao.topo.RoleDao;
import org.escalade.demo.consumer.impl.dao.AbstractDaoImpl;
import org.escalade.demo.consumer.impl.rowmapper.topo.RoleRM;
import org.escalade.demo.model.bean.topo.Role;
import org.springframework.jdbc.core.JdbcTemplate;

public class RoleDaoImpl extends AbstractDaoImpl implements RoleDao {

	@Override
	public List<Role> listRole() {
		// TODO Auto-generated method stub
		String vsql = "SELECT * FROM public.role";
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		RoleRM rowRole = new RoleRM();
		
		List<Role> listRoles = vJdbcTemplate.query(vsql, rowRole);
		return listRoles;
	}

	@Override
	public void addRole(Role role) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateRole(Role role) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteRole(Role role) {
		// TODO Auto-generated method stub
		
	}

}
