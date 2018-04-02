package org.escalade.demo.business.contract.manager.spot;

import java.util.List;

import org.escalade.demo.model.bean.spot.Orientation;
import org.escalade.demo.model.exception.NotFoundException;

public interface OrientationManager {
	
	// ==================== Orientation ====================	
	List<Orientation> getListOrientation();
		
	//renvoie l'orientation grâce à son id
	Orientation getOrientation(Integer id) throws NotFoundException;

}
