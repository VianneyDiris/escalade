package org.escalade.demo.webapp.action;

import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.escalade.demo.business.impl.ManagerFactoryImpl;
import org.escalade.demo.model.bean.spot.Spot;
import org.escalade.demo.model.bean.topo.Commentaire;
import org.escalade.demo.model.bean.topo.Topo;
import org.escalade.demo.model.bean.topo.Utilisateur;
import org.escalade.demo.model.exception.NotFoundException;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class GestionCommentaireAction extends ActionSupport implements SessionAware {

	// ==================== Attributs ====================
	// ----- Paramètres en entrée
	private ManagerFactoryImpl managerFactory;
	private Integer id;
	
	// ----- Eléments en sortie
	private String newComment;
	private Spot spot;
	private Topo topo;
	private Map<String, Object> session;

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
	public Spot getSpot() {
		return spot;
	}
	public void setSpot(Spot spot) {
		this.spot = spot;
	}
	public Topo getTopo() {
		return topo;
	}
	public void setTopo(Topo topo) {
		this.topo = topo;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> pSession) {
		// TODO Auto-generated method stub	
		this.session=pSession;
	}
	public String getNewComment() {
		return newComment;
	}
	public void setNewComment(String newComment) {
		this.newComment = newComment;
	}

	// ==================== Méthodes ====================
	public String doSpotCommentaire() {
		try {
			spot=managerFactory.getSpotManager().getSpot(id);
			} catch (NotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		try {
			topo = managerFactory.getTopoManager().getTopo(1);
			System.out.println(topo.getNom());
			} catch (NotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(newComment.equals(null)) {
			this.addFieldError(newComment, "un commentaire ne peux être vide");
		}
		
		 Utilisateur user=(Utilisateur) session.get("user");
		 Date date = new Date();
		 Commentaire commentaire = new Commentaire();
		 
		 commentaire.setTopo(topo);
		 commentaire.setSpot(spot);
		 commentaire.setUtilisateur(user);
		 commentaire.setDate(date);
		 commentaire.setContenue(newComment);
		 
		managerFactory.getCommentaireManager().addCommentaire(commentaire);
		 
		
		
		return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
	}
	
	public String doTopoCommentaire() {
		try {
			topo = managerFactory.getTopoManager().getTopo(id);
			} catch (NotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		try {
			spot = managerFactory.getSpotManager().getSpot(1);
			System.out.println(topo.getNom());
			} catch (NotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(newComment.equals(null)) {
			this.addFieldError(newComment, "un commentaire ne peux être vide");
		}
		
		 Utilisateur user=(Utilisateur) session.get("user");
		 Date date = new Date();
		 Commentaire commentaire = new Commentaire();
		 
		 commentaire.setTopo(topo);
		 commentaire.setSpot(spot);
		 commentaire.setUtilisateur(user);
		 commentaire.setDate(date);
		 commentaire.setContenue(newComment);
		 
		managerFactory.getCommentaireManager().addCommentaire(commentaire);
		 
		
		
		return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
	}
	
	
	
}
