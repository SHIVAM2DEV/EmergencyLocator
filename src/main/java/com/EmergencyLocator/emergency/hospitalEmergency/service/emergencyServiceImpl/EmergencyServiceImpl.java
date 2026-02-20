package com.EmergencyLocator.emergency.hospitalEmergency.service.emergencyServiceImpl;

import com.EmergencyLocator.User.entity.User;
import com.EmergencyLocator.User.repository.UserRepo;
import com.EmergencyLocator.emergency.hospitalEmergency.dto.HelpRespons;
import com.EmergencyLocator.emergency.hospitalEmergency.entity.Emergency;
import com.EmergencyLocator.emergency.hospitalEmergency.entity.EmergencyStatus;
import com.EmergencyLocator.emergency.hospitalEmergency.repository.EmergencyRepository;
import com.EmergencyLocator.emergency.hospitalEmergency.service.EmergencyService;
import com.EmergencyLocator.emergency.hospitalEmergency.service.HospitalFinderService;
import com.EmergencyLocator.hospital.entity.Hospital;
import com.EmergencyLocator.util.DistanceCalculator;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Slf4j
public class EmergencyServiceImpl implements EmergencyService {

    @Autowired
    private EmergencyRepository emergencyRepository;

    @Autowired
    private HospitalFinderService hospitalFinderService;

    @Autowired
    private UserRepo userRepo;

    @Override
    public List<HelpRespons> createEmergency(Long userId, double lat, double lang) {
        User user = userRepo.findById(userId).orElseThrow();
        log.info("User find for User id {}", userId);

        Emergency emergencyReq = Emergency.builder()
                .user(user)
                .latitude(lat)
                .longitude(lang)
                .status(EmergencyStatus.CREATED)
                .createdAt(LocalDateTime.now())
                .build();

        emergencyRepository.save(emergencyReq);

        List<Hospital> nearbyHospitals = hospitalFinderService.findNearby(lat, lang, 10);



        List<HelpRespons> helpRespons = nearbyHospitals.stream().map( hospital -> {
            double  distance = DistanceCalculator.calculate(lat, lang, hospital.getLatitude(), hospital.getLongitude());
            distance = Math.round(distance * 100.0) / 100.0;
            return HelpRespons.builder()
                    .userId(userId)
                    .name(user.getName())
                    .hospitalName(hospital.getName())
                    .emergencyContact(user.getEmergencyContact())
                    .availableBeds(hospital.getAvailableBeds())
                    .distance(distance)
                    .estimatedTime(calculateEstimatedTime(distance, 60))
                    .status(EmergencyStatus.ASSIGNED)
                    .build();

        }).toList();


        return helpRespons;

    }

    public static double calculateEstimatedTime(double distance, double speed){
        return (int) Math.ceil((distance/speed) * 60);
    }


}
