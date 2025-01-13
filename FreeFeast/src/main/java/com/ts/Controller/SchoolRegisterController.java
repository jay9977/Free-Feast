package com.ts.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ts.Model.SchoolRegisterModel;

import com.ts.Service.SchoolRegisterService;

@RestController
@CrossOrigin("*")
public class SchoolRegisterController {
	@Autowired
	SchoolRegisterService ss;

	// api to post data in database
	@PostMapping("/add-school")
	public SchoolRegisterModel addSchool(@RequestBody SchoolRegisterModel school) {
		return ss.addSchool(school);

	}

	// api to get data from database
	@GetMapping("/get-school")
	public List<SchoolRegisterModel> getSchools() {
		return ss.getSchools();
	}

}
