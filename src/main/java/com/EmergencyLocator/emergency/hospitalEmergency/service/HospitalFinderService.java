package com.EmergencyLocator.emergency.hospitalEmergency.service;

import com.EmergencyLocator.hospital.entity.Hospital;

import java.util.List;

public interface HospitalFinderService {
    List<Hospital> findNearby(double userLat, double userLang, double radiusKm);
}
