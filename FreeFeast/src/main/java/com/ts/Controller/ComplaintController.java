package com.ts.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ts.Model.Complaint;
import com.ts.Service.ComplaintService;

@RestController
@CrossOrigin("*")
public class ComplaintController {

	@Autowired
	private ComplaintService complaintService;
   //api to add complaint into database
	@PostMapping("add-complaint")
	public Map<String, Object> addComplaint(@RequestBody Complaint complaint) {
		Map<String, Object> response = new HashMap<>();

		if (complaint.getComplaint() == null || complaint.getComplaint().isEmpty() || complaint.getDate() == null
				|| complaint.getDate().isEmpty() || complaint.getSchoolName() == null
				|| complaint.getSchoolName().isEmpty()) {

			response.put("success", false);
			response.put("message", "Invalid complaint data. Please check the inputs.");
			return response;
		}

		try {
			Complaint savedComplaint = complaintService.addComplaint(complaint);
			response.put("success", true);
			response.put("message", "Complaint added successfully");
			response.put("complaint", savedComplaint);
		} catch (Exception e) {
			response.put("success", false);
			response.put("message", "An error occurred while saving the complaint");
			response.put("error", e.getMessage());
		}

		return response;
	}

	//api to get complaint
	@GetMapping("/get-complaints")
	public List<Complaint>getComplaitns()  {
		return complaintService.getComplaints();
	}
	
	
	//api to delete complaint
	@DeleteMapping("/delete-complaint/{id}")
	public Map<String, Object> deleteComplaint(@PathVariable Long id) {
	    Map<String, Object> response = new HashMap<>();
	    try {
	        complaintService.deleteComplaint(id);
	        response.put("success", true);
	        response.put("message", "Complaint deleted successfully");
	    } catch (Exception e) {
	        response.put("success", false);
	        response.put("message", "Failed to delete the complaint");
	        response.put("error", e.getMessage());
	    }
	    return response;
	}

}
