package org.escalade.demo.business.contract;

import org.escalade.demo.business.contract.manager.SpotManager;
import org.escalade.demo.business.contract.manager.TopoManager;

public interface ManagerFactory {
	
	TopoManager getTopoManageur();
	SpotManager getSpotManager();

}
