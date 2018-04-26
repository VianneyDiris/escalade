package org.escalade.demo.consumer.impl.rowmapper.spot;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.escalade.demo.consumer.impl.DaoFactoryImpl;
import org.escalade.demo.consumer.impl.dao.spot.PaysDaoImpl;
import org.escalade.demo.model.bean.spot.Ville;
import org.springframework.jdbc.core.RowMapper;

public class VilleRM implements RowMapper<Ville> {

	public Ville mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Ville ville = new Ville();
		ville.setId(rs.getInt("id"));
		ville.setNom(rs.getString("nom"));
		ville.setCodePostal(rs.getInt("code_postal"));
		
		//rowMapper pour pays
		DaoFactoryImpl daoFactory = new DaoFactoryImpl();
		PaysDaoImpl paysDao = new PaysDaoImpl();
		ville.setPays(paysDao.find(rs.getInt("pays_id")));
		
		return ville;
	}

}
