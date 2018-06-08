package org.escalade.demo.webapp.action;

import java.util.List;

import org.escalade.demo.business.impl.ManagerFactoryImpl;
import org.escalade.demo.model.bean.topo.Commentaire;
import org.escalade.demo.model.bean.topo.Topo;
import org.escalade.demo.model.exception.NotFoundException;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@SuppressWarnings("serial")
public class GestionTopoAction extends ActionSupport {
	static final Log logger = LogFactory.getLog(GestionTopoAction.class);
	
	// ==================== Attributs ====================
    // ----- Paramètres en entrée
	private ManagerFactoryImpl managerFactory;
	private Integer id;
	
	// ----- Eléments en sortie
	private List<Topo> listTopos;
	private Topo topo;
	private List<Commentaire> commentaire;

	
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
	public List<Topo> getListTopos() {
		return listTopos;
	}
	public void setListSpots(List<Topo> listTopos) {
		this.listTopos = listTopos;
	}
	public Topo getTopo() {
		return topo;
	}
	public void setTopo(Topo topo) {
		this.topo = topo;
	}
	public List<Commentaire> getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(List<Commentaire> commentaire) {
		this.commentaire = commentaire;
	}
	
	// ==================== Méthodes ====================
	public String doListTopo() {
		logger.debug("GestionTopoAction méthode doListTopo()");
		
		listTopos=managerFactory.getTopoManager().getListTopo();
		return Action.SUCCESS;
	}

	public String doDetailTopo() {
		logger.debug("GestionTopoAction méthode doDetailTopo()");
		
		if (id == null) {
            this.addActionError("Vous devez indiquer un id de Topo");
        } else {
            try {
                topo=managerFactory.getTopoManager().getTopo(id);
            } catch (NotFoundException pE) {
                this.addActionError("topo non trouvé. ID = " + id);
            }
            
            try {
    			commentaire=managerFactory.getCommentaireManager().getListCommentaireByTopo(id);
    		} catch(NotFoundException pE) {
    			
    			logger.debug(pE.getMessage());
    		}
        }
        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
	}
}
