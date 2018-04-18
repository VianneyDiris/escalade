package org.escalade.demo.consumer.contract.dao.spot;

import java.util.List;

import org.escalade.demo.model.bean.spot.Voie;

public interface VoieDao {
	
	List<Voie> listVoie();
	
	Voie find(int id);
	
	void addVoie(Voie voie);
	
	void updateVoie(Voie voie);
	
	void deleteVoie(Voie voie);

}
