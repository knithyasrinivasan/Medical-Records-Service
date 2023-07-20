package com.stackroute.medicalrecordsservice.Model;

import javax.persistence.*;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "medical_records")
public class MedicalRecord {

    @Id
    private int patientId;
    private String patientName;
    private int patientAge;
    private String patientGender;
    private String timestamp;
    private int doctorId;
    private String notes;
    private String diagnosis;
    private String medication;
    private String dosage;
    private String frequency;
    private String startDate;
    private String endDate;
  

}