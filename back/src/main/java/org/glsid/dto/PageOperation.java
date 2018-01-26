package org.glsid.dto;

import java.io.Serializable;
import java.util.List;

import org.glsid.entities.Operation;

public class PageOperation implements Serializable {
	
	private List<Operation> operations;  // les opérations de la page courante
	private int page;  				 	 // numéro de la page courante
	private int nombreOperations;    	 // nombre d'opérations de la page courante
	private int totalOperations;     	 // nombre d'opérations demandé dans chaque page
	private int totalPages;    	     	 // nombre total des pages

	public List<Operation> getOperations() {
		return operations;
	}
	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getNombreOperations() {
		return nombreOperations;
	}
	public void setNombreOperations(int nombreOperations) {
		this.nombreOperations = nombreOperations;
	}
	public int getTotalOperations() {
		return totalOperations;
	}
	public void setTotalOperations(int totalOperations) {
		this.totalOperations = totalOperations;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
}