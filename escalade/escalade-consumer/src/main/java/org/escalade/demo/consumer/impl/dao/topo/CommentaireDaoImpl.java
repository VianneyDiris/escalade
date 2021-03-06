package org.escalade.demo.consumer.impl.dao.topo;

import java.util.List;

import org.escalade.demo.consumer.contract.dao.topo.CommentaireDao;
import org.escalade.demo.consumer.impl.dao.AbstractDaoImpl;
import org.escalade.demo.consumer.impl.rowmapper.topo.CommentaireRM;
import org.escalade.demo.model.bean.topo.Commentaire;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CommentaireDaoImpl extends AbstractDaoImpl implements CommentaireDao {
	static final Log logger = LogFactory.getLog(CommentaireDaoImpl.class);

	@Override
	public List<Commentaire> listCommentaire() {
		logger.debug("CommentaireDaoImpl méthode listCommentaire()");
		// TODO Auto-generated method stub
		String vsql = "SELECT * FROM public.commentaire";
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		CommentaireRM rowCommentaire = new CommentaireRM();
		
		List<Commentaire> listCommentaires = vJdbcTemplate.query(vsql, rowCommentaire);
		return listCommentaires;
	}

	@Override
	public void addCommentaire(Commentaire commentaire) {
		logger.debug("CommentaireDaoImpl méthode addCommentaire()");
		String vsql ="INSERT INTO public.commentaire (contenue,date_parution,utilisateur_id,topo_id,spot_id) VALUES(?,?,?,?,?)";
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		vJdbcTemplate.update(vsql,commentaire.getContenue(),commentaire.getDate(),commentaire.getUtilisateur().getId(),commentaire.getTopo().getId(),commentaire.getSpot().getId());
		
	}

	@Override
	public void updateCommentaire(Commentaire commentaire) {
		logger.debug("CommentaireDaoImpl méthode updateCommentaire()");
		// TODO Auto-generated method stub
		 String vSQL = "UPDATE public.commentaire SET contenue = ? WHERE id = ?";

	     JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
	     vJdbcTemplate.update(vSQL, commentaire.getContenue(),commentaire.getId());
				
	}

	@Override
	public void deleteCommentaire(Integer id) {
		logger.debug("CommentaireDaoImpl méthode deleteCommentaire()");
		// TODO Auto-generated method stub
		String vsql="DELETE FROM public.commentaire WHERE id=?";
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		vJdbcTemplate.update(vsql,new Object[] { id });
	}

	@Override
	public Commentaire find(int id) {
		logger.debug("CommentaireDaoImpl méthode find()");
		// TODO Auto-generated method stub
		String vsql ="SELECT * FROM public.commentaire WHERE id= ?";
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		Commentaire commentaire=(Commentaire)vJdbcTemplate.queryForObject(vsql, new Object[] { id }, new CommentaireRM());
		
		return commentaire;
	}

	@Override
	public void deleteCommentaireByUser(Integer id) {
		logger.debug("CommentaireDaoImpl méthode deleteCommentbyUser(Integer id) id = "+id);
		// TODO Auto-generated method stub
		String vsql="DELETE FROM public.commentaire WHERE utilisateur_id=?";
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		vJdbcTemplate.update(vsql,new Object[] { id });
		
	}

	@Override
	public void deleteCommentaireByTopo(Integer id) {
		logger.debug("CommentaireDaoImpl méthode deleteCommentaireByTopo(Integer id) id = "+id);
		// TODO Auto-generated method stub
		String vsql="DELETE FROM public.commentaire WHERE topo_id=?";
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		vJdbcTemplate.update(vsql,new Object[] { id });
		
	}

	@Override
	public void deleteCommentaireBySpot(Integer id) {
		logger.debug("CommentaireDaoImpl méthode deleteCommentaireBySpot(Integer id) id = "+id);
		// TODO Auto-generated method stub
		String vsql="DELETE FROM public.commentaire WHERE spot_id=?";
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		vJdbcTemplate.update(vsql,new Object[] { id });
		
	}

	@Override
	public List<Commentaire> listCommentaireBySpot(Integer id) {
		// TODO Auto-generated method stub
		String vsql = "SELECT * FROM public.commentaire WHERE spot_id=?";
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		CommentaireRM rowCommentaire = new CommentaireRM();
		
		List<Commentaire> listCommentaires = vJdbcTemplate.query(vsql,new Object[] { id },rowCommentaire);
		if(CollectionUtils.isEmpty(listCommentaires)) {
			return null;
		}
		return listCommentaires;
	}

	@Override
	public List<Commentaire> listCommentaireByTopo(Integer id) {
		// TODO Auto-generated method stub
		String vsql = "SELECT * FROM public.commentaire WHERE topo_id=?";
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		CommentaireRM rowCommentaire = new CommentaireRM();
		
		List<Commentaire> listCommentaires = vJdbcTemplate.query(vsql,new Object[] { id },rowCommentaire);
		if(CollectionUtils.isEmpty(listCommentaires)) {
			return null;
		}
		return listCommentaires;
	}

}
