package org.escalade.demo.consumer.contract.dao.spot;

import java.util.List;

import org.escalade.demo.model.bean.spot.Cotation;

public interface CotationDao {
	
	List<Cotation> listCotation();
	
	void addCotation(Cotation cotation);
	
	void updateCotation(Cotation cotation);
	
	void deleteCotation(Cotation cotation);

}
