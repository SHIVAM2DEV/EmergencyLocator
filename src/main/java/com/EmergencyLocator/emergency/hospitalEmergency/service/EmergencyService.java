package com.EmergencyLocator.emergency.hospitalEmergency.service;

import com.EmergencyLocator.emergency.hospitalEmergency.dto.HelpRespons;
import com.EmergencyLocator.emergency.hospitalEmergency.entity.Emergency;
import com.EmergencyLocator.hospital.entity.Hospital;

import java.util.List;

public interface EmergencyService {
    List<HelpRespons> createEmergency(Long userId, double lat, double lang);
}
