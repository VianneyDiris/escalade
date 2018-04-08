package org.escalade.demo.business.impl;

import org.escalade.demo.business.contract.ManagerFactory;
import org.escalade.demo.business.contract.manager.spot.*;
import org.escalade.demo.business.contract.manager.topo.*;


public class ManagerFactoryImpl implements ManagerFactory {

	//TopoManager
	private TopoManager topoManager;
	public TopoManager getTopoManageur() {
		// TODO Auto-generated method stub
		return this.topoManager;
	}
	public void setTopoManager(TopoManager topoManager) {
		this.topoManager=topoManager;
	}
	
	
	//CommentaireManager
	private CommentaireManager commentaireManager;
	public CommentaireManager getCommentaireManageur() {
		// TODO Auto-generated method stub
		return this.commentaireManager;
	}
	public void setCommentaireManager(CommentaireManager commentaireManager) {
		this.commentaireManager=commentaireManager;
	}

	
	//ReservationManager
	private ReservationManager reservationManager;
	public ReservationManager getReservationManager() {
		// TODO Auto-generated method stub
		return this.reservationManager;
	}
	public void setReservationManager(ReservationManager reservationManager) {
		this.reservationManager=reservationManager;
	}

	
	//RoleManager
	private RoleManager roleManager;
	public RoleManager getRoleManageur() {
		// TODO Auto-generated method stub
		return this.roleManager;
	}
	public void setRoleManager(RoleManager roleManager) {
		this.roleManager=roleManager;
	}

	
	//UtilisateurManager
	private UtilisateurManager utilisateurManager;
	public UtilisateurManager getUtilisateurManageur() {
		// TODO Auto-generated method stub
		return this.utilisateurManager;
	}
	public void setUtilisateurManager(UtilisateurManager utilisateurManager) {
		this.utilisateurManager=utilisateurManager;
	}

	
	//SpotManager
	private SpotManager spotManager;
	public SpotManager getSpotManager() {
		// TODO Auto-generated method stub
		return this.spotManager;
	}
	public void setSpotManager(SpotManager spotManager) {
		this.spotManager=spotManager;
	}

	
	//CotationManager
	private CotationManager cotationManager;
	public CotationManager getCotationManageur() {
		// TODO Auto-generated method stub
		return this.cotationManager;
	}
	public void setCotationManager(CotationManager cotationManager) {
		this.cotationManager=cotationManager;
	}

	
	//OrientationManager
	private OrientationManager orientationManager;
	public OrientationManager getOrientationManageur() {
		// TODO Auto-generated method stub
		return this.orientationManager;
	}
	public void setOrientationManeger(OrientationManager orientationManager) {
		this.orientationManager=orientationManager;
	}

	
	//PaysManager
	private PaysManager paysManager;
	public PaysManager getPaysManageur() {
		// TODO Auto-generated method stub
		return this.paysManager;
	}
	public void setPaysManager(PaysManager paysManager) {
		this.paysManager=paysManager;
	}

	
	//SecteurManager
	private SecteurManager secteurManager;
	public SecteurManager getSecteurManageur() {
		// TODO Auto-generated method stub
		return this.secteurManager;
	}
	public void setSecteurManager(SecteurManager secteurManager) {
		this.secteurManager=secteurManager;
	}

	
	//VilleManager
	private VilleManager villeManager;
	public VilleManager getVilleManageur() {
		// TODO Auto-generated method stub
		return this.villeManager;
	}
	public void setVilleManager(VilleManager villeManager) {
		this.villeManager=villeManager;
	}

	
	//VoieManageur
	private VoieManager voieManager;
	public VoieManager getVoieManageur() {
		// TODO Auto-generated method stub
		return this.voieManager;
	}
	public void setVoieManager(VoieManager voieManager) {
		this.voieManager=voieManager;
	}

}
