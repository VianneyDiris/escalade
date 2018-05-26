package org.escalade.demo.webapp.action;

import java.util.List;

import org.escalade.demo.business.contract.ManagerFactory;
import org.escalade.demo.model.bean.topo.Commentaire;
import org.escalade.demo.model.exception.NotFoundException;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@SuppressWarnings("serial")
public class BackGestionCommentAction extends ActionSupport  {
	static final Log logger = LogFactory.getLog(BackGestionCommentAction.class);

	// ==================== Attributs ====================
    // ----- Paramètres en entrée
	 private ManagerFactory managerFactory;
	 private Commentaire commentaire;
	 private List<Commentaire> listCommentaires;
	 private Integer id;
	 
	 // ----- Paramètres en sortie
	 private String contenue;
	 
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContenue() {
		return contenue;
	}
	public void setContenue(String contenue) {
		this.contenue = contenue;
	}
	// ==================== Méthodes ====================
	public String doListComment(){
		logger.debug("BackGestionCommentAction méthode doListComment()");
		listCommentaires=managerFactory.getCommentaireManager().getListCommentaire();
		return Action.SUCCESS;
	}
	
	public String doUpdateComment() {
		logger.debug("BackGestionCommentAction méthode doUpdateComment()");
	
        if(id==null) {
			this.addActionError("veuillez donner un identifiant de commentaire");			
		}
		else {
			try {
				commentaire=managerFactory.getCommentaireManager().getCommentaire(id);
				 if (!StringUtils.isAllEmpty(contenue)){
					 commentaire.setContenue(contenue);
					 managerFactory.getCommentaireManager().updateCommentaire(commentaire);
				 }
				
			}catch(NotFoundException pE) {
				logger.debug(pE.getMessage());
			}
		}
		return Action.SUCCESS;
	}
	
	public String doDeleteComment() {
		logger.debug("BackGestionCommentAction méthode doDeleteComment()");
		if(id==null) {
			this.addActionError("veuillez donner un identifiant de commentaire");			
		}
		else {
			try {
				managerFactory.getCommentaireManager().deleteCommentaire(id);
				
			}catch(NotFoundException pE) {
				logger.debug(pE.getMessage());
			}
		}
		
		return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
	}
	
	public String doDetailComment() {
		logger.debug("BackGestionCommentAction méthode doDetailComment()");
		if(id==null) {
			this.addActionError("veuillez donner un identifiant de commentaire");			
		}
		else {
			try {
				commentaire=managerFactory.getCommentaireManager().getCommentaire(id);
				
			}catch(NotFoundException pE) {
				logger.debug(pE.getMessage());
			}
		}
		
		return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
	}

}
