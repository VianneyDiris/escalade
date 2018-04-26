package org.escalade.demo.consumer.impl.rowmapper.spot;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.escalade.demo.consumer.impl.DaoFactoryImpl;
import org.escalade.demo.consumer.impl.dao.spot.PaysDaoImpl;
import org.escalade.demo.consumer.impl.dao.spot.VilleDaoImpl;
import org.escalade.demo.model.bean.spot.Spot;
import org.springframework.jdbc.core.RowMapper;

public class SpotRM implements RowMapper<Spot> {

	
	public Spot mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Spot spot = new Spot();
		spot.setId(rs.getInt("id"));
		spot.setNom(rs.getString("nom"));
		spot.setDescription(rs.getString("description"));
		spot.setPhoto(rs.getString("photo"));
		
		
		//demander pour rowMapper avec autre objet
		DaoFactoryImpl daoFactory = new DaoFactoryImpl();
		PaysDaoImpl paysDao = new PaysDaoImpl();
		VilleDaoImpl villeDao = new VilleDaoImpl();
		System.out.println("méthode rowmapper");
		spot.setPays(paysDao.find(rs.getInt("pays_id")));
		spot.setVille(villeDao.find(rs.getInt("ville_id")));
		
		return spot;
	}

}
