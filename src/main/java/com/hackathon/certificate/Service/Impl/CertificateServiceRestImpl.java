package com.hackathon.certificate.Service.Impl;

import com.hackathon.certificate.Dao.CertificateRepository;
import com.hackathon.certificate.Model.CertificateDetail;
import com.hackathon.certificate.Service.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Service
public class CertificateServiceRestImpl implements CertificateService {

    @Autowired
    CertificateRepository certificateRepository;

  //

    @Override
    public CertificateDetail getCertificateByName(String certName) {
        return new CertificateDetail("Apache","Sanjay", LocalDate.parse("2020-01-08"));
       // return certificateRepository.findById(certName).get() ;
    }


    @Override
    public List<CertificateDetail> getAllCertificate() {
        List<CertificateDetail> certificateDetailList = new ArrayList<>();
        certificateDetailList.add(new CertificateDetail("Java","Ujjawal",LocalDate.parse("2023-01-08")));
        certificateDetailList.add(new CertificateDetail("Eureka","Krishna",LocalDate.parse("2023-01-08")));
        certificateDetailList.add(new CertificateDetail("Jenkins","Nitisha",LocalDate.parse("2023-01-08")));
        certificateDetailList.add(new CertificateDetail("Salesforce","Raksha",LocalDate.parse("2023-01-08")));
        certificateDetailList.add(new CertificateDetail("Kibana","Manoj",LocalDate.parse("2023-01-08")));
        certificateDetailList.add(new CertificateDetail("Automation","  ",LocalDate.parse("2023-01-08")));
        return certificateDetailList;
      //  return certificateRepository.findAll();
    }

    @Override
    public CertificateDetail updateCertificate(String certName,String assignee) {
        CertificateDetail certificateDetail = certificateRepository.findById(certName).get();
        certificateDetail.setAssigneeName(assignee);
        return certificateDetail;
    }

    @Override
    public List<CertificateDetail> getAllCertificateForNextThirtyDays() {
        List<CertificateDetail> certificateDetailList = new ArrayList<>();
        certificateDetailList.add(new CertificateDetail("Java","Ujjawal",LocalDate.parse("2024-01-08")));
        certificateDetailList.add(new CertificateDetail("Eureka","Krishna",LocalDate.parse("2024-01-08")));
        certificateDetailList.add(new CertificateDetail("Jenkins","Nitisha",LocalDate.parse("2023-11-08")));
        certificateDetailList.add(new CertificateDetail("Salesforce","Raksha",LocalDate.parse("2023-10-08")));
        certificateDetailList.add(new CertificateDetail("Kibana","Manoj",LocalDate.parse("2023-09-08")));
       certificateDetailList.add(new CertificateDetail("Automation", "  ", LocalDate.parse("2023-09-08")));
       List<CertificateDetail> certificateDetailList1 = certificateDetailList.stream().filter(e->{
     Period period =  Period.between(LocalDate.now(),e.getExpiryDate());
 /*return  ( (period.getMonths()<=2) ||(period.getMonths()==3 && period.getDays()==0));*/
           return  ((period.getDays()<=30) && (period.getMonths()==0 &&period.getYears() ==0));
    }).toList();
        return certificateDetailList1;
    }
    @Override
    public List<CertificateDetail> getAllCertificateForNextSixtyDays() {
        List<CertificateDetail> certificateDetailList = new ArrayList<>();
        certificateDetailList.add(new CertificateDetail("Java","Ujjawal",LocalDate.parse("2024-01-08")));
        certificateDetailList.add(new CertificateDetail("Eureka","Krishna",LocalDate.parse("2024-01-08")));
        certificateDetailList.add(new CertificateDetail("Jenkins","Nitisha",LocalDate.parse("2023-11-08")));
        certificateDetailList.add(new CertificateDetail("Salesforce","Raksha",LocalDate.parse("2023-10-02")));
        certificateDetailList.add(new CertificateDetail("Kibana","Manoj",LocalDate.parse("2023-09-08")));
        certificateDetailList.add(new CertificateDetail("Automation", "  ", LocalDate.parse("2023-09-08")));
        List<CertificateDetail> certificateDetailList1 = certificateDetailList.stream().filter(e->{
            Period period =  Period.between(LocalDate.now(),e.getExpiryDate());
            return  ( (period.getMonths()<2) ||(period.getMonths()==2 && period.getDays()==0));

        }).toList();
        return certificateDetailList1;
    }
}
