package org.escalade.demo.business.contract.manager.spot;

import java.util.List;

import org.escalade.demo.model.bean.spot.Voie;
import org.escalade.demo.model.exception.NotFoundException;

public interface VoieManager {
	
	// ==================== Voie ====================	
		List<Voie> getListVoie();
					
		//renvoie la voie grâce à son id
		Voie getVoie(Integer id) throws NotFoundException;

}
