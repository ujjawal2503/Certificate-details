package com.hackathon.certificate.Service;

import com.hackathon.certificate.Model.CertificateDetail;

import java.util.List;

public interface CertificateService {

    CertificateDetail getCertificateByName(String certName);

    List<CertificateDetail> getAllCertificate();

    CertificateDetail updateCertificate(String certName,String assigneeName);

    List<CertificateDetail> getAllCertificateForNextThirtyDays();

    List<CertificateDetail> getAllCertificateForNextSixtyDays();
}
