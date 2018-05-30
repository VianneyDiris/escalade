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
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@SuppressWarnings("serial")
public class GestionSearchAction extends ActionSupport {
	static final Log logger = LogFactory.getLog(GestionSearchAction.class);
	// ==================== Attributs ====================
	// ----- Paramètres en entrée
	private ManagerFactoryImpl managerFactory;
	private Integer id;
	private List<Spot> listSpot;
	private List<Pays> listPays;
	private List<Ville> listVilles;
	private List<Secteur> listSecteur;
	private List<Voie> listVoies;
	private String StringSpot;
	private String StringPays;
	private String StringVille;
	private String StringSecteur;
	private String StringVoie;
	private Boolean bool;
	
	// ----- Paramètres en sortie
	private List<Topo> listTopo;
	private List<Spot> listResultSpot;
	
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
	public String getStringSpot() {
		return StringSpot;
	}
	public void setStringSpot(String stringSpot) {
		StringSpot = stringSpot;
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
	public List<Topo> getListTopo() {
		return listTopo;
	}
	public void setListTopo(List<Topo> listTopo) {
		this.listTopo = listTopo;
	}
	public String getStringSecteur() {
		return StringSecteur;
	}
	public void setStringSecteur(String stringSecteur) {
		StringSecteur = stringSecteur;
	}
	public String getStringVoie() {
		return StringVoie;
	}
	public void setStringVoie(String stringVoie) {
		StringVoie = stringVoie;
	}
	public List<Spot> getListResultSpot() {
		return listResultSpot;
	}
	public void setListResultSpot(List<Spot> listResultSpot) {
		this.listResultSpot = listResultSpot;
	}
	public Boolean getBool() {
		return bool;
	}
	public void setBool(Boolean bool) {
		this.bool = bool;
	}
	// ==================== Méthodes ====================
	public String doListSearch() {
		logger.debug("GestionSearchAction méthode doListSearch()");
				
		listSpot=managerFactory.getSpotManager().getListSpot();
		listPays=managerFactory.getPaysManager().getListPays();
		listVilles=managerFactory.getVilleManager().getListVille();
		listSecteur=managerFactory.getSecteurManager().getListSecteur();
		listVoies=managerFactory.getVoieManager().getListVoie();
		return Action.SUCCESS;
	}
	
	public String doSearchTopo() {
		logger.debug("GestionSearchAction méthode doSearchTopo()");
		
		bool=true;
		
		if(StringSpot.equals(null) && StringPays.equals(null) && StringVille.equals(null)) {
			this.addActionError("Veuillez sélectionner un spot ou pays ou une ville");
		}
		
		if(!StringSpot.equals(null) && !StringSpot.equals("")) {
			try {
				Spot spot = managerFactory.getSpotManager().getSpot(Integer.valueOf(StringSpot));
				listTopo=managerFactory.getTopoManager().listTopoBySpot(spot);
			} catch (NotFoundException e) {
				// TODO Auto-generated catch block
				logger.debug(e.getMessage());
			}
		}
		
		if(!StringPays.equals(null) && !StringPays.equals("")) {
			try {
				Pays pays = managerFactory.getPaysManager().getPays(Integer.valueOf(StringPays));
				List<Spot> listTempSpot= managerFactory.getSpotManager().listSpotByPays(pays);
				
				Iterator<Spot> it = listTempSpot.iterator();
				while(it.hasNext()) {
					Spot spot = it.next();
					List<Topo> listTempTopo=managerFactory.getTopoManager().listTopoBySpot(spot);
					
					Iterator<Topo> itTopo = listTempTopo.iterator();
					while(itTopo.hasNext()) {
						Topo topo = itTopo.next();
						listTopo = new ArrayList<Topo>();
						listTopo.add(topo);
					}
				}
				
			} catch (NotFoundException e) {
				// TODO Auto-generated catch block
				logger.debug(e.getMessage());
			} 
		}
		
		if(!StringVille.equals(null) && !StringVille.equals("")) {
			try {
				Ville ville = managerFactory.getVilleManager().getVille(Integer.valueOf(StringVille));
				List<Spot> listTempSpot = managerFactory.getSpotManager().listSpotByVille(ville);
				
				Iterator<Spot> it = listTempSpot.iterator();
				while(it.hasNext()) {
					Spot spot = it.next();
					List<Topo> listTempTopo=managerFactory.getTopoManager().listTopoBySpot(spot);
					
					Iterator<Topo> itTopo = listTempTopo.iterator();
					while(itTopo.hasNext()) {
						Topo topo = itTopo.next();
						listTopo = new ArrayList<Topo>();
						listTopo.add(topo);
					}
				}
				
			} catch (NotFoundException e) {
				// TODO Auto-generated catch block
				logger.debug(e.getMessage());
			} 
		}
		

		
		return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
	}
	
	public String doSearchSpot() {
		logger.debug("GestionSearchAction méthode doSearchSpot()");
		
		bool=false;
		
		if(StringPays.equals(null) && StringVille.equals(null) && StringSecteur.equals(null) && StringVoie.equals(null)) {
			this.addActionError("Veuillez sélectionner un pays,une ville,un secteur ou une voie");
		}
		
		if(!StringPays.equals(null) && !StringPays.equals("")) {
			try {
				Pays pays = managerFactory.getPaysManager().getPays(Integer.valueOf(StringPays));
				listResultSpot=managerFactory.getSpotManager().listSpotByPays(pays);
			} catch (NotFoundException e) {
				// TODO Auto-generated catch block
				logger.debug(e.getMessage());
			}
		}
		
		if(!StringVille.equals(null) && !StringVille.equals("")) {
			try {
				Ville ville =managerFactory.getVilleManager().getVille(Integer.valueOf(StringVille));
				listResultSpot=managerFactory.getSpotManager().listSpotByVille(ville);
			} catch (NotFoundException e) {
				// TODO Auto-generated catch block
				logger.debug(e.getMessage());
			}
		}
		
		if(!StringSecteur.equals(null) && !StringSecteur.equals("")) {
			try {
				Secteur secteur = managerFactory.getSecteurManager().getSecteur(Integer.valueOf(StringSecteur));
				listResultSpot= new ArrayList<Spot>();
				listResultSpot.add(secteur.getSpot());
			} catch (NotFoundException e) {
				// TODO Auto-generated catch block
				logger.debug(e.getMessage());
			}
		}
		
		if(!StringVoie.equals(null) && !StringVoie.equals("")) {
			try {
				Voie voie = managerFactory.getVoieManager().getVoie(Integer.valueOf(StringVoie));
				listResultSpot= new ArrayList<Spot>();
				listResultSpot.add(voie.getSecteur().getSpot());
			} catch (NotFoundException e) {
				// TODO Auto-generated catch block
				logger.debug(e.getMessage());
			}
		}
		
		
		return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
	}


}
