package org.escalade.demo.webapp.action;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.escalade.demo.business.contract.ManagerFactory;
import org.escalade.demo.model.bean.topo.Reservation;
import org.escalade.demo.model.bean.topo.Topo;
import org.escalade.demo.model.bean.topo.Utilisateur;
import org.escalade.demo.model.exception.NotFoundException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class GestionReservationAction extends ActionSupport implements SessionAware {
	static final Log logger = LogFactory.getLog(GestionReservationAction.class);
	// ==================== Attributs ====================
    // ----- Paramètres en entrée
	private ManagerFactory managerFactory;
	private List<Reservation> listReservation;
	private Integer id;
	private Date dateDebut;
	private Date dateFin;
	private Map<String, Object> session;
	
	private String dateD;
	private String dateF;
		
	// ==================== Getters/Setters ====================
	public ManagerFactory getManagerFactory() {
		return managerFactory;
	}
	public void setManagerFactory(ManagerFactory managerFactory) {
		this.managerFactory = managerFactory;
	}
	public List<Reservation> getListReservation() {
		return listReservation;
	}
	public void setListReservation(List<Reservation> listReservation) {
		this.listReservation = listReservation;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	public String getDateD() {
		return dateD;
	}
	public void setDateD(String dateD) {
		this.dateD = dateD;
	}
	public String getDateF() {
		return dateF;
	}
	public void setDateF(String dateF) {
		this.dateF = dateF;
	}
	// ==================== Méthodes ====================
	public String doReservation() {
			try {
//				 if(id==null) {
//						this.addActionError("veuillez donner un identifiant de topo");
//						logger.info("Date de Fin : "+dateFin);
//						 logger.info("Date de début : "+dateDebut);
//					}
//				 else {
					 logger.info("Date de Fin : "+dateFin);
					 logger.info("Date de début : "+dateDebut);
					 logger.info(id);
					//Utilisateur user=(Utilisateur) this.session.get("user");
					//logger.info(user.getNom());
					
					Topo topo = managerFactory.getTopoManager().getTopo(id);
					
					listReservation=managerFactory.getReservationManager().listReservationByTopo(id);
					boolean[] testReservation = new boolean[listReservation.size()];
					int i=0;
					logger.info("Date de début : "+dateDebut);
					
					Iterator<Reservation> it = listReservation.iterator();
					while(it.hasNext()) {
						Reservation reservation = it.next();
						if(reservation.getDateFin().compareTo(dateDebut)<0) {
							//réservation fini
							testReservation[i]=true;
						}
						else if(reservation.getDateDebut().compareTo(dateDebut)>0 && reservation.getDateDebut().compareTo(dateFin)>0){
							//réservation pas encore commencé
							testReservation[i]=true;
						}
						else {
							//en plein pendant la période de réservation
							testReservation[i]=false;
							
						}
						i++;
					}
				
					if(areAllTrue(testReservation)) {
						// add reservation
						Reservation reservation = new Reservation();
						reservation.setDateDebut(dateDebut);
						reservation.setDateFin(dateFin);
						reservation.setTopo(topo);
						//reservation.setUtilisateur(user);
						
						//managerFactory.getReservationManager().addReservation(reservation);
						
						
					}
					
					else {
						this.addActionError("une réservation est en cours pendant la période demandé");
					}
				
				// }
				} catch (NotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
		return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
	}
	
	
	public static boolean areAllTrue(boolean[] array)
	{
	    for(boolean b : array) if(!b) return false;
	    return true;
	}


}
