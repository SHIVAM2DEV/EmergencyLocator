package com.EmergencyLocator.hospital.resolver;

import com.EmergencyLocator.hospital.entity.Hospital;
import com.EmergencyLocator.hospital.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hospital")
public class HospitalResolver {

    @Autowired
    private HospitalService hospitalService;

    @GetMapping
    public List<Hospital> getAll(){
        return hospitalService.getAll();
    }

    @PostMapping
    public Hospital saveHospital(@RequestBody Hospital hospital){
        return hospitalService.save(hospital);
    }

    
}
