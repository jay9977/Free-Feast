package com.ts.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ts.Model.SchoolRegisterModel;

@Repository
public interface SchoolRegisterRepo extends JpaRepository<SchoolRegisterModel, Integer> {
	boolean existsByEmailAndPassword(String email, String password);

	// Method to retrieve school details
	SchoolRegisterModel findByEmail(String email);

}
