package com.EmergencyLocator.emergency.hospitalEmergency.resolver;

import com.EmergencyLocator.emergency.hospitalEmergency.dto.HelpRequest;
import com.EmergencyLocator.emergency.hospitalEmergency.dto.HelpRespons;
import com.EmergencyLocator.emergency.hospitalEmergency.entity.Emergency;
import com.EmergencyLocator.emergency.hospitalEmergency.service.EmergencyService;
import com.EmergencyLocator.hospital.entity.Hospital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/emergency")
public class EmergencyResolver {

    @Autowired
    private EmergencyService emergencyService;

    @PostMapping("/help")
    public List<HelpRespons> helpRequest(@RequestBody HelpRequest dto){
        return  emergencyService.createEmergency(
                dto.getUserId(),
                dto.getLatitude(),
                dto.getLongitude()
        );
    }
}
