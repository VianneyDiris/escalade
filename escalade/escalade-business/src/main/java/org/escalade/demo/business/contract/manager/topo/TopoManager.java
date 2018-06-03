package org.escalade.demo.business.contract.manager.topo;

import java.util.List;

import org.escalade.demo.model.bean.spot.Spot;
import org.escalade.demo.model.bean.topo.Topo;
import org.escalade.demo.model.exception.NotFoundException;

public interface TopoManager {
	
	// ==================== Topo ====================
	List<Topo> getListTopo();
	
	List<Topo> listTopoBySpot(Spot spot)throws NotFoundException;	
	//renvoie le topo grâce à son id
	Topo getTopo(Integer id) throws NotFoundException;
	
	void deleteTopo(Integer id)throws NotFoundException;
	
	Topo getTopoBySpot(Spot spot)throws NotFoundException;
	
	void updateTopo(Topo topo);
	
	void addTopo(Topo topo);
	
	

}
