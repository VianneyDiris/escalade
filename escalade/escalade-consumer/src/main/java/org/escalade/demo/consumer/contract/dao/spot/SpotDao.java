package org.escalade.demo.consumer.contract.dao.spot;

import java.util.List;

import org.escalade.demo.model.bean.spot.Spot;

public interface SpotDao {
	
	List<Spot> listSpot();
	
	void addSpot(Spot spot);
	
	void updateSpot(Spot spot);
	
	void deleteSpot(Spot spot);

}
