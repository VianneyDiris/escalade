package org.escalade.demo.business.contract.manager.topo;

import java.util.List;

import org.escalade.demo.model.bean.topo.Role;
import org.escalade.demo.model.exception.NotFoundException;

public interface RoleManager {

	// ==================== Role ====================
	List<Role> getListRole();
	
	//renvoie le role grâce à son id
	Role getRole(Integer id) throws NotFoundException;
}
