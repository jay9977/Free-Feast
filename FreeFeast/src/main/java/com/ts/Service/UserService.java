package com.ts.Service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ts.Repository.AdminRepository;
import com.ts.Repository.SchoolRegisterRepo;
import com.ts.Repository.SupplierRepository;

@Service
public class UserService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private SchoolRegisterRepo schoolRegisterRepo;

    public Map<String, Object> validateUser(String email, String password, String role) {
        Map<String, Object> userDetails = new HashMap<>();

        switch (role) {
            case "admin":
                if (adminRepository.existsByEmailAndPassword(email, password)) {
                    userDetails.put("role", "admin");
                    userDetails.put("message", "Login successful");
                    return userDetails;
                }
                break;

            case "supplier":
                if (supplierRepository.existsByEmailAndPassword(email, password)) {
                    userDetails.put("role", "supplier");
                    userDetails.put("message", "Login successful");
                    return userDetails;
                }
                break;

            case "school":
                if (schoolRegisterRepo.existsByEmailAndPassword(email, password)) {
                    // Example: Retrieve additional details like school name
                    String schoolName = schoolRegisterRepo.findByEmail(email).getName();
                    userDetails.put("role", "school");
                    userDetails.put("schoolName", schoolName);
                    userDetails.put("message", "Login successful");
                    return userDetails;
                }
                break;

            default:
                return null; // Invalid role
        }
        return null; // Invalid credentials or role
    }
}
