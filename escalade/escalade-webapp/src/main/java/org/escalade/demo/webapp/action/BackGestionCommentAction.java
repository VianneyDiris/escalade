package org.escalade.demo.webapp.action;

import java.util.List;

import org.escalade.demo.business.contract.ManagerFactory;
import org.escalade.demo.model.bean.topo.Commentaire;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class BackGestionCommentAction extends ActionSupport  {

	// ==================== Attributs ====================
    // ----- Paramètres en entrée
	 private ManagerFactory managerFactory;
	 private Commentaire commentaire;
	 private List<Commentaire> listCommentaires;
	 
	// ==================== Getters/Setters ====================
	public ManagerFactory getManagerFactory() {
		return managerFactory;
	}
	public void setManagerFactory(ManagerFactory managerFactory) {
		this.managerFactory = managerFactory;
	}
	public Commentaire getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(Commentaire commentaire) {
		this.commentaire = commentaire;
	}
	public List<Commentaire> getListCommentaires() {
		return listCommentaires;
	}
	public void setListCommentaires(List<Commentaire> listCommentaires) {
		this.listCommentaires = listCommentaires;
	}	 
	
	// ==================== Méthodes ====================
	public String doListComment(){
		listCommentaires=managerFactory.getCommentaireManager().getListCommentaire();
		return Action.SUCCESS;
	}
	
	public String doUpdateComment() {
		return Action.SUCCESS;
	}
	
	public String doDeleteComment() {
		return Action.SUCCESS;
	}

}
