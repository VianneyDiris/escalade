package org.escalade.demo.consumer.contract.dao.topo;

import java.util.List;

import org.escalade.demo.model.bean.topo.Role;

public interface RoleDao {
	
	List<Role> listRole();
	
	void addRole(Role role);
	
	void updateRole(Role role);
	
	void deleteRole(Role role);

}
