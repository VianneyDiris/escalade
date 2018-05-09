package org.escalade.demo.webapp.action;

import java.util.List;

import org.escalade.demo.business.impl.ManagerFactoryImpl;
import org.escalade.demo.model.bean.spot.Spot;


import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class BackGestionSpotAction extends ActionSupport {
	// ==================== Attributs ====================
		// ----- Paramètres en entrée
		private ManagerFactoryImpl managerFactory;
		private Integer id;

		// ----- Eléments en sortie
		private List<Spot> listSpots;
		private Spot spot;

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
		public List<Spot> getListSpots() {
			return listSpots;
		}
		public void setListSpots(List<Spot> listSpots) {
			this.listSpots = listSpots;
		}
		public Spot getSpot() {
			return spot;
		}
		public void setSpot(Spot spot) {
			this.spot = spot;
		}
		
		// ==================== Méthodes ====================
		public String doListSpot() {
			listSpots=managerFactory.getSpotManager().getListSpot();
			return Action.SUCCESS;
		}
		
		public void doDeleteSpot() {
			
		}
		
		public void doUpdateSpot() {
			
		}
		
}
