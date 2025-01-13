package com.ts.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ts.Model.Meal;

@Repository
public interface MealRepository extends JpaRepository<Meal, Integer> {
	 // Find meals by school name
    static List<Meal> findBySchoolName(String schoolName) {
		
		return null;
	}

}
