package org.escalade.demo.webapp.action;

import java.io.File;
import java.util.List;

import org.escalade.demo.business.contract.ManagerFactory;
import org.escalade.demo.model.bean.spot.Pays;
import org.escalade.demo.model.bean.spot.Spot;
import org.escalade.demo.model.bean.spot.Ville;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class AddAction extends ActionSupport {
	// ==================== Attributs ====================
    // ----- Paramètres en entrée
	private ManagerFactory managerFactory;
	private File fileUpload;
	private String fileUploadContentType;
	private String fileUploadFileName;
	private List<Spot> listSpot;
	private List<Pays> listPays;
	private List<Ville> listVille;
	// ==================== Getters/Setters ====================
	public ManagerFactory getManagerFactory() {
		return managerFactory;
	}
	public void setManagerFactory(ManagerFactory managerFactory) {
		this.managerFactory = managerFactory;
	}
	public File getFileUpload() {
		return fileUpload;
	}
	public void setFileUpload(File fileUpload) {
		this.fileUpload = fileUpload;
	}
	public String getFileUploadContentType() {
		return fileUploadContentType;
	}
	public void setFileUploadContentType(String fileUploadContentType) {
		this.fileUploadContentType = fileUploadContentType;
	}
	public String getFileUploadFileName() {
		return fileUploadFileName;
	}
	public void setFileUploadFileName(String fileUploadFileName) {
		this.fileUploadFileName = fileUploadFileName;
	}
	public List<Spot> getListSpot() {
		return listSpot;
	}
	public void setListSpot(List<Spot> listSpot) {
		this.listSpot = listSpot;
	}
	public List<Pays> getListPays() {
		return listPays;
	}
	public void setListPays(List<Pays> listPays) {
		this.listPays = listPays;
	}
	public List<Ville> getListVille() {
		return listVille;
	}
	public void setListVille(List<Ville> listVille) {
		this.listVille = listVille;
	}
	
	// ==================== Méthodes ====================
	public String doAdd() {
		listSpot=managerFactory.getSpotManager().allSpot();
		listPays=managerFactory.getPaysManager().allPays();
		listVille=managerFactory.getVilleManager().allVille();
		
		
		return ActionSupport.SUCCESS;
	} 

}
