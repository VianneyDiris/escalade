package org.escalade.demo.consumer.contract.dao.spot;

import java.util.List;

import org.escalade.demo.model.bean.spot.Secteur;

public interface SecteurDao {
	
	List<Secteur> listSecteur();
	
	Secteur find(Integer id);
	
	void addSecteur(Secteur secteur);
	
	void updateSecteur(Secteur secteur);
	
	void deleteSecteur(Secteur secteur);
	
	List<Secteur> listSecteurBySpot(Integer id);

}
