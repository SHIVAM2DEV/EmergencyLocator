package com.EmergencyLocator.emergency.hospitalEmergency.dto;

import com.EmergencyLocator.emergency.hospitalEmergency.entity.EmergencyStatus;
import jdk.jshell.Snippet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class HelpRespons {
    private Long userId;
    private String name;
    private Long emergencyContact;
    private String hospitalName;
    private Long availableBeds;
    private double distance;
    private double estimatedTime;
    private EmergencyStatus status;
}
