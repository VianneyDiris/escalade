package org.escalade.demo.business.contract.manager;

import java.util.List;

import org.escalade.demo.model.bean.spot.*;
import org.escalade.demo.model.exception.NotFoundException;

public interface SpotManager {
	
	// ==================== Pays ====================	
	List<Pays> getListPays();
		
	//renvoie le pays grâce à son id
	Pays getPays(Integer id) throws NotFoundException;
	
	
	// ==================== Cotation ====================	
	List<Cotation> getListCotation();
	
	//renvoie la cotation grâce à son id
	Cotation getCotation(Integer id) throws NotFoundException;
	
	
	// ==================== Orientation ====================	
	List<Orientation> getListOrientation();
		
	//renvoie l'orientation grâce à son id
	Orientation getOrientation(Integer id) throws NotFoundException;
	
	
	// ==================== Ville ====================	
	List<Ville> getListVille();
			
	//renvoie la ville grâce à son id
	Ville getVille(Integer id) throws NotFoundException;
		
	
	// ==================== Secteur ====================	
	List<Secteur> getListSecteur();
				
	//renvoie le secteur grâce à son id
	Secteur getSecteur(Integer id) throws NotFoundException;
	
	
	// ==================== Voie ====================	
	List<Voie> getListVoie();
				
	//renvoie la voie grâce à son id
	Voie getVoie(Integer id) throws NotFoundException;
	
	
	// ==================== Spot ====================	
	List<Spot> getListSpot();
				
	//renvoie l'orientation grâce à son id
	Spot getSpot(Integer id) throws NotFoundException;
}
