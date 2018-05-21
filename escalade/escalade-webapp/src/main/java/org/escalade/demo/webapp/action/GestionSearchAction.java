package org.escalade.demo.webapp.action;

import java.util.List;

import org.escalade.demo.business.impl.ManagerFactoryImpl;
import org.escalade.demo.model.bean.spot.Pays;
import org.escalade.demo.model.bean.spot.Secteur;
import org.escalade.demo.model.bean.spot.Spot;
import org.escalade.demo.model.bean.spot.Ville;
import org.escalade.demo.model.bean.spot.Voie;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class GestionSearchAction extends ActionSupport {
	// ==================== Attributs ====================
	// ----- Paramètres en entrée
	private ManagerFactoryImpl managerFactory;
	private Integer id;
	private List<Spot> listSpot;
	private List<Pays> listPays;
	private List<Ville> listVilles;
	private List<Secteur> listSecteur;
	private List<Voie> listVoies;
	
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
	public List<Spot> getListSpot() {
		return listSpot;
	}
	public void setListSpot(List<Spot> listSpot) {
		this.listSpot = listSpot;
	}
	public List<Pays> getListPays() {
		return listPays;
	}
	public void setListPays(List<Pays> listPays) {
		this.listPays = listPays;
	}
	public List<Ville> getListVilles() {
		return listVilles;
	}
	public void setListVilles(List<Ville> listVilles) {
		this.listVilles = listVilles;
	}
	public List<Secteur> getListSecteur() {
		return listSecteur;
	}
	public void setListSecteur(List<Secteur> listSecteur) {
		this.listSecteur = listSecteur;
	}
	public List<Voie> getListVoies() {
		return listVoies;
	}
	public void setListVoies(List<Voie> listVoies) {
		this.listVoies = listVoies;
	}
	// ==================== Méthodes ====================
	public String doListSearch() {
		listSpot=managerFactory.getSpotManager().getListSpot();
		listPays=managerFactory.getPaysManager().getListPays();
		listVilles=managerFactory.getVilleManager().getListVille();
		listSecteur=managerFactory.getSecteurManager().getListSecteur();
		listVoies=managerFactory.getVoieManager().getListVoie();
		return Action.SUCCESS;
	}


}
