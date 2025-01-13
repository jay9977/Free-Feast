package com.ts.Model;

public class AssignRequestDTO {
	private int id; // The meal request ID
	private String supplierName; // The name of the supplier
	private String supplierCity; // The city of the supplier

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getSupplierCity() {
		return supplierCity;
	}

	public void setSupplierCity(String supplierCity) {
		this.supplierCity = supplierCity;
	}

	public AssignRequestDTO() {

	}

	public AssignRequestDTO(int id, String supplierName, String supplierCity) {

		this.id = id;
		this.supplierName = supplierName;
		this.supplierCity = supplierCity;
	}

}
