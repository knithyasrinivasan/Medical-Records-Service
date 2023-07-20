package com.stackroute.medicalrecordsservice.Controller;

import com.stackroute.medicalrecordsservice.Model.MedicalRecord;
import com.stackroute.medicalrecordsservice.Exception.MedicalRecordAlreadyExistsException;
import com.stackroute.medicalrecordsservice.Service.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1")
public class MedicalRecordController {

    private MedicalRecordService medicalRecordService;

    @Autowired
    public MedicalRecordController(MedicalRecordService medicalRecordService) {
        this.medicalRecordService = medicalRecordService;
    }

    ResponseEntity responseEntity;

    @PostMapping("/medicalRecord")
    public ResponseEntity<?> saveMedicalRecord(@RequestBody MedicalRecord medicalRecord) throws MedicalRecordAlreadyExistsException {
        try {
            medicalRecordService.saveMedicalRecord(medicalRecord);
            responseEntity = ResponseEntity.ok(medicalRecord);
        } catch (MedicalRecordAlreadyExistsException e) {
            responseEntity = ResponseEntity.badRequest().body(e.getMessage());
        }
        return responseEntity;
    }

    @GetMapping("/medicalRecord/{patientId}")
    public ResponseEntity<?> getMedicalRecordByPatientId(@PathVariable int patientId) {
        try {
            MedicalRecord retrievedMedicalRecord = medicalRecordService.getMedicalRecordByPatientId(patientId);
            responseEntity = ResponseEntity.ok(retrievedMedicalRecord);
        } catch (Exception e) {
            responseEntity = ResponseEntity.badRequest().body(e.getMessage());
        }
        return responseEntity;
    }

    @GetMapping("/medicalRecord")
    public ResponseEntity<?> getAllMedicalRecords() {
        try {
            responseEntity = ResponseEntity.ok(medicalRecordService.getAllMedicalRecords());
        } catch (Exception e) {
            responseEntity = ResponseEntity.badRequest().body(e.getMessage());
        }
        return responseEntity;
    }

    @PutMapping("/medicalRecord/{patientId}")
    public ResponseEntity<?> updateMedicalRecordByPatientId(@PathVariable int patientId, @RequestBody MedicalRecord medicalRecord) {
        try {
            MedicalRecord retrievedMedicalRecord = medicalRecordService.updateMedicalRecordByPatientId(patientId, medicalRecord);
            responseEntity = ResponseEntity.ok(retrievedMedicalRecord);
        } catch (Exception e) {
            responseEntity = ResponseEntity.badRequest().body(e.getMessage());
        }
        return responseEntity;
    }

    @DeleteMapping("/medicalRecord/{patientId}")
    public ResponseEntity<?> deleteMedicalRecordByPatientId(@PathVariable int patientId) {
        try {
            boolean isDeleted = medicalRecordService.deleteMedicalRecordByPatientId(patientId);
            responseEntity = ResponseEntity.ok(isDeleted);
        } catch (Exception e) {
            responseEntity = ResponseEntity.badRequest().body(e.getMessage());
        }
        return responseEntity;
    }

    @DeleteMapping("/medicalRecord")
    public ResponseEntity<?> deleteAllMedicalRecords() {
        try {
            boolean isDeleted = medicalRecordService.deleteAllMedicalRecords();
            responseEntity = ResponseEntity.ok(isDeleted);
        } catch (Exception e) {
            responseEntity = ResponseEntity.badRequest().body(e.getMessage());
        }
        return responseEntity;
    }

    //write method to get product by name with bug 
    @GetMapping("/medicalRecord/{patientName}")
    public ResponseEntity<?> getMedicalRecordByPatientName(@PathVariable String patientName) {
        try {
            responseEntity = ResponseEntity.ok(medicalRecordService.getMedicalRecordByPatientName(patientName));
        } catch (Exception e) {
            responseEntity = ResponseEntity.badRequest().body(e.getMessage());
        }
        return responseEntity;
    }


}
