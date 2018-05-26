package org.escalade.demo.business.contract.manager.spot;

import java.util.List;

import org.escalade.demo.model.bean.spot.Pays;
import org.escalade.demo.model.exception.NotFoundException;

public interface PaysManager {
	
	// ==================== Pays ====================	
	List<Pays> getListPays();
	
	List<Pays> allPays();
		
	//renvoie le pays grâce à son id
	Pays getPays(Integer id) throws NotFoundException;

}
