package com.EmergencyLocator.emergency.hospitalEmergency.dto;

import lombok.Data;

@Data
public class HelpRequest {
    private Long userId;
    private double latitude;
    private double longitude;
}
