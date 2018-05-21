package org.escalade.demo.webapp.action;

import java.util.List;

import org.escalade.demo.business.contract.ManagerFactory;
import org.escalade.demo.model.bean.topo.Role;
import org.escalade.demo.model.bean.topo.Utilisateur;
import org.escalade.demo.model.exception.NotFoundException;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@SuppressWarnings("serial")
public class BackGestionUserAction extends ActionSupport{
	static final Log logger = LogFactory.getLog(BackGestionUserAction.class);
	// ==================== Attributs ====================
    // ----- Paramètres en entrée
	private ManagerFactory managerFactory;
	private Utilisateur user;
	private List<Utilisateur> listUsers;
	private Integer id;
	private List<Role> listRole;
	
	// ----- Paramètres en sortie
	private String nom;
	private String prenom;
	private String pseudo;
	private String mail;
	private String password;
	private Role role;
	
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
	public List<Role> getListRole() {
		return listRole;
	}
	public void setListRole(List<Role> listRole) {
		this.listRole = listRole;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	// ==================== Méthodes ====================
	public String doListUtilisateur() {
		logger.debug("BackGestionUserAction méthode doListUtilisateur");
		listUsers=managerFactory.getUtilisateurManager().getListUtilisateur();
		return Action.SUCCESS;
	}
	
	public String doUpdateUtilisateur() {
		logger.debug("BackGestionUserAction méthode doUpdateUtilisateur");
		 if(id==null) {
				this.addActionError("veuillez donner un identifiant d'utilisateur");			
			}
			else {
				try {
					user=managerFactory.getUtilisateurManager().getUtilisateur(id);
					 if (!StringUtils.isAllEmpty(nom)){
						 user.setNom(nom);
					 }
					 if (!StringUtils.isAllEmpty(prenom)){
						 user.setPrenom(prenom);
					 }
					 if (!StringUtils.isAllEmpty(pseudo)){
						 user.setPseudo(pseudo);
					 }
					 if (!StringUtils.isAllEmpty(mail)){
						 user.setMail(mail);
					 }
					 if (!StringUtils.isAllEmpty(password)){
						 user.setPassword(password);
					 }
					 
					 System.out.println(role.getRole());
//					 Role userRole=managerFactory.getRoleManager().getRoleByName(userRole);
//					 user.setRole(role);
//					 
//					 System.out.println("role = "+role.getRole());
//					 managerFactory.getUtilisateurManager().updateUtilisateur(user);
				
					
				}catch(NotFoundException pE) {
					logger.debug(pE.getMessage());
				}
			}
			return Action.SUCCESS;
	}
	
	public String doDeleteUtilisateur() {
		logger.debug("BackGestionUserAction méthode doDeleteUtilisateur");
		if (id == null) {
			this.addActionError("Vous devez indiquer un id de utilisateur");
		} else {
			try {
				managerFactory.getCommentaireManager().deleteCommentaireByUser(id);
				managerFactory.getReservationManager().deleteReservationByUser(id);
				
				user=managerFactory.getUtilisateurManager().getUtilisateur(id);
				managerFactory.getUtilisateurManager().deleteUtilisateur(user);
				
			} catch (NotFoundException pE) {
				this.addActionError("user non trouvé. ID = " + id);
			}
		}
		return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
	
	}
	
	public String doDetailUtilisateur() {
		logger.debug("BackGestionUserAction méthode doDetailUtilisateur");
		if(id==null) {
			this.addActionError("veuillez donner un identifiant d'utilisateur");			
		}
		else {
			try {
				user=managerFactory.getUtilisateurManager().getUtilisateur(id);
				listRole=managerFactory.getRoleManager().getListRole();
				
			}catch(NotFoundException pE) {
				logger.debug(pE.getMessage());
			}
		}
		
		return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
	}

}
