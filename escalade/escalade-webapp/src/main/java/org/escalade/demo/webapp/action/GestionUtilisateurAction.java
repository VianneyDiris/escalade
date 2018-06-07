package org.escalade.demo.webapp.action;

import org.apache.commons.lang3.StringUtils;
import org.escalade.demo.business.impl.ManagerFactoryImpl;
import org.escalade.demo.model.bean.topo.Utilisateur;
import org.escalade.demo.model.exception.NotFoundException;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@SuppressWarnings("serial")
public class GestionUtilisateurAction extends ActionSupport {
	static final Log logger = LogFactory.getLog(GestionUtilisateurAction.class);
	// ==================== Attributs ====================
	// ----- Paramètres en entrée
	private String userName;
	private String userSurname;
	private String pseudo;
	private String mail;
	private String password;
	private String passwordConfirm;
	
	
	// ----- Paramètres en sortie
	private ManagerFactoryImpl managerFactory;
	
	
	// ==================== Getters/Setters ====================
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserSurname() {
		return userSurname;
	}
	public void setUserSurname(String userSurname) {
		this.userSurname = userSurname;
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
	public String getPasswordConfirm() {
		return passwordConfirm;
	}
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
	public ManagerFactoryImpl getManagerFactory() {
		return managerFactory;
	}
	public void setManagerFactory(ManagerFactoryImpl managerFactory) {
		this.managerFactory = managerFactory;
	}
	
	
	// ==================== Méthodes ====================
	public String doCreateUser() throws NotFoundException {
		logger.debug("GestionUtilisateurAction méthode doCreateUser()");
		
		// Par défaut, le result est "input"
        String vResult = ActionSupport.INPUT;
        
     // ===== Validation de l'ajout du user
        if (!StringUtils.isAllEmpty(userName,userSurname,pseudo,mail,password,passwordConfirm)) {
        	System.out.println(userName);
        	if(!password.equals(passwordConfirm)) {
        		this.addFieldError(password, "mot de passe différent");
        	}
        	
        	Utilisateur user = new Utilisateur();
        	user.setNom(userName);
        	user.setPrenom(userSurname);
        	user.setPseudo(pseudo);
        	user.setMail(mail);
        	user.setPassword(password);
        	user.setRole(managerFactory.getRoleManager().getRole(1));
        	System.out.println(user.getRole().getRole());
        	managerFactory.getUtilisateurManager().addUtilisateur(user);
        	
        	return vResult=ActionSupport.SUCCESS;
        }
        
        return vResult;
	}

}
