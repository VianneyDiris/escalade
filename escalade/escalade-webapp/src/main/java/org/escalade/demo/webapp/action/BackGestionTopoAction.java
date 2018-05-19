package org.escalade.demo.webapp.action;

import java.util.List;

import org.escalade.demo.business.contract.ManagerFactory;
import org.escalade.demo.model.bean.topo.Topo;
import org.escalade.demo.model.exception.NotFoundException;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
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
	private Integer id;
	
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	// ==================== Méthodes ====================
	public String doListTopo() {
		logger.debug("BackGestionTopoAction méthode doListTopo()");
		listTopos=managerFactory.getTopoManager().getListTopo();
		return Action.SUCCESS;
	}
	
	public String doUpdateTopo() {
		logger.debug("BackGestionTopoAction méthode doUpdateTopo()");
		return Action.SUCCESS;
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
}
