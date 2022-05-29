package org.example.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class MedicalCertificates {

    @JsonProperty
    private int idMedicalCertificate;
    @JsonProperty
    private String doctorName;
    @JsonProperty
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/mm/yyyy")
    private Date expireDate;

    public MedicalCertificates() {
    }

    public MedicalCertificates(int idMedicalCertificate,
                               String doctorName,
                               Date expireDate) {
        this.idMedicalCertificate = idMedicalCertificate;
        this.doctorName = doctorName;
        this.expireDate = expireDate;
    }

    public int getIdMedicalCertificate() {
        return idMedicalCertificate;
    }

    public void setIdMedicalCertificate(int idMedicalCertificate) {
        this.idMedicalCertificate = idMedicalCertificate;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }
}
