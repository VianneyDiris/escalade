package org.escalade.demo.consumer.contract.dao.spot;

import java.util.List;

import org.escalade.demo.model.bean.spot.Ville;

public interface VilleDao {
	
	List<Ville> listVille();
	
	List<Ville> allVille();
	
	Ville find(Integer id);
	
	void addVille(Ville ville);
	
	void updateVille(Ville ville);
	
	void deleteVille(Ville ville);

}
