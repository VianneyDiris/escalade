package org.escalade.demo.business.contract.manager.spot;

import java.util.List;

import org.escalade.demo.model.bean.spot.*;
import org.escalade.demo.model.exception.NotFoundException;

public interface SpotManager {
	
	// ==================== Spot ====================	
	List<Spot> getListSpot();
				
	//renvoie l'orientation grâce à son id
	Spot getSpot(Integer id) throws NotFoundException;
	
	void deleteSpot(Integer id)throws NotFoundException;
}
