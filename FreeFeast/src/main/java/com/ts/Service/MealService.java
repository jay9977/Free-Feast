package com.ts.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ts.Model.Meal;
import com.ts.Model.Supplier;
import com.ts.Repository.MealRepository;

@Service
public class MealService {
	@Autowired
	MealRepository mr;

	public Meal addMeal(Meal meal) {
		return mr.save(meal);

	}

	// Fetch meals by school name
	public List<Meal> getMealsBySchoolName(String schoolName) {
		return MealRepository.findBySchoolName(schoolName);
	}

	// to get data on ui
	public List<Meal> getMeal() {
		return mr.findAll();
	}

}
