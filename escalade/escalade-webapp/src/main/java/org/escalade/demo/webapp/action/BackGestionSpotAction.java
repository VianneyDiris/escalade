package org.escalade.demo.webapp.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.escalade.demo.business.impl.ManagerFactoryImpl;
import org.escalade.demo.model.bean.spot.Pays;
import org.escalade.demo.model.bean.spot.Secteur;
import org.escalade.demo.model.bean.spot.Spot;
import org.escalade.demo.model.bean.spot.Ville;
import org.escalade.demo.model.bean.spot.Voie;
import org.escalade.demo.model.bean.topo.Topo;
import org.escalade.demo.model.exception.NotFoundException;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@SuppressWarnings("serial")
public class BackGestionSpotAction extends ActionSupport {
	static final Log logger = LogFactory.getLog(BackGestionSpotAction.class);
	// ==================== Attributs ====================
	// ----- Paramètres en entrée
	private ManagerFactoryImpl managerFactory;
	private Integer id;
	private List<Spot> listSpots;
	private Spot spot;
	private List<Ville> listVille;
	private List<Pays> listPays;

	// ----- Eléments en sortie
	private String nom;
	private String description;
	private String StringPays;
	private String StringVille;

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
	public List<Ville> getListVille() {
		return listVille;
	}
	public void setListVille(List<Ville> listVille) {
		this.listVille = listVille;
	}
	public List<Pays> getListPays() {
		return listPays;
	}
	public void setListPays(List<Pays> listPays) {
		this.listPays = listPays;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStringPays() {
		return StringPays;
	}
	public void setStringPays(String stringPays) {
		StringPays = stringPays;
	}
	public String getStringVille() {
		return StringVille;
	}
	public void setStringVille(String stringVille) {
		StringVille = stringVille;
	}
	
	// ==================== Méthodes ====================
	public String doListSpot() {
		logger.debug("BackGestionSpotAction méthode doListSpot()");
		listSpots=managerFactory.getSpotManager().getListSpot();
		return Action.SUCCESS;
	}
		
	public String doDeleteSpot() {
		logger.debug("BackGestionSpotAction méthode doDeleteSpot()");
		if(id==null) {
			this.addActionError("veuillez donner un identifiant de spot");			
		}
		else {
			try {
				managerFactory.getCommentaireManager().deleteCommentaireBySpot(id);
				
					List<Secteur> listSecteurs =managerFactory.getSecteurManager().listSecteurBySpot(id);
					List<Voie> listVoie = new ArrayList<Voie>();
					Iterator<Secteur> it = listSecteurs.iterator();
					
					while(it.hasNext()) {
						Secteur secteur=it.next();
						List<Voie> temp;
						temp = managerFactory.getVoieManager().listVoieBySecteur(secteur);
						Iterator<Voie> tempVoie = temp.iterator();
							while(tempVoie.hasNext()) {
								Voie voie= tempVoie.next();
								listVoie.add(voie);								
							}
					}
					
					Iterator<Voie> itVoie = listVoie.iterator();
					while(itVoie.hasNext()) {
						Voie voie = itVoie.next();
						System.out.println(voie.getNom());
						managerFactory.getVoieManager().deleteVoie(voie);						
					}
					
					Iterator<Secteur> itSecteur = listSecteurs.iterator();
					while(itSecteur.hasNext()) {
						Secteur secteur = itSecteur.next();
						managerFactory.getSecteurManager().deleteSecteur(secteur);
					}
					Spot spot = managerFactory.getSpotManager().getSpot(id);
					Topo topo = managerFactory.getTopoManager().getTopoBySpot(spot);
					
					managerFactory.getCommentaireManager().deleteCommentaireByTopo(topo.getId());
					managerFactory.getReservationManager().deleteReservationByTopo(topo.getId());
					managerFactory.getTopoManager().deleteTopo(topo.getId());
					
					managerFactory.getSpotManager().deleteSpot(id);
				}
				catch(NotFoundException pE) {
					logger.debug(pE.getMessage());
				}
			}
			
		return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
	}
		
	public String doUpdateSpot() {
		logger.debug("BackGestionSpotAction méthode doDetailSpot()");
		if(id==null) {
			this.addActionError("veuillez donner un identifiant de spot");			
		}
		else {
			try {
				spot=managerFactory.getSpotManager().getSpot(id);
				 if (!StringUtils.isAllEmpty(nom)){
					 spot.setNom(nom);					 
				 }
				 if (!StringUtils.isAllEmpty(description)){
					 spot.setDescription(description);					 
				 }
				 Pays pays=managerFactory.getPaysManager().getPays(Integer.valueOf(StringPays));
				 Ville ville=managerFactory.getVilleManager().getVille(Integer.valueOf(StringVille));
				 System.out.println(pays.getNom()+" "+ville.getNom());
				 
				 if(ville.getId()==1 && pays.getId()!=1) {
					 spot.setPays(pays);
					 spot.setVille(ville);
				 }
				 else {
					 spot.setPays(ville.getPays());
					 spot.setVille(ville);
				 }
				 managerFactory.getSpotManager().updateSpot(spot);
				
			} catch (NotFoundException e) {
				// TODO Auto-generated catch block
				logger.debug(e.getMessage());
			}
		}
		return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
		}
	
	public String doDetailSpot(){
		logger.debug("BackGestionSpotAction méthode doDetailSpot()");
		if(id==null) {
			this.addActionError("veuillez donner un identifiant de spot");			
		}
		else {
			try {
				spot=managerFactory.getSpotManager().getSpot(id);
				listPays=managerFactory.getPaysManager().allPays();
				listVille=managerFactory.getVilleManager().allVille();
			}
			catch(NotFoundException pE) {
				logger.debug(pE.getMessage());
			}
			
		}
		
		return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
	}
}
