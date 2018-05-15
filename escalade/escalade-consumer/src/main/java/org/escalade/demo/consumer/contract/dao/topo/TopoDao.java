package org.escalade.demo.consumer.contract.dao.topo;

import java.util.List;

import org.escalade.demo.model.bean.topo.Topo;

public interface TopoDao {
	
	List<Topo> listTopo();
	
	Topo find(Integer id);
	
	void addTopo(Topo topo);
	
	void updateTopo(Topo topo);
	
	void deleteTopo(Integer id);

}
