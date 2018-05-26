package org.escalade.demo.business.contract.manager.spot;

import java.util.List;

import org.escalade.demo.model.bean.spot.Ville;
import org.escalade.demo.model.exception.NotFoundException;

public interface VilleManager {
	
	// ==================== Ville ====================	
	List<Ville> getListVille();
	
	List<Ville> allVille();
			
	//renvoie la ville grâce à son id
	Ville getVille(Integer id) throws NotFoundException;

}
