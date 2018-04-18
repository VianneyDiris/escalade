package org.escalade.demo.consumer.contract.dao.spot;

import java.util.List;

import org.escalade.demo.model.bean.spot.Orientation;

public interface OrientationDao {

	List<Orientation> listOrientation();
	
	Orientation find(int id);
	
	void addOrientation(Orientation orientation);
	
	void updateOrientation(Orientation orientation);
	
	void deleteOrientation(Orientation orientation);
}
