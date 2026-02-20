package com.EmergencyLocator.hospital.service;

import com.EmergencyLocator.hospital.entity.Hospital;

import java.util.List;

public interface HospitalService {
    public List<Hospital> getAll();

    Hospital save(Hospital hospital);
}
