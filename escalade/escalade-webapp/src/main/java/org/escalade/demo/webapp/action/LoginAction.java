package org.escalade.demo.webapp.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.escalade.demo.business.contract.ManagerFactory;
import org.escalade.demo.model.bean.topo.Utilisateur;
import org.escalade.demo.model.exception.NotFoundException;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@SuppressWarnings("serial")
public class LoginAction extends ActionSupport implements ServletRequestAware,SessionAware{
	static final Log logger = LogFactory.getLog(LoginAction.class);	
	
	// ==================== Attributs ====================
    // ----- Paramètres en entrée
    private String pseudo;
    private String password;
    private Map<String, Object> session;
    private HttpServletRequest servletRequest;
    
    private ManagerFactory managerFactory;
    private Utilisateur user;
    // ==================== Getters/Setters ====================
    public String getPseudo() {
        return pseudo;
    }
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
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
	@Override
	public void setSession(Map<String, Object> pSession) {
		// TODO Auto-generated method stub
		this.session=pSession;
		
	}
	@Override
	public void setServletRequest(HttpServletRequest pRequest) {
	    this.servletRequest = pRequest;
	}
	// ==================== Méthodes ====================
	public String doLogin() {
		logger.debug("LoginAction méthode doLogin()");
		
    	String vResult = ActionSupport.INPUT;
        if (!StringUtils.isAllEmpty(pseudo, password)) {
            try {
            	user = managerFactory.getUtilisateurManager().getUtilisateur(pseudo, password);
                this.session.put("user", user);
                vResult = ActionSupport.SUCCESS;
            } catch (NotFoundException pEx) {
                this.addActionError("Identifiant ou mot de passe invalide !");
            }
        }
        return vResult;
    }
    
    public String doLogout() {
    	logger.debug("LoginAction méthode doLogout()");
    	
    	this.session.remove("user");
    	// Invalidation de la session
        this.servletRequest.getSession().invalidate();
    	
        return ActionSupport.SUCCESS;
    }
	
	
    
}
