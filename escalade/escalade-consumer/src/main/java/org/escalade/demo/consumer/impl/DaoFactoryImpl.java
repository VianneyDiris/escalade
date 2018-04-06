package org.escalade.demo.consumer.impl;

import org.escalade.demo.consumer.contract.DaoFactory;
import org.escalade.demo.consumer.contract.dao.spot.CotationDao;
import org.escalade.demo.consumer.contract.dao.spot.OrientationDao;
import org.escalade.demo.consumer.contract.dao.spot.PaysDao;
import org.escalade.demo.consumer.contract.dao.spot.SecteurDao;
import org.escalade.demo.consumer.contract.dao.spot.SpotDao;
import org.escalade.demo.consumer.contract.dao.spot.VilleDao;
import org.escalade.demo.consumer.contract.dao.spot.VoieDao;
import org.escalade.demo.consumer.contract.dao.topo.CommentaireDao;
import org.escalade.demo.consumer.contract.dao.topo.ReservationDao;
import org.escalade.demo.consumer.contract.dao.topo.RoleDao;
import org.escalade.demo.consumer.contract.dao.topo.TopoDao;
import org.escalade.demo.consumer.contract.dao.topo.UtilisateurDao;

public class DaoFactoryImpl implements DaoFactory {

	//CotationDao
	private CotationDao cotationDao;
	public CotationDao getCotationDao() {
		// TODO Auto-generated method stub
		return cotationDao;
	}
	public void setCotationDao(CotationDao cotationDao) {
		this.cotationDao=cotationDao;
	}

	
	//OrientationDao
	private OrientationDao orientationDao;
	public OrientationDao getOrientationDao() {
		// TODO Auto-generated method stub
		return orientationDao;
	}
	public void setOrientationDao(OrientationDao orientationDao) {
		this.orientationDao=orientationDao;
	}

	
	//PaysDao
	private PaysDao paysDao;
	public PaysDao getPaysDao() {
		// TODO Auto-generated method stub
		return paysDao;
	}
	public void setPaysDao(PaysDao paysDao) {
		this.paysDao=paysDao;
	}
	
	
	//SecteurDao
	private SecteurDao secteurDao;
	public SecteurDao getSecteurDao() {
		// TODO Auto-generated method stub
		return secteurDao;
	}
	public void setSecteurDao(SecteurDao secteurDao) {
		this.secteurDao=secteurDao;
	}
	
	
	//SpotDao
	private SpotDao spotDao;
	public SpotDao getSpotDao() {
		// TODO Auto-generated method stub
		return spotDao;
	}
	public void setSpotDao(SpotDao spotDao) {
		this.spotDao=spotDao;
	}

	
	//VilleDao
	private VilleDao villeDao;
	public VilleDao getVilleDao() {
		// TODO Auto-generated method stub
		return villeDao;
	}
	public void setVilleDao(VilleDao villeDao) {
		this.villeDao=villeDao;
	}

	
	//VoieDao
	private VoieDao voieDao;
	public VoieDao getVoieDao() {
	// TODO Auto-generated method stub
		return voieDao;
	}
	public void setVoieDao(VoieDao voieDao) {
		this.voieDao=voieDao;
	}
	
	
	//CommentaireDao
	private CommentaireDao commentaireDao;
	public CommentaireDao getCommentaireDao() {
		// TODO Auto-generated method stub
		return commentaireDao;
	}
	public void setCommentaireDao(CommentaireDao commentaireDao) {
		this.commentaireDao=commentaireDao;
	}

	
	
	//ReservationDao
	private ReservationDao reservationDao;
	public ReservationDao getReservationDao() {
		// TODO Auto-generated method stub
		return reservationDao;
	}
	public void setReservationDao(ReservationDao reservationDao) {
		this.reservationDao=reservationDao;
	}

	
	//RoleDao
	private RoleDao roleDao;
	public RoleDao getRoleDao() {
		// TODO Auto-generated method stub
		return roleDao;
	}
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao=roleDao;
	}
	
	
	//TopoDao
	private TopoDao topoDao;
	public TopoDao getTopoDao() {
		// TODO Auto-generated method stub
		return topoDao;
	}
	public void setTopoDao(TopoDao topoDao) {
		this.topoDao=topoDao;
	}

	
	//UtilisateurDao
	private UtilisateurDao utilisateurDao;
	public UtilisateurDao getUtilisateurDao() {
		// TODO Auto-generated method stub
		return utilisateurDao;
	}
	public void setUtilisateurDao(UtilisateurDao utilisateurDao) {
		this.utilisateurDao=utilisateurDao;
	}

}
