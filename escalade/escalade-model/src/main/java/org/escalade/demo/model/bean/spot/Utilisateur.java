package org.escalade.demo.model.bean.spot;

import org.escalade.demo.model.bean.topo.Role;

public class Utilisateur {
	
	// ==================== Attributs ====================
	private int id;
	private String nom;
	private String prenom;
	private String pseudo;
	private String mail;
	private String password;
	private Role role;

	
	// ==================== Getters/Setters ====================
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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

}
