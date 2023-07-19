
package com.stackroute.medicalrecordsservice.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Prescription {
    @Id
    private int patientId;
    private String medication;
    private String dosage;
    private String frequency;
    private String startDate;
    private String endDate;
    
}