package org.escalade.demo.business.contract;

import org.escalade.demo.business.contract.manager.spot.*;
import org.escalade.demo.business.contract.manager.topo.*;


public interface ManagerFactory {
	
	TopoManager        getTopoManageur();
	CommentaireManager getCommentaireManageur();
	ReservationManager getReservationManager();
	RoleManager        getRoleManageur();
	UtilisateurManager getUtilisateurManageur();
	
	SpotManager        getSpotManager();
	CotationManager    getCotationManageur();
	OrientationManager getOrientationManageur();
	PaysManager        getPaysManageur();
	SecteurManager     getSecteurManageur();
	VilleManager       getVilleManageur();
	VoieManager        getVoieManageur();

}
