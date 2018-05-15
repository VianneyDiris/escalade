package org.escalade.demo.webapp.action;

import java.util.List;

import org.escalade.demo.business.contract.ManagerFactory;
import org.escalade.demo.model.bean.topo.Utilisateur;
import org.escalade.demo.model.exception.NotFoundException;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class BackGestionUserAction extends ActionSupport{
	// ==================== Attributs ====================
    // ----- Paramètres en entrée
	private ManagerFactory managerFactory;
	private Utilisateur user;
	private List<Utilisateur> listUsers;
	private Integer id;
	
	// ==================== Getters/Setters ====================
	public ManagerFactory getManagerFactory() {
		return managerFactory;
	}
	public void setManagerFactory(ManagerFactory managerFactory) {
		this.managerFactory = managerFactory;
	}
	public Utilisateur getUser() {
		return user;
	}
	public void setUser(Utilisateur user) {
		this.user = user;
	}
	public List<Utilisateur> getListUsers() {
		return listUsers;
	}
	public void setListUsers(List<Utilisateur> listUsers) {
		this.listUsers = listUsers;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	// ==================== Méthodes ====================
	public String doListUtilisateur() {
		listUsers=managerFactory.getUtilisateurManager().getListUtilisateur();
		return Action.SUCCESS;
	}
	
	public String doUpdateUtilisateur() {
		return Action.SUCCESS;
	}
	
	public String doDeleteUtilisateur() {
		System.out.println(id);
		if (id == null) {
			this.addActionError("Vous devez indiquer un id de utilisateur");
		} else {
			try {
				user=managerFactory.getUtilisateurManager().getUtilisateur(id);
				System.out.println("méthode doDeleteUtilisateur: "+user.getId()+" "+user.getPseudo());
				managerFactory.getUtilisateurManager().deleteUtilisateur(user);
				
			} catch (NotFoundException pE) {
				this.addActionError("Spot non trouvé. ID = " + id);
			}
		}
		return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
	
	}

}
