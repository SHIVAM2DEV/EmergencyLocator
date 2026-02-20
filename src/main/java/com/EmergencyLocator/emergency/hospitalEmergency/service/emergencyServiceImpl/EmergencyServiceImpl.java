package com.EmergencyLocator.emergency.hospitalEmergency.service.emergencyServiceImpl;

import com.EmergencyLocator.User.entity.User;
import com.EmergencyLocator.User.repository.UserRepo;
import com.EmergencyLocator.emergency.hospitalEmergency.entity.Emergency;
import com.EmergencyLocator.emergency.hospitalEmergency.entity.EmergencyStatus;
import com.EmergencyLocator.emergency.hospitalEmergency.repository.EmergencyRepository;
import com.EmergencyLocator.emergency.hospitalEmergency.service.EmergencyService;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
    private UserRepo userRepo;

    @Override
    public Emergency createEmergency(Long userId, double lat, double lang) {
        User user = userRepo.findById(userId).orElseThrow();
        log.info("User find for User id {}", userId);

        Emergency emergencyReq = Emergency.builder()
                .user(user)
                .latitude(lat)
                .longitude(lang)
                .status(EmergencyStatus.CREATED)
                .createdAt(LocalDateTime.now())
                .build();

        return emergencyRepository.save(emergencyReq);

    }
}
