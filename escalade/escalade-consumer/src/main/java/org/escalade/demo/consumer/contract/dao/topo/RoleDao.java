package org.escalade.demo.consumer.contract.dao.topo;

import java.util.List;

import org.escalade.demo.model.bean.topo.Role;

public interface RoleDao {
	
	List<Role> listRole();
	
	Role find(int id);
	
	Role getRoleByName(String role);
	
	void addRole(Role role);
	
	void updateRole(Role role);
	
	void deleteRole(Role role);

}
