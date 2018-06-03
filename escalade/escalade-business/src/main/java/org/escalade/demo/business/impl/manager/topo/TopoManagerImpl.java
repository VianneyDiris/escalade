package org.escalade.demo.business.impl.manager.topo;

import java.util.List;

import org.escalade.demo.business.contract.manager.topo.TopoManager;
import org.escalade.demo.business.impl.AbstractManagerImpl;
import org.escalade.demo.model.bean.spot.Spot;
import org.escalade.demo.model.bean.topo.Topo;
import org.escalade.demo.model.exception.NotFoundException;

public class TopoManagerImpl extends AbstractManagerImpl implements TopoManager {

	@Override
	public List<Topo> getListTopo() {
		// TODO Auto-generated method stub
		return getDaoFactory().getTopoDao().listTopo();
	}

	@Override
	public Topo getTopo(Integer id) throws NotFoundException {
		// TODO Auto-generated method stub
		return getDaoFactory().getTopoDao().find(id);
	}

	@Override
	public void deleteTopo(Integer id) throws NotFoundException {
		// TODO Auto-generated method stub
		getDaoFactory().getTopoDao().deleteTopo(id);
		
	}

	@Override
	public Topo getTopoBySpot(Spot spot) throws NotFoundException {
		// TODO Auto-generated method stub
		return getDaoFactory().getTopoDao().getTopoBySpot(spot);
	}

	@Override
	public void updateTopo(Topo topo) {
		// TODO Auto-generated method stub
		getDaoFactory().getTopoDao().updateTopo(topo);		
	}

	@Override
	public List<Topo> listTopoBySpot(Spot spot) throws NotFoundException {
		// TODO Auto-generated method stub
		return getDaoFactory().getTopoDao().listTopoBySpot(spot);
	}

	@Override
	public void addTopo(Topo topo) {
		// TODO Auto-generated method stub
		getDaoFactory().getTopoDao().addTopo(topo);
	}

	

}
