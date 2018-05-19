package org.escalade.demo.webapp.action;

import java.util.List;

import org.escalade.demo.business.contract.ManagerFactory;
import org.escalade.demo.model.bean.topo.Commentaire;
import org.escalade.demo.model.exception.NotFoundException;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
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
	// ==================== Méthodes ====================
	public String doListComment(){
		logger.debug("BackGestionCommentAction méthode doListComment()");
		listCommentaires=managerFactory.getCommentaireManager().getListCommentaire();
		return Action.SUCCESS;
	}
	
	public String doUpdateComment() {
		logger.debug("BackGestionCommentAction méthode doUpdateComment()");
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

}
