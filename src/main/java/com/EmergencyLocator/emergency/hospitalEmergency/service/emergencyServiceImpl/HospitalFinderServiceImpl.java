package com.EmergencyLocator.emergency.hospitalEmergency.service.emergencyServiceImpl;

import com.EmergencyLocator.emergency.hospitalEmergency.service.HospitalFinderService;
import com.EmergencyLocator.hospital.entity.Hospital;
import com.EmergencyLocator.hospital.repository.HospitalRepository;
import com.EmergencyLocator.util.DistanceCalculator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class HospitalFinderServiceImpl implements HospitalFinderService {

    @Autowired
    private HospitalRepository hospitalRepository;

    @Override
    public List<Hospital> findNearby(double userLat, double userLang, double radiusKm) {
         List<Hospital> hospitals = hospitalRepository.findAll();

         return hospitals.stream().filter(hosp -> {
             double distance = DistanceCalculator.calculate(userLat, userLang, hosp.getLatitude(), hosp.getLongitude());
             log.info("Distance {} for hospital {}", distance, hosp);
             return Math.round(distance * 100.0) / 100.0 <= radiusKm;
         }).toList();
    }
}
