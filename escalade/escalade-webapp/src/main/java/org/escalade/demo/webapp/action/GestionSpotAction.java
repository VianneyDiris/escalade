package org.escalade.demo.webapp.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.escalade.demo.business.impl.ManagerFactoryImpl;
import org.escalade.demo.model.bean.spot.Secteur;
import org.escalade.demo.model.bean.spot.Spot;
import org.escalade.demo.model.bean.spot.Voie;
import org.escalade.demo.model.bean.topo.Commentaire;
import org.escalade.demo.model.exception.NotFoundException;
import org.springframework.util.CollectionUtils;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@SuppressWarnings("serial")
public class GestionSpotAction extends ActionSupport {
	static final Log logger = LogFactory.getLog(GestionSpotAction.class);

	// ==================== Attributs ====================
	// ----- Paramètres en entrée
	private ManagerFactoryImpl managerFactory;
	private Integer id;


	// ----- Eléments en sortie
	private List<Spot> listSpots;
	private Spot spot;
	private List<Commentaire> commentaire;
	private List<Secteur> listSecteurs;
	private List<Voie> listVoies =new ArrayList<Voie>();

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
	public List<Commentaire> getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(List<Commentaire> commentaire) {
		this.commentaire = commentaire;
	}
	public List<Secteur> getListSecteurs() {
		return listSecteurs;
	}
	public void setListSecteurs(List<Secteur> listSecteurs) {
		this.listSecteurs = listSecteurs;
	}
	public List<Voie> getListVoies() {
		return listVoies;
	}
	public void setListVoies(List<Voie> listVoies) {
		this.listVoies = listVoies;
	}
	
	// ==================== Méthodes ====================
	public String doListSpot() {
		logger.debug("GestionSpotAction méthode doListSpot()");
		
		listSpots=managerFactory.getSpotManager().getListSpot();
		return Action.SUCCESS;
	}

	public String doDetailSpot() {
		logger.debug("GestionSpotAction méthode doDetailSpot()");
		
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
			commentaire=managerFactory.getCommentaireManager().getListCommentaireBySpot(id);
		} catch(NotFoundException pE) {
			
			logger.debug(pE.getMessage());
		}
		try {
			listSecteurs=managerFactory.getSecteurManager().listSecteurBySpot(id);
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		if(!CollectionUtils.isEmpty(listSecteurs)) {
			Iterator<Secteur> it = listSecteurs.iterator();
			while(it.hasNext()) {
				Secteur secteur = it.next();
				
				try {
					List<Voie> temp = managerFactory.getVoieManager().listVoieBySecteur(secteur);
					logger.info(temp);
					Iterator<Voie> its = temp.iterator();
					while(its.hasNext()) {
						Voie voie = its.next();
						listVoies.add(voie);
					}
				} catch (NotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
	}


}
