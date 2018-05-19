package org.escalade.demo.webapp.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.escalade.demo.business.impl.ManagerFactoryImpl;
import org.escalade.demo.model.bean.spot.Secteur;
import org.escalade.demo.model.bean.spot.Spot;
import org.escalade.demo.model.bean.spot.Voie;
import org.escalade.demo.model.exception.NotFoundException;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@SuppressWarnings("serial")
public class BackGestionSpotAction extends ActionSupport {
	static final Log logger = LogFactory.getLog(BackGestionSpotAction.class);
	// ==================== Attributs ====================
		// ----- Paramètres en entrée
		private ManagerFactoryImpl managerFactory;
		private Integer id;

		// ----- Eléments en sortie
		private List<Spot> listSpots;
		private Spot spot;

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
					
					
					managerFactory.getSpotManager().deleteSpot(id);
				}
				catch(NotFoundException pE) {
					logger.debug(pE.getMessage());
				}
			}
			
			return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
		}
		
		public void doUpdateSpot() {
			
		}
		
}
