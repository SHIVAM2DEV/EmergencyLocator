package com.EmergencyLocator.hospital.service.HospitalServiceImpl;

import com.EmergencyLocator.hospital.entity.Hospital;
import com.EmergencyLocator.hospital.repository.HospitalRepository;
import com.EmergencyLocator.hospital.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalServiceImpl implements HospitalService {

    @Autowired
    private HospitalRepository hospitalRepository;

    @Override
    public List<Hospital> getAll() {
        return hospitalRepository.findAll();
    }

    @Override
    public Hospital save(Hospital hospital) {
        return hospitalRepository.save(hospital);
    }
}
