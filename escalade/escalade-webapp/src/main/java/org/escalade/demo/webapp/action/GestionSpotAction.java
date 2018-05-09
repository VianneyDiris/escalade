package org.escalade.demo.webapp.action;

import java.util.List;

import org.escalade.demo.business.impl.ManagerFactoryImpl;
import org.escalade.demo.model.bean.spot.Spot;
import org.escalade.demo.model.bean.topo.Commentaire;
import org.escalade.demo.model.exception.NotFoundException;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class GestionSpotAction extends ActionSupport {

	// ==================== Attributs ====================
	// ----- Paramètres en entrée
	private ManagerFactoryImpl managerFactory;
	private Integer id;


	// ----- Eléments en sortie
	private List<Spot> listSpots;
	private Spot spot;
	private Commentaire commentaire;


	// ==================== Getters/Setters ====================
	public ManagerFactoryImpl getManagerFactory() {
		return managerFactory;
	}
	public void setManagerFactory(ManagerFactoryImpl managerFactory) {
		this.managerFactory = managerFactory;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<Spot> getListSpots() {
		return listSpots;
	}
	public void setListSpots(List<Spot> listSpots) {
		this.listSpots = listSpots;
	}
	public Spot getSpot() {
		return spot;
	}
	public void setSpot(Spot spot) {
		this.spot = spot;
	}
	public Commentaire getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(Commentaire commentaire) {
		this.commentaire = commentaire;
	}
	// ==================== Méthodes ====================
	public String doListSpot() {
		listSpots=managerFactory.getSpotManager().getListSpot();
		return Action.SUCCESS;
	}

	public String doDetailSpot() {
		System.out.println(id);
		if (id == null) {
			this.addActionError("Vous devez indiquer un id de Spot");
		} else {
			try {
				spot = managerFactory.getSpotManager().getSpot(id);
				
			} catch (NotFoundException pE) {
				this.addActionError("Spot non trouvé. ID = " + id);
			}
		}
		try {
			commentaire=managerFactory.getCommentaireManager().findCommentbySpotId(id);
		} catch(NotFoundException pE) {
			
			System.out.println(pE.getMessage());
		}
		return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
	}


}
