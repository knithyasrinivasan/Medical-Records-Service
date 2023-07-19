package com.stackroute.medicalrecordsservice.Exception;

public class MedicalRecordAlreadyExistsException extends Exception{
    public MedicalRecordAlreadyExistsException() {
    }

    public MedicalRecordAlreadyExistsException(String message) {
        super(message);
    }
    
}
