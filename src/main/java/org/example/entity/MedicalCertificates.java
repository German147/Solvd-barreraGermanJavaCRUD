package org.example.entity;

import org.example.XMLadapter.DateAdapter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

@XmlRootElement(name = "MedicalCertificates")
public class MedicalCertificates {

   @XmlAttribute(name = "idMedicalCertificate")
    private int idMedicalCertificate;

   @XmlElement(name = "doctorName")
    private String doctorName;

   @XmlJavaTypeAdapter(DateAdapter.class)
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
