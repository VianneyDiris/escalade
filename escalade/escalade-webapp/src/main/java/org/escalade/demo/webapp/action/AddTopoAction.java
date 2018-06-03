package org.escalade.demo.webapp.action;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.escalade.demo.business.contract.ManagerFactory;
import org.escalade.demo.model.bean.spot.Spot;
import org.escalade.demo.model.bean.topo.Topo;
import org.escalade.demo.model.exception.NotFoundException;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class AddTopoAction extends ActionSupport {
	// ==================== Attributs ====================
    // ----- Paramètres en sortie
	private ManagerFactory managerFactory;
	private File fileUpload;
	private String fileUploadContentType;
	private String fileUploadFileName;
	private String topo;
	private String description;
	private String StringSpot;
	private String prive;
	
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
	public String getTopo() {
		return topo;
	}
	public void setTopo(String topo) {
		this.topo = topo;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStringSpot() {
		return StringSpot;
	}
	public void setStringSpot(String stringSpot) {
		StringSpot = stringSpot;
	}
	public String getPrive() {
		return prive;
	}
	public void setPrive(String prive) {
		this.prive = prive;
	}
	
	// ==================== Méthodes ==============================
	public String doAddTopo() {
		Topo newTopo =new Topo();
		 if (!StringUtils.isAllEmpty(topo)){
			 newTopo.setNom(topo);					 
		 }
		 else {
			 this.addFieldError(topo, "le nom du topo ne peut être vide");
		 }
		 if (!StringUtils.isAllEmpty(description)){
			 newTopo.setDescription(description);					 
		 }
		 else {
			 this.addFieldError(description, "la description du topo ne peut être vide");
		 }
		 
		 newTopo.setPrive(Boolean.parseBoolean(prive));
		 newTopo.setReserve(false);
		 newTopo.setPhoto(fileUploadFileName);
		 try {
			Spot spot=managerFactory.getSpotManager().getSpot(Integer.valueOf(StringSpot));
			newTopo.setSpot(spot);
			}
		 catch (NotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String filePath = ServletActionContext.getServletContext().getRealPath("/").concat("resource_image\\");  
        File fileToCreate = new File(filePath,fileUploadFileName);  
    
        try {
			FileUtils.copyFile(fileUpload, fileToCreate);//copying source file to new file  
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        managerFactory.getTopoManager().addTopo(newTopo);
        
		
		return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
	}
	

}
