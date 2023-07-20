package com.stackroute.medicalrecordsservice.Model;

import javax.persistence.*;

import lombok.*;


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

    public MedicalRecord() {
    }

    public MedicalRecord(int patientId, String patientName, int patientAge, String patientGender, String timestamp, int doctorId, String notes, String diagnosis, String medication, String dosage, String frequency, String startDate, String endDate) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.patientAge = patientAge;
        this.patientGender = patientGender;
        this.timestamp = timestamp;
        this.doctorId = doctorId;
        this.notes = notes;
        this.diagnosis = diagnosis;
        this.medication = medication;
        this.dosage = dosage;
        this.frequency = frequency;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public int getPatientAge() {
        return patientAge;
    }

    public String getPatientGender() {
        return patientGender;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public String getNotes() {
        return notes;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public String getMedication() {
        return medication;
    }

    public String getDosage() {
        return dosage;
    }

    public String getFrequency() {
        return frequency;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public void setPatientAge(int patientAge) {
        this.patientAge = patientAge;
    }

    public void setPatientGender(String patientGender) {
        this.patientGender = patientGender;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "MedicalRecord{" +
                "patientId=" + patientId +
                ", patientName='" + patientName + '\'' +
                ", patientAge=" + patientAge +
                ", patientGender='" + patientGender + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", doctorId=" + doctorId +
                ", notes='" + notes + '\'' +
                ", diagnosis='" + diagnosis + '\'' +
                ", medication='" + medication + '\'' +
                ", dosage='" + dosage + '\'' +
                ", frequency='" + frequency + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }
}