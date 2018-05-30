package org.escalade.demo.consumer.contract.dao.spot;

import java.util.List;

import org.escalade.demo.model.bean.spot.Pays;
import org.escalade.demo.model.bean.spot.Spot;
import org.escalade.demo.model.bean.spot.Ville;

public interface SpotDao {
	
	List<Spot> listSpot();
	
	List<Spot> allSpot();
	
	List<Spot> listSpotByPays(Pays pays);
	
	List<Spot> listSpotByVille(Ville ville);
	
	Spot find(Integer id);
	
	void addSpot(Spot spot);
	
	void updateSpot(Spot spot);
	
	void deleteSpot(Integer id);

}
