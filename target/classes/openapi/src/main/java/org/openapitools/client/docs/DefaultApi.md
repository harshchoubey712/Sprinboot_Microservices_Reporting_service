# DefaultApi

All URIs are relative to *http://localhost:8081*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createTransaction**](DefaultApi.md#createTransaction) | **POST** /transactions | Create a new transaction |
| [**getTransactionsByStatus**](DefaultApi.md#getTransactionsByStatus) | **GET** /transactions/statuses/{status} | Get transactions by status |


<a id="createTransaction"></a>
# **createTransaction**
> TransactionDTO createTransaction(transactionDTO)

Create a new transaction

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8081");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    TransactionDTO transactionDTO = new TransactionDTO(); // TransactionDTO | 
    try {
      TransactionDTO result = apiInstance.createTransaction(transactionDTO);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#createTransaction");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **transactionDTO** | [**TransactionDTO**](TransactionDTO.md)|  | |

### Return type

[**TransactionDTO**](TransactionDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Transaction created successfully |  -  |
| **400** | Bad request |  -  |
| **500** | Internal server error |  -  |

<a id="getTransactionsByStatus"></a>
# **getTransactionsByStatus**
> TransactionPage getTransactionsByStatus(status, offset, limit, xRequestID)

Get transactions by status

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8081");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    BigDecimal status = new BigDecimal(78); // BigDecimal | Status code to filter transactions
    Integer offset = 0; // Integer | 
    Integer limit = 10; // Integer | 
    String xRequestID = "xRequestID_example"; // String | 
    try {
      TransactionPage result = apiInstance.getTransactionsByStatus(status, offset, limit, xRequestID);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#getTransactionsByStatus");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **status** | **BigDecimal**| Status code to filter transactions | |
| **offset** | **Integer**|  | [optional] [default to 0] |
| **limit** | **Integer**|  | [optional] [default to 10] |
| **xRequestID** | **String**|  | [optional] |

### Return type

[**TransactionPage**](TransactionPage.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Transactions retrieved successfully |  -  |
| **404** | No transactions found for the given status |  -  |

