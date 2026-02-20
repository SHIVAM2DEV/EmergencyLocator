package com.EmergencyLocator.emergency.hospitalEmergency.repository;

import com.EmergencyLocator.emergency.hospitalEmergency.entity.Emergency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmergencyRepository extends JpaRepository<Emergency, Long> {
}
