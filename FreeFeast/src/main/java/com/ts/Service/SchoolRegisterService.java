package com.ts.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ts.Model.SchoolRegisterModel;
import com.ts.Repository.SchoolRegisterRepo;

@Service
public class SchoolRegisterService {
	@Autowired
	SchoolRegisterRepo sr;

	// to post data in database
	public SchoolRegisterModel addSchool(SchoolRegisterModel school) {
		return sr.save(school);
		// TODO Auto-generated method stub

	}

	// to get data from database
	public List<SchoolRegisterModel> getSchools() {
		return sr.findAll();

	}

}
