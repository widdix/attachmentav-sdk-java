# AttachmentAvApi

All URIs are relative to *https://eu.developer.attachmentav.com/v1*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**scanAsyncDownloadPost**](AttachmentAvApi.md#scanAsyncDownloadPost) | **POST** /scan/async/download |  |
| [**scanAsyncS3Post**](AttachmentAvApi.md#scanAsyncS3Post) | **POST** /scan/async/s3 |  |
| [**scanSyncBinaryPost**](AttachmentAvApi.md#scanSyncBinaryPost) | **POST** /scan/sync/binary |  |
| [**scanSyncDownloadPost**](AttachmentAvApi.md#scanSyncDownloadPost) | **POST** /scan/sync/download |  |
| [**scanSyncS3Post**](AttachmentAvApi.md#scanSyncS3Post) | **POST** /scan/sync/s3 |  |


<a id="scanAsyncDownloadPost"></a>
# **scanAsyncDownloadPost**
> scanAsyncDownloadPost(asyncDownloadScanRequest)



Download a file from a remote location (HTTP/HTTPS), scan the file, and post the scan result to your callback URL.

### Example
```java
// Import classes:
import com.attachmentav.client.ApiClient;
import com.attachmentav.client.ApiException;
import com.attachmentav.client.Configuration;
import com.attachmentav.client.auth.*;
import com.attachmentav.client.models.*;
import com.attachmentav.api.AttachmentAvApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://eu.developer.attachmentav.com/v1");
    
    // Configure API key authorization: apiKeyAuth
    ApiKeyAuth apiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("apiKeyAuth");
    apiKeyAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //apiKeyAuth.setApiKeyPrefix("Token");

    // Configure HTTP bearer authorization: bearerAuth
    HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
    bearerAuth.setBearerToken("BEARER TOKEN");

    AttachmentAvApi apiInstance = new AttachmentAvApi(defaultClient);
    AsyncDownloadScanRequest asyncDownloadScanRequest = new AsyncDownloadScanRequest(); // AsyncDownloadScanRequest | 
    try {
      apiInstance.scanAsyncDownloadPost(asyncDownloadScanRequest);
    } catch (ApiException e) {
      System.err.println("Exception when calling AttachmentAvApi#scanAsyncDownloadPost");
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
| **asyncDownloadScanRequest** | [**AsyncDownloadScanRequest**](AsyncDownloadScanRequest.md)|  | |

### Return type

null (empty response body)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | Success |  -  |

<a id="scanAsyncS3Post"></a>
# **scanAsyncS3Post**
> scanAsyncS3Post(asyncS3ScanRequest)



Download a file from S3, scan the file, and post the scan result to your callback URL. A bucket policy is required to grant attachmentAV access to the S3 objects.

### Example
```java
// Import classes:
import com.attachmentav.client.ApiClient;
import com.attachmentav.client.ApiException;
import com.attachmentav.client.Configuration;
import com.attachmentav.client.auth.*;
import com.attachmentav.client.models.*;
import com.attachmentav.api.AttachmentAvApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://eu.developer.attachmentav.com/v1");
    
    // Configure API key authorization: apiKeyAuth
    ApiKeyAuth apiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("apiKeyAuth");
    apiKeyAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //apiKeyAuth.setApiKeyPrefix("Token");

    // Configure HTTP bearer authorization: bearerAuth
    HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
    bearerAuth.setBearerToken("BEARER TOKEN");

    AttachmentAvApi apiInstance = new AttachmentAvApi(defaultClient);
    AsyncS3ScanRequest asyncS3ScanRequest = new AsyncS3ScanRequest(); // AsyncS3ScanRequest | 
    try {
      apiInstance.scanAsyncS3Post(asyncS3ScanRequest);
    } catch (ApiException e) {
      System.err.println("Exception when calling AttachmentAvApi#scanAsyncS3Post");
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
| **asyncS3ScanRequest** | [**AsyncS3ScanRequest**](AsyncS3ScanRequest.md)|  | |

### Return type

null (empty response body)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | Success |  -  |

<a id="scanSyncBinaryPost"></a>
# **scanSyncBinaryPost**
> ScanResult scanSyncBinaryPost(body)



Upload a file, scan the file, and return the scan result.

### Example
```java
// Import classes:
import com.attachmentav.client.ApiClient;
import com.attachmentav.client.ApiException;
import com.attachmentav.client.Configuration;
import com.attachmentav.client.auth.*;
import com.attachmentav.client.models.*;
import com.attachmentav.api.AttachmentAvApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://eu.developer.attachmentav.com/v1");
    
    // Configure API key authorization: apiKeyAuth
    ApiKeyAuth apiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("apiKeyAuth");
    apiKeyAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //apiKeyAuth.setApiKeyPrefix("Token");

    // Configure HTTP bearer authorization: bearerAuth
    HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
    bearerAuth.setBearerToken("BEARER TOKEN");

    AttachmentAvApi apiInstance = new AttachmentAvApi(defaultClient);
    File body = new File("/path/to/file"); // File | 
    try {
      ScanResult result = apiInstance.scanSyncBinaryPost(body);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AttachmentAvApi#scanSyncBinaryPost");
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
| **body** | **File**|  | |

### Return type

[**ScanResult**](ScanResult.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/octet-stream
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Success |  -  |

<a id="scanSyncDownloadPost"></a>
# **scanSyncDownloadPost**
> ScanResult scanSyncDownloadPost(syncDownloadScanRequest)



Download a file from a remote location (HTTP/HTTPS), scan the file, and return the scan result.

### Example
```java
// Import classes:
import com.attachmentav.client.ApiClient;
import com.attachmentav.client.ApiException;
import com.attachmentav.client.Configuration;
import com.attachmentav.client.auth.*;
import com.attachmentav.client.models.*;
import com.attachmentav.api.AttachmentAvApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://eu.developer.attachmentav.com/v1");
    
    // Configure API key authorization: apiKeyAuth
    ApiKeyAuth apiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("apiKeyAuth");
    apiKeyAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //apiKeyAuth.setApiKeyPrefix("Token");

    // Configure HTTP bearer authorization: bearerAuth
    HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
    bearerAuth.setBearerToken("BEARER TOKEN");

    AttachmentAvApi apiInstance = new AttachmentAvApi(defaultClient);
    SyncDownloadScanRequest syncDownloadScanRequest = new SyncDownloadScanRequest(); // SyncDownloadScanRequest | 
    try {
      ScanResult result = apiInstance.scanSyncDownloadPost(syncDownloadScanRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AttachmentAvApi#scanSyncDownloadPost");
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
| **syncDownloadScanRequest** | [**SyncDownloadScanRequest**](SyncDownloadScanRequest.md)|  | |

### Return type

[**ScanResult**](ScanResult.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Success |  -  |

<a id="scanSyncS3Post"></a>
# **scanSyncS3Post**
> ScanResult scanSyncS3Post(syncS3ScanRequest)



Download a file from S3, scan the file, and return the scan result. A bucket policy is required to grant attachmentAV access to the S3 objects.

### Example
```java
// Import classes:
import com.attachmentav.client.ApiClient;
import com.attachmentav.client.ApiException;
import com.attachmentav.client.Configuration;
import com.attachmentav.client.auth.*;
import com.attachmentav.client.models.*;
import com.attachmentav.api.AttachmentAvApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://eu.developer.attachmentav.com/v1");
    
    // Configure API key authorization: apiKeyAuth
    ApiKeyAuth apiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("apiKeyAuth");
    apiKeyAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //apiKeyAuth.setApiKeyPrefix("Token");

    // Configure HTTP bearer authorization: bearerAuth
    HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
    bearerAuth.setBearerToken("BEARER TOKEN");

    AttachmentAvApi apiInstance = new AttachmentAvApi(defaultClient);
    SyncS3ScanRequest syncS3ScanRequest = new SyncS3ScanRequest(); // SyncS3ScanRequest | 
    try {
      ScanResult result = apiInstance.scanSyncS3Post(syncS3ScanRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AttachmentAvApi#scanSyncS3Post");
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
| **syncS3ScanRequest** | [**SyncS3ScanRequest**](SyncS3ScanRequest.md)|  | |

### Return type

[**ScanResult**](ScanResult.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Success |  -  |

