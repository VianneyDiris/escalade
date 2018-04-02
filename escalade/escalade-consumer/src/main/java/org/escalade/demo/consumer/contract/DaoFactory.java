package org.escalade.demo.consumer.contract;

import org.escalade.demo.consumer.contract.dao.spot.*;
import org.escalade.demo.consumer.contract.dao.topo.*;

public interface DaoFactory {
	
	CotationDao    getCotationDao();
	OrientationDao getOrientationDao();
	PaysDao        getPaysDao();
	SecteurDao     getSecteurDao();
	SpotDao        getSpotDao();
	VilleDao       getVilleDao();
	VoieDao        getVoieDao();
	
	CommentaireDao getCommentaireDao();
	ReservationDao getReservationDao();
	RoleDao        getRoleDao();
	TopoDao        getTopoDao();
	UtilisateurDao getUtilisateurDao();

}
