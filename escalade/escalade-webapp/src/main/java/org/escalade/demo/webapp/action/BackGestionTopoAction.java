package org.escalade.demo.webapp.action;

import java.util.List;

import org.escalade.demo.business.contract.ManagerFactory;
import org.escalade.demo.model.bean.topo.Topo;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class BackGestionTopoAction extends ActionSupport{
	// ==================== Attributs ====================
    // ----- Paramètres en entrée
	private ManagerFactory managerFactory;
	private Topo topo;
	private List<Topo> listTopos;
	
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
	
	// ==================== Méthodes ====================
	public String doListTopo() {
		listTopos=managerFactory.getTopoManager().getListTopo();
		return Action.SUCCESS;
	}
	
	public String doUpdateTopo() {
		return Action.SUCCESS;
	}

	public String doDeleteTopo() {
		return Action.SUCCESS;
	}
}
