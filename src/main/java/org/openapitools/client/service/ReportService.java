package org.openapitools.client.service;

import java.math.BigDecimal;

import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.api.DefaultApi;
import org.openapitools.client.dto.TransactionDTO;
import org.openapitools.client.dto.TransactionPage;
import org.springframework.stereotype.Service;

@Service
public class ReportService {

    private final DefaultApi defaultApi;

    public ReportService() {
        ApiClient apiClient = new ApiClient();
        apiClient.setBasePath("http://localhost:8081"); // URL of transaction-service
        this.defaultApi = new DefaultApi(apiClient);
    }

 // GET /transactions/statuses/{status}
    public TransactionPage getTransactionsByStatus(BigDecimal status) throws ApiException {
        return defaultApi.getTransactionsByStatus(status, null, null, null);
    }

    // POST /transactions
    public TransactionDTO createTransaction(TransactionDTO dto) throws ApiException {
        return defaultApi.createTransaction(dto);
    }
}
