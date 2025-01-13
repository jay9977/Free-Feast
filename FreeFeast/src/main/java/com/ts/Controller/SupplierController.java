package com.ts.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ts.Model.Supplier;
import com.ts.Service.SupplierService;

@RestController
@CrossOrigin("*")
public class SupplierController {
	@Autowired
	SupplierService sp;
   //api to add supplier
	@PostMapping("/add-supplier")
	public Supplier addSupplier(@RequestBody Supplier supplier) {
		return sp.addSupplier(supplier);

	}
    
	//api to get supplier
	@GetMapping("/get-supplier")
	public List<Supplier>getSupplier(){
		return sp.getSupplier();
	
	}
	
	
	//api to delete data
	@DeleteMapping("/delete-supplier/{id}")
	public ResponseEntity<Void> deleteSupplier(@PathVariable("id") Long id) {
	    boolean isDeleted = sp.deleteSupplier(id);
	    if (isDeleted) {
	        return ResponseEntity.ok().build();
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	    }
	}

	
	
	
}
