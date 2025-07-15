# AttachmentAvApi

All URIs are relative to *https://eu.developer.attachmentav.com/v1*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**scanSyncBinaryPost**](AttachmentAvApi.md#scanSyncBinaryPost) | **POST** /scan/sync/binary |  |
| [**scanSyncDownloadPost**](AttachmentAvApi.md#scanSyncDownloadPost) | **POST** /scan/sync/download |  |
| [**scanSyncFormPost**](AttachmentAvApi.md#scanSyncFormPost) | **POST** /scan/sync/form |  |
| [**scanSyncS3Post**](AttachmentAvApi.md#scanSyncS3Post) | **POST** /scan/sync/s3 |  |


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

[apiKeyAuth](../README.md#apiKeyAuth)

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

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Success |  -  |

<a id="scanSyncFormPost"></a>
# **scanSyncFormPost**
> ScanResult scanSyncFormPost(_file)



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

    AttachmentAvApi apiInstance = new AttachmentAvApi(defaultClient);
    File _file = new File("/path/to/file"); // File | 
    try {
      ScanResult result = apiInstance.scanSyncFormPost(_file);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AttachmentAvApi#scanSyncFormPost");
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
| **_file** | [**File**](File.md)|  | |

### Return type

[**ScanResult**](ScanResult.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: multipart/form-data
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

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Success |  -  |

