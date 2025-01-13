package com.ts.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ts.Model.Supplier;
import com.ts.Repository.SupplierRepository;

@Service
public class SupplierService {
	@Autowired
	SupplierRepository sup;

//to post data into database
	public Supplier addSupplier(Supplier supplier) {
		return sup.save(supplier);
	}
  
	//to get data on ui
	public List<Supplier>getSupplier(){
		return sup.findAll();
	}
	
	
	
	
	// Method to delete a supplier by ID
    public boolean deleteSupplier(Long id) {
        try {
            // Check if supplier exists
            if (sup.existsById(id)) {
                sup.deleteById(id); // Delete supplier from the database
                return true; // Return true if deletion is successful
            } else {
                return false; // Return false if supplier is not found
            }
        } catch (Exception e) {
            // Log the exception (optional)
            System.out.println("Error deleting supplier: " + e.getMessage());
            return false; // Return false if any error occurs
        }
}
}
