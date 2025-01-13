package com.ts.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Assign_Request {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id;
	private String food_Item;
	private int quantity;
	private String measure;
	private String school_Name;
	private String supplier_name;
	//new
	 private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFood_Item() {
		return food_Item;
	}

	public void setFood_Item(String food_Item) {
		this.food_Item = food_Item;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getMeasure() {
		return measure;
	}

	public void setMeasure(String measure) {
		this.measure = measure;
	}

	public String getSchool_Name() {
		return school_Name;
	}

	public void setSchool_Name(String school_Name) {
		this.school_Name = school_Name;
	}

	public String getSupplier_name() {
		return supplier_name;
	}

	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}

	public Assign_Request() {

	}

	public Assign_Request(int id, String food_Item, int quantity, String measure, String school_Name,
			String supplier_name, String supplier_city) {

		this.id = id;
		this.food_Item = food_Item;
		this.quantity = quantity;
		this.measure = measure;
		this.school_Name = school_Name;
		this.supplier_name = supplier_name;
		this.status = status;
	}

	

}
