package com.ts.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "meals")
public class Meal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String food_Item;
	private int quantity;
	private String measure;
	private String school_Name;

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

	public int getQuentity() {
		return quantity;
	}

	public void setQuentity(int quentity) {
		this.quantity = quentity;
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

	public Meal() {

	}

	public Meal(int id, String food_Item, int quantity, String measure, String school_Name) {

		this.id = id;
		this.food_Item = food_Item;
		this.quantity = quantity;
		this.measure = measure;
		this.school_Name = school_Name;
	}

}
