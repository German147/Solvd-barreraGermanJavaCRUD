package org.example.DAO;

import org.example.entity.MedicalCertificates;
import org.example.service.IEntity_DAO;

import java.util.List;

public class MedicalCertificateDAO implements IEntity_DAO<MedicalCertificates> {
    @Override
    public List<MedicalCertificates> listEntity() {
        return null;
    }

    @Override
    public int insertEntity(MedicalCertificates entity) {
        return 0;
    }

    @Override
    public MedicalCertificates getEntityBYId(MedicalCertificates entity) {
        return null;
    }

    @Override
    public int updateEntity(MedicalCertificates entity) {
        return 0;
    }

    @Override
    public int deleteEntity(MedicalCertificates entity) {
        return 0;
    }
}
