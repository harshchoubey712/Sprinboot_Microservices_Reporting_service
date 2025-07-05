# DefaultApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**transactionsStatusesStatusGet**](DefaultApi.md#transactionsStatusesStatusGet) | **GET** /transactions/statuses/{status} | Get transactions by status |



## transactionsStatusesStatusGet

> TransactionPage transactionsStatusesStatusGet(status, offset, limit, xRequestID)

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
        defaultClient.setBasePath("http://localhost");

        DefaultApi apiInstance = new DefaultApi(defaultClient);
        BigDecimal status = new BigDecimal(78); // BigDecimal | 
        Integer offset = 56; // Integer | 
        Integer limit = 56; // Integer | 
        String xRequestID = "xRequestID_example"; // String | 
        try {
            TransactionPage result = apiInstance.transactionsStatusesStatusGet(status, offset, limit, xRequestID);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DefaultApi#transactionsStatusesStatusGet");
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
| **status** | **BigDecimal**|  | |
| **offset** | **Integer**|  | [optional] |
| **limit** | **Integer**|  | [optional] |
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
| **200** | Successful response |  -  |

