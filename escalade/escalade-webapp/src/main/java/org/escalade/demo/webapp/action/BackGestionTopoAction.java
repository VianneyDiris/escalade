package org.escalade.demo.webapp.action;

import java.util.List;

import org.escalade.demo.business.contract.ManagerFactory;
import org.escalade.demo.model.bean.spot.Spot;
import org.escalade.demo.model.bean.topo.Topo;
import org.escalade.demo.model.exception.NotFoundException;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@SuppressWarnings("serial")
public class BackGestionTopoAction extends ActionSupport{
	static final Log logger = LogFactory.getLog(BackGestionTopoAction.class);
	
	// ==================== Attributs ====================
    // ----- Paramètres en entrée
	private ManagerFactory managerFactory;
	private Topo topo;
	private List<Topo> listTopos;
	private List<Spot> listSpots;
	private Integer id;
	
	// ----- Paramètres en sortie
	private String nom;
	private String description;
	private String prive;
	private String reserved;
	private String StringSpot;
	
	// ==================== Getters/Setters ====================
	public ManagerFactory getManagerFactory() {
		return managerFactory;
	}
	public void setManagerFactory(ManagerFactory managerFactory) {
		this.managerFactory = managerFactory;
	}
	public Topo getTopo() {
		return topo;
	}
	public void setTopo(Topo topo) {
		this.topo = topo;
	}
	public List<Topo> getListTopos() {
		return listTopos;
	}
	public void setListTopos(List<Topo> listTopos) {
		this.listTopos = listTopos;
	}
	public List<Spot> getListSpots() {
		return listSpots;
	}
	public void setListSpots(List<Spot> listSpots) {
		this.listSpots = listSpots;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getPrive() {
		return prive;
	}
	public void setPrive(String prive) {
		this.prive = prive;
	}
	public String getReserved() {
		return reserved;
	}
	public void setReserved(String reserved) {
		this.reserved = reserved;
	}
	public String getStringSpot() {
		return StringSpot;
	}
	public void setStringSpot(String stringSpot) {
		StringSpot = stringSpot;
	}
	// ==================== Méthodes ====================
	public String doListTopo() {
		logger.debug("BackGestionTopoAction méthode doListTopo()");
		listTopos=managerFactory.getTopoManager().getListTopo();
		return Action.SUCCESS;
	}
	
	public String doUpdateTopo() {
		logger.debug("BackGestionTopoAction méthode doUpdateTopo()");
		if(id==null) {
			this.addActionError("veuillez donner un identifiant de topo");			
		}
		else {
			try {
				topo=managerFactory.getTopoManager().getTopo(id);
				 if (!StringUtils.isAllEmpty(nom)){
					 topo.setNom(nom);					 
				 }
				 if (!StringUtils.isAllEmpty(description)){
					 topo.setDescription(description);					 
				 }
				topo.setPrive(Boolean.parseBoolean(prive));
				topo.setReserve(Boolean.parseBoolean(reserved));
				
				Spot spot=managerFactory.getSpotManager().getSpot(Integer.valueOf(StringSpot));
				topo.setSpot(spot);
				
				managerFactory.getTopoManager().updateTopo(topo);
				 
			} catch (NotFoundException e) {
				// TODO Auto-generated catch block
				logger.debug(e.getMessage());
			}
		}
		return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
	}

	public String doDeleteTopo() {
		logger.debug("BackGestionTopoAction méthode doDeleteTopo()");
		if(id==null) {
			this.addActionError("veuillez donner un identifiant de topo");			
		}
		else {
			try {
				managerFactory.getCommentaireManager().deleteCommentaireByTopo(id);
				managerFactory.getReservationManager().deleteReservationByTopo(id);
				managerFactory.getTopoManager().deleteTopo(id);
			}
			catch(NotFoundException pE) {
				logger.debug(pE.getMessage());
			}
		}
		return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
	}
	
	public String doDetailTopo() {
		logger.debug("BackGestionTopoAction méthode doDetailTopo()");
		if(id==null) {
			this.addActionError("veuillez donner un identifiant de topo");			
		}
		else {
			try {
				listSpots=managerFactory.getSpotManager().allSpot();
				topo=managerFactory.getTopoManager().getTopo(id);
			}
			catch(NotFoundException pE) {
				logger.debug(pE.getMessage());
			}
			
		}
		
		return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
	}
}
