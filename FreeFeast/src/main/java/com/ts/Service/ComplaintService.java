package com.ts.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ts.Model.Complaint;
import com.ts.Repository.ComplaintRepository;

@Service
public class ComplaintService {

	@Autowired
	private ComplaintRepository complaintRepository;

	public Complaint addComplaint(Complaint complaint) {
		return complaintRepository.save(complaint);
	}

	public List<Complaint> getComplaintsBySchoolName(String schoolName) {
		return complaintRepository.findBySchoolName(schoolName);
	}
	
	//method to get all complaint on ui
	public List<Complaint>getComplaints(){
		return complaintRepository.findAll();
	}
	
	//method to delete complaints
	public void deleteComplaint(Long id) {
        if (!complaintRepository.existsById(id)) {
            throw new IllegalArgumentException("Complaint with ID " + id + " does not exist");
        }
        complaintRepository.deleteById(id);
    }
}
