package org.escalade.demo.business.contract;

import org.escalade.demo.business.contract.manager.spot.*;
import org.escalade.demo.business.contract.manager.topo.*;


public interface ManagerFactory {
	
	TopoManager        getTopoManager();
	CommentaireManager getCommentaireManager();
	ReservationManager getReservationManager();
	RoleManager        getRoleManager();
	UtilisateurManager getUtilisateurManager();
	
	SpotManager        getSpotManager();
	CotationManager    getCotationManager();
	OrientationManager getOrientationManager();
	PaysManager        getPaysManager();
	SecteurManager     getSecteurManager();
	VilleManager       getVilleManager();
	VoieManager        getVoieManager();

}
