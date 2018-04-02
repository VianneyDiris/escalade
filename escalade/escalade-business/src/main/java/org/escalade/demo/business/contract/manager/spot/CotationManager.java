package org.escalade.demo.business.contract.manager.spot;

import java.util.List;

import org.escalade.demo.model.bean.spot.Cotation;
import org.escalade.demo.model.exception.NotFoundException;

public interface CotationManager {

	// ==================== Cotation ====================	
	List<Cotation> getListCotation();
	
	//renvoie la cotation grâce à son id
	Cotation getCotation(Integer id) throws NotFoundException;
}
