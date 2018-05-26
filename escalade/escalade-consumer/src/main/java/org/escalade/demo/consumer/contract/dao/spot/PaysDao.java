package org.escalade.demo.consumer.contract.dao.spot;

import java.util.List;

import org.escalade.demo.model.bean.spot.Pays;

public interface PaysDao {
	
	List<Pays> listPays();
	
	List<Pays> allPays();
	
	Pays find(Integer id);
	
	void addPays(Pays pays);
	
	void updatePays(Pays pays);
	
	void deletePays(Pays pays);

}
