package org.escalade.demo.business.contract.manager.topo;

import java.util.List;

import org.escalade.demo.model.bean.topo.Topo;
import org.escalade.demo.model.exception.NotFoundException;

public interface TopoManager {
	
	// ==================== Topo ====================
	List<Topo> getListTopo();
	
	//renvoie le topo grâce à son id
	Topo getTopo(Integer id) throws NotFoundException;
	
	void deleteTopo(Integer id)throws NotFoundException;

}
