package com.stackroute.medicalrecordsservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stackroute.medicalrecordsservice.Model.MedicalRecord;

public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Integer> {
    
}
