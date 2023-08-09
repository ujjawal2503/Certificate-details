package com.hackathon.certificate.Controller;

import com.hackathon.certificate.CertificateDetailsApplication;
import com.hackathon.certificate.Model.CertificateDetail;
import com.hackathon.certificate.Service.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/certificate")
public class CertificateController {

    @Autowired
    CertificateService certificateService;

    //retrieving the details certName
    @GetMapping
    ResponseEntity<List<CertificateDetail>> getAllCertificate(){
        List<CertificateDetail> contact = certificateService.getAllCertificate();
        return ResponseEntity.status(HttpStatus.OK).body(contact);
    }

    @GetMapping(value = "/{certName}")
    ResponseEntity<CertificateDetail> getCertificateByName(@PathVariable String certName){
        CertificateDetail certificate = certificateService.getCertificateByName(certName);
        return ResponseEntity.status(HttpStatus.OK).body(certificate);
    }

    @PutMapping(value = "/update/{certName}")
    ResponseEntity<CertificateDetail> updateCertificateAssignee(@PathVariable String certName,@RequestBody String assigneeName){
    CertificateDetail certificate = certificateService.updateCertificate(certName,assigneeName);
        return ResponseEntity.status(HttpStatus.OK).body(certificate);

}

}
