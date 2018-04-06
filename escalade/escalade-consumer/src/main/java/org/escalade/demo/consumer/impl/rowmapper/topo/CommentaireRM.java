package org.escalade.demo.consumer.impl.rowmapper.topo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.escalade.demo.model.bean.topo.Commentaire;
import org.springframework.jdbc.core.RowMapper;

public class CommentaireRM implements RowMapper<Commentaire> {

	public Commentaire mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Commentaire commentaire = new Commentaire();
		commentaire.setId(rs.getInt("id"));
		commentaire.setContenue(rs.getString("contenue"));
		
		//rowMapper utilisateur, topo,spot
		return commentaire;
	}

}
