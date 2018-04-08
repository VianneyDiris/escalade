package org.escalade.demo.consumer.impl.dao.spot;

import java.util.List;

import org.escalade.demo.consumer.contract.dao.spot.CotationDao;
import org.escalade.demo.consumer.impl.dao.AbstractDaoImpl;
import org.escalade.demo.consumer.impl.rowmapper.spot.CotationRM;
import org.escalade.demo.model.bean.spot.Cotation;
import org.springframework.jdbc.core.JdbcTemplate;

public class OrientationDaoImpl extends AbstractDaoImpl implements CotationDao {

	@Override
	public List<Cotation> listCotation() {
		// TODO Auto-generated method stub
		String vsql = "SELECT * FROM public.cotation";
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		CotationRM rowCotation = new CotationRM();
		
		List<Cotation> listCotations = vJdbcTemplate.query(vsql, rowCotation);
		
		return listCotations;
	}

	@Override
	public void addCotation(Cotation cotation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCotation(Cotation cotation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCotation(Cotation cotation) {
		// TODO Auto-generated method stub
		
	}

}
