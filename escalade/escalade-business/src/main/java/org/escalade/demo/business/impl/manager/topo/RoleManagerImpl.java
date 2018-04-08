package org.escalade.demo.business.impl.manager.topo;

import java.util.List;

import org.escalade.demo.business.contract.manager.topo.RoleManager;
import org.escalade.demo.business.impl.AbstractManagerImpl;
import org.escalade.demo.model.bean.topo.Role;
import org.escalade.demo.model.exception.NotFoundException;

public class RoleManagerImpl extends AbstractManagerImpl implements RoleManager {

	@Override
	public List<Role> getListRole() {
		// TODO Auto-generated method stub
		return getDaoFactory().getRoleDao().listRole();
	}

	@Override
	public Role getRole(Integer id) throws NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
