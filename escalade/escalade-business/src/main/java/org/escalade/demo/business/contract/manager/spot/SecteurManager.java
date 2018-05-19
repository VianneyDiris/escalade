package org.escalade.demo.business.contract.manager.spot;

import java.util.List;

import org.escalade.demo.model.bean.spot.Secteur;
import org.escalade.demo.model.exception.NotFoundException;

public interface SecteurManager {
	
	// ==================== Secteur ====================	
	List<Secteur> getListSecteur();
				
	//renvoie le secteur grâce à son id
	Secteur getSecteur(Integer id) throws NotFoundException;
	
	void deleteSecteur(Secteur secteur) throws NotFoundException;
	
	List<Secteur> listSecteurBySpot(Integer id) throws NotFoundException;

}
