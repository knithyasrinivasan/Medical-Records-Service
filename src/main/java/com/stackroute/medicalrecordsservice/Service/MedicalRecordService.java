package com.stackroute.medicalrecordsservice.Service;

import com.stackroute.medicalrecordsservice.Model.MedicalRecord;
import com.stackroute.medicalrecordsservice.Exception.MedicalRecordAlreadyExistsException;
import com.stackroute.medicalrecordsservice.Exception.MedicalRecordNotFoundException;

import java.util.List;  

public interface MedicalRecordService {

    MedicalRecord saveMedicalRecord(MedicalRecord medicalRecord) throws MedicalRecordAlreadyExistsException;

    MedicalRecord getMedicalRecordByPatientId(int patientId) throws MedicalRecordNotFoundException;


    List<MedicalRecord> getAllMedicalRecords() throws MedicalRecordNotFoundException;

    MedicalRecord updateMedicalRecordByPatientId(int patientId, MedicalRecord medicalRecord) throws MedicalRecordNotFoundException;

    boolean deleteMedicalRecordByPatientId(int patientId) throws MedicalRecordNotFoundException;

    boolean deleteAllMedicalRecords() throws MedicalRecordNotFoundException;

    public MedicalRecord getPatientByName(String patientName) throws MedicalRecordNotFoundException;

    
}
