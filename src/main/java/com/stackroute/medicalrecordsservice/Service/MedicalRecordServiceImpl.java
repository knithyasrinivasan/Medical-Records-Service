package com.stackroute.medicalrecordsservice.Service;

import com.stackroute.medicalrecordsservice.Model.MedicalRecord;
import com.stackroute.medicalrecordsservice.Exception.MedicalRecordAlreadyExistsException;
import com.stackroute.medicalrecordsservice.Exception.MedicalRecordNotFoundException;
import com.stackroute.medicalrecordsservice.Repository.MedicalRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


@Service
public class MedicalRecordServiceImpl implements MedicalRecordService {

    private MedicalRecordRepository medicalRecordRepository;
    @Autowired
    public MedicalRecordServiceImpl(MedicalRecordRepository medicalRecordRepository) {
        this.medicalRecordRepository = medicalRecordRepository;
    }


    @Override
    public MedicalRecord saveMedicalRecord(MedicalRecord medicalRecord) throws MedicalRecordAlreadyExistsException {

        if (medicalRecordRepository.existsById(medicalRecord.getPatientId())) {
            throw new MedicalRecordAlreadyExistsException("Medical Record Already Exists");
        }else {

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            medicalRecord.setTimestamp(dtf.format(now));
            MedicalRecord savedMedicalRecord = medicalRecordRepository.save(medicalRecord);
            return savedMedicalRecord;
        }
    }

    @Override
    public MedicalRecord getMedicalRecordByPatientId(int patientId) throws MedicalRecordNotFoundException {
          if (medicalRecordRepository.existsById(patientId)) {
                MedicalRecord retrievedMedicalRecord = medicalRecordRepository.findById(patientId).get();
                return retrievedMedicalRecord;
            }else {
                throw new MedicalRecordNotFoundException("Medical Record Not Found");
            }

    }

    @Override
    public List<MedicalRecord> getAllMedicalRecords() throws MedicalRecordNotFoundException {
        if (medicalRecordRepository.count() > 0) {
            List<MedicalRecord> retrievedMedicalRecords = medicalRecordRepository.findAll();
            return retrievedMedicalRecords;
        }else {
            throw new MedicalRecordNotFoundException("Medical Record Not Found");
        }

    }

    @Override
    public MedicalRecord updateMedicalRecordByPatientId(int patientId, MedicalRecord medicalRecord) throws MedicalRecordNotFoundException {

         if (medicalRecordRepository.existsById(patientId)) {
             MedicalRecord retrievedMedicalRecord = medicalRecordRepository.findById(patientId).get();
             
                retrievedMedicalRecord.setPatientAge(medicalRecord.getPatientAge());
                retrievedMedicalRecord.setDoctorId(medicalRecord.getDoctorId());
                retrievedMedicalRecord.setNotes(medicalRecord.getNotes());
                retrievedMedicalRecord.setDiagnosis(medicalRecord.getDiagnosis());
                retrievedMedicalRecord.setMedication(medicalRecord.getMedication());
                retrievedMedicalRecord.setDosage(medicalRecord.getDosage());
                retrievedMedicalRecord.setFrequency(medicalRecord.getFrequency());
                retrievedMedicalRecord.setStartDate(medicalRecord.getStartDate());
                retrievedMedicalRecord.setEndDate(medicalRecord.getEndDate());

                medicalRecordRepository.save(retrievedMedicalRecord);
                return retrievedMedicalRecord;
        }else {
            throw new MedicalRecordNotFoundException("Medical Record Not Found");
         }
    }

    @Override
    public boolean deleteMedicalRecordByPatientId(int patientId) throws MedicalRecordNotFoundException {
        if (medicalRecordRepository.existsById(patientId)) {
            medicalRecordRepository.deleteById(patientId);
            return true;
        }else {
            throw new MedicalRecordNotFoundException("Medical Record Not Found");
        }
    }

    @Override
    public boolean deleteAllMedicalRecords() throws MedicalRecordNotFoundException {
        if (medicalRecordRepository.count() > 0) {
            medicalRecordRepository.deleteAll();
            return true;
        }else {
            throw new MedicalRecordNotFoundException("Medical Record Not Found");
        }
    }

 // implement the method to get patient by name with bug
   @Override
   public MedicalRecord getPatientByName(String patientName) {
    return medicalRecordRepository.findByPatientName(patientName);
}
 
}
