package org.escalade.demo.webapp.action;

import java.util.List;

import org.escalade.demo.business.impl.ManagerFactoryImpl;
import org.escalade.demo.model.bean.topo.Topo;
import org.escalade.demo.model.exception.NotFoundException;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class GestionTopoAction extends ActionSupport {
	
	// ==================== Attributs ====================
    // ----- Paramètres en entrée
	private ManagerFactoryImpl managerFactory;
	private Integer id;
	
	// ----- Eléments en sortie
	private List<Topo> listTopos;
	private Topo topo;

	
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
	
	// ==================== Méthodes ====================
	public String doListTopo() {
		listTopos=managerFactory.getTopoManager().getListTopo();
		return Action.SUCCESS;
	}

	public String doDetailTopo() {
		if (id == null) {
            this.addActionError("Vous devez indiquer un id de Topo");
        } else {
            try {
                topo=managerFactory.getTopoManager().getTopo(id);
                System.out.println(topo.getNom()+" "+topo.getSpot().getPays().getNom()+" "+topo.getDescription());
            } catch (NotFoundException pE) {
                this.addActionError("topo non trouvé. ID = " + id);
            }
        }
        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
	}
}
