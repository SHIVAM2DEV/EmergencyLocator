package com.EmergencyLocator.emergency.hospitalEmergency.entity;

import com.EmergencyLocator.User.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Emergency {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private double latitude;
    private double longitude;

    @Enumerated(EnumType.STRING)
    private EmergencyStatus status;

    private LocalDateTime createdAt;

}
