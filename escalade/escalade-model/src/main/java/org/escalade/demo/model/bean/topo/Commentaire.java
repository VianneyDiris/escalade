package org.escalade.demo.model.bean.topo;

import java.util.Date;

import org.escalade.demo.model.bean.spot.Spot;

public class Commentaire {
	
	// ==================== Attributs ====================
	private Integer id;
	private String contenue;
	private Utilisateur utilisateur;
	private Date date;
	private Topo topo;
	private Spot spot;
	
	
	// ==================== Getters/Setters ====================
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
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public Topo getTopo() {
		return topo;
	}
	public void setTopo(Topo topo) {
		this.topo = topo;
	}
	
	public Spot getSpot() {
		return spot;
	}
	public void setSpot(Spot spot) {
		this.spot = spot;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	// ==================== Méthodes ====================

}
