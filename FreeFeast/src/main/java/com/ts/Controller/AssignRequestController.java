package com.ts.Controller;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ts.Model.AssignRequestDTO;
import com.ts.Model.Assign_Request;
import com.ts.Model.Meal;
import com.ts.Repository.AssignRequestRepository;
import com.ts.Repository.MealRepository;

@RestController
@CrossOrigin("*")
public class AssignRequestController {
	@Autowired
	private MealRepository mealRequestRepository;

	@Autowired
	private AssignRequestRepository assignRequestRepository;

	@PostMapping("/assign")
	public ResponseEntity<String> assignMealRequest(@RequestBody AssignRequestDTO assignRequestDTO) {
		try {
			// Find the meal request by ID
			Optional<Meal> mealRequest = mealRequestRepository.findById(assignRequestDTO.getId());
			if (!mealRequest.isPresent()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Meal request not found.");
			}

			// Create an AssignRequest entity from the DTO
			Assign_Request assignRequest = new Assign_Request();
			assignRequest.setFood_Item(mealRequest.get().getFood_Item());
			assignRequest.setQuantity(mealRequest.get().getQuentity());
			assignRequest.setMeasure(mealRequest.get().getMeasure());
			assignRequest.setSchool_Name(mealRequest.get().getSchool_Name());
			assignRequest.setSupplier_name(assignRequestDTO.getSupplierName());

			// Save the assignment to the database
			assignRequestRepository.save(assignRequest);

			// Delete the meal request after assigning
			mealRequestRepository.delete(mealRequest.get());

			return ResponseEntity.ok("Meal request assigned successfully.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error occurred while assigning meal request.");
		}
	}
//new
	@GetMapping("/get-assigned-requests")
	public ResponseEntity<List<Assign_Request>> getAssignedRequests() {
		try {
			List<Assign_Request> assignedRequests = assignRequestRepository.findAll();
			return ResponseEntity.ok(assignedRequests);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.emptyList());
		}
	}
	
	
	@PutMapping("/mark-delivered/{requestId}")
	public ResponseEntity<String> markAsDelivered(@PathVariable int requestId) {
	    try {
	        Optional<Assign_Request> assignRequest = assignRequestRepository.findById(requestId);
	        if (!assignRequest.isPresent()) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Request not found.");
	        }

	        Assign_Request request = assignRequest.get();
	        // Assuming you have a status field to update
	        request.setStatus("Delivered");
	        assignRequestRepository.save(request);

	        return ResponseEntity.ok("Request marked as delivered.");
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body("Error occurred while updating the request.");
	    }
	}

}
