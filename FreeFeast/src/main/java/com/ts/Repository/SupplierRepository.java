package com.ts.Repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ts.Model.Supplier;
@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
	boolean existsByEmailAndPassword(String email, String password);
	 List<Supplier> findAll(); 

}
