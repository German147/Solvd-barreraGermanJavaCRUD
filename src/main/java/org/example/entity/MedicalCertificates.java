package org.example.entity;

import java.util.Date;

public class MedicalCertificates {

    private int idMedicalCertificate;
    private String doctorName;
    private Date expireDate;

    public MedicalCertificates() {
    }

    public MedicalCertificates(int idMedicalCertificate) {
        this.idMedicalCertificate = idMedicalCertificate;
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

    @Override
    public String toString() {
        return "MedicalCertificates{" +
                "idMedicalCertificate=" + idMedicalCertificate +
                ", doctorName='" + doctorName + '\'' +
                ", expireDate=" + expireDate +
                '}';
    }
}
