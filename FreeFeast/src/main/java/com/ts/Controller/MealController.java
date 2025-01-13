package com.ts.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ts.Model.Meal;
import com.ts.Model.Supplier;
import com.ts.Service.MealService;

@RestController
@CrossOrigin("*")
public class MealController {
	@Autowired
	MealService mealService;

	// api to post data
	@PostMapping("add-meal")
	public Map<String, Object> addMeal(@RequestBody Meal meal) {
		Map<String, Object> response = new HashMap<>();

		// Validation check
		if (meal.getFood_Item() == null || meal.getFood_Item().isEmpty() || meal.getQuentity() <= 0
				|| meal.getMeasure() == null || meal.getMeasure().isEmpty() || meal.getSchool_Name() == null
				|| meal.getSchool_Name().isEmpty()) {

			response.put("success", false);
			response.put("message", "Invalid meal data. Please check the inputs.");
			return response;
		}

		try {
			// Save meal using the service layer
			Meal savedMeal = mealService.addMeal(meal);

			response.put("success", true);
			response.put("message", "Meal added successfully");
			response.put("meal", savedMeal);
		} catch (Exception e) {
			response.put("success", false);
			response.put("message", "An error occurred while saving the meal");
			response.put("error", e.getMessage());
		}

		return response;
	}

	// api to get meal data
	@GetMapping("get-meal-requests")
	public List<Meal> getMeal() {
		return mealService.getMeal();

	}

}
