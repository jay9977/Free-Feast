package com.ts.Repository;

import com.ts.Model.Admin;
import java.lang.Long;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
	boolean existsByEmailAndPassword(String email, String password);

}
