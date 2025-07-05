package org.openapitools.client.controller;

import java.math.BigDecimal;

import org.openapitools.client.ApiException;
import org.openapitools.client.dto.TransactionDTO;
import org.openapitools.client.dto.TransactionPage;
import org.openapitools.client.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/report")
public class ReportController {

    private final ReportService reportService;

    @Autowired
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/transactions/status/{status}")
    public ResponseEntity<TransactionPage> getByStatus(@PathVariable BigDecimal status) throws ApiException {
    	System.out.println(">>> Called GET by status: " + status);
        return ResponseEntity.ok(reportService.getTransactionsByStatus(status));
    }
    
    @PostMapping("/transactions")
    public ResponseEntity<TransactionDTO> forwardTransaction(@RequestBody TransactionDTO dto) throws ApiException {
        TransactionDTO saved = reportService.createTransaction(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
}
