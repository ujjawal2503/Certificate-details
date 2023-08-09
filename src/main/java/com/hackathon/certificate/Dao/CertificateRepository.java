package com.hackathon.certificate.Dao;

import com.hackathon.certificate.Model.CertificateDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificateRepository extends JpaRepository<CertificateDetail, String> {
}
