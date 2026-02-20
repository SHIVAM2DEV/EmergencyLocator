package com.EmergencyLocator.emergency.hospitalEmergency.service;

import com.EmergencyLocator.emergency.hospitalEmergency.entity.Emergency;

public interface EmergencyService {
    Emergency createEmergency(Long userId, double lat, double lang);
}
