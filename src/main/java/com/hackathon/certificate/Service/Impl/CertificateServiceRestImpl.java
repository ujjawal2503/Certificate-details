package com.hackathon.certificate.Service.Impl;

import com.hackathon.certificate.Dao.CertificateRepository;
import com.hackathon.certificate.Model.CertificateDetail;
import com.hackathon.certificate.Service.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CertificateServiceRestImpl implements CertificateService {

    @Autowired
    CertificateRepository certificateRepository;

  //

    @Override
    public CertificateDetail getCertificateByName(String certName) {
        return new CertificateDetail("Apache","Sanjay");
       // return certificateRepository.findById(certName).get() ;
    }


    @Override
    public List<CertificateDetail> getAllCertificate() {
        List<CertificateDetail> certificateDetailList = new ArrayList<>();
        certificateDetailList.add(new CertificateDetail("Java","Ujjawal"));
        certificateDetailList.add(new CertificateDetail("Eureka","Krishna"));
        certificateDetailList.add(new CertificateDetail("Jenkins","Nitisha"));
        certificateDetailList.add(new CertificateDetail("Salesforce","Raksha"));
        certificateDetailList.add(new CertificateDetail("Kibana","Manoj"));
        certificateDetailList.add(new CertificateDetail("Automation","  "));
        return certificateDetailList;
      //  return certificateRepository.findAll();
    }

    @Override
    public CertificateDetail updateCertificate(String certName,String assignee) {
        CertificateDetail certificateDetail = certificateRepository.findById(certName).get();
        certificateDetail.setAssigneeName(assignee);
        return certificateDetail;
    }
}
