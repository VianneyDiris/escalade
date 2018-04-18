package org.escalade.demo.consumer.impl.dao.topo;

import java.util.List;

import org.escalade.demo.consumer.contract.dao.topo.CommentaireDao;
import org.escalade.demo.consumer.impl.dao.AbstractDaoImpl;
import org.escalade.demo.consumer.impl.rowmapper.topo.CommentaireRM;
import org.escalade.demo.model.bean.topo.Commentaire;
import org.springframework.jdbc.core.JdbcTemplate;

public class CommentaireDaoImpl extends AbstractDaoImpl implements CommentaireDao {

	@Override
	public List<Commentaire> listCommentaire() {
		// TODO Auto-generated method stub
		String vsql = "SELECt * FROM public.commentaire";
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		CommentaireRM rowCommentaire = new CommentaireRM();
		
		List<Commentaire> listCommentaires = vJdbcTemplate.query(vsql, rowCommentaire);
		return listCommentaires;
	}

	@Override
	public void addCommentaire(Commentaire commentaire) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCommentaire(Commentaire commentaire) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCommentaire(Commentaire commentaire) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Commentaire find(int id) {
		// TODO Auto-generated method stub
		String vsql ="SELECT * FROM public.commentaire WHERE id= ?";
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		Commentaire commentaire=(Commentaire)vJdbcTemplate.queryForObject(vsql, new Object[] { id }, new CommentaireRM());
		
		return commentaire;
	}

}
