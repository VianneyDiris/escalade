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
public class GestionReservationAction extends ActionSupport implements SessionAware{
	static final Log logger = LogFactory.getLog(GestionReservationAction.class);
	// ==================== Attributs ====================
    // ----- Paramètres en entrée
	private ManagerFactory managerFactory;
	private List<Reservation> listReservation;
	private Integer id;
	private Date dateDebut;
	private Date dateFin;
	private Map<String, Object> session;
	private static Topo topo;
		
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
	public void setSession(Map<String, Object> pSession) {
		// TODO Auto-generated method stub	
		this.session=pSession;
	}
	public Topo getTopo() {
		return topo;
	}

	// ==================== Méthodes ====================
	public String doReservation() {
		String vResult = ActionSupport.INPUT;
		if(id==null) {
			logger.info(dateDebut);
			logger.info(topo.getNom());
			Utilisateur user=(Utilisateur) session.get("user");
	        logger.info("nom user : "+user.getNom());
			
			try {
				listReservation=managerFactory.getReservationManager().listReservationByTopo(topo.getId());
			} catch (NotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
				reservation.setUtilisateur(user);
				
				logger.info(dateDebut);
				logger.info(dateFin);
				logger.info(topo.getNom());
				
				managerFactory.getReservationManager().addReservation(reservation);
				this.addActionMessage("une réservation effectuée");
				return vResult=ActionSupport.SUCCESS;
				
				
			}
			
			else {
				this.addActionMessage("une réservation est en cours pendant la période demandé");
			}
		}
		else {
		try {
			topo=managerFactory.getTopoManager().getTopo(id);
			try {
				listReservation=managerFactory.getReservationManager().listReservationByTopo(topo.getId());
			} catch (NotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		
		}

		return vResult;
	}
	
	
	public static boolean areAllTrue(boolean[] array)
	{
	    for(boolean b : array) if(!b) return false;
	    return true;
	}
	
	


}
