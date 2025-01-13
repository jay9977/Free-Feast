package com.ts.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ts.Model.Complaint;

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {
	List<Complaint> findBySchoolName(String schoolName);
}
