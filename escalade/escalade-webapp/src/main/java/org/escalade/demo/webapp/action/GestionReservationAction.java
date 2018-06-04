package org.escalade.demo.webapp.action;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.escalade.demo.business.contract.ManagerFactory;
import org.escalade.demo.model.bean.topo.Reservation;
import org.escalade.demo.model.exception.NotFoundException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class GestionReservationAction extends ActionSupport {
	static final Log logger = LogFactory.getLog(GestionReservationAction.class);
	// ==================== Attributs ====================
    // ----- Paramètres en entrée
	private ManagerFactory managerFactory;
	private List<Reservation> listReservation;
	private Integer id;
	private Date dateDebut;
	private Date dateFin;
		
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
	
	// ==================== Méthodes ====================
	public String doReservation() {
			try {
					listReservation=managerFactory.getReservationManager().listReservationByTopo(id);
					logger.info("Date de début : "+dateDebut);
					
					Iterator<Reservation> it = listReservation.iterator();
					while(it.hasNext()) {
						Reservation reservation = it.next();
						if(reservation.getDateFin().compareTo(dateDebut)<0) {
							
						}
						else {
							this.addActionError("une réservation est en cours pendant la période demandé");
						}
					}
					
				} catch (NotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
	}

}
