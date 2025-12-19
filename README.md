# attachmentav-sdk-java

An SDK to integrate virus and malware scan capabilities into Java applications. Scan files for viruses, trojans, and other kinds of malware with attachmentAV powered by Sophos.

## What is attachmentAV?

[attachmentAV](https://attachmentav.com) offers antivirus for SaaS and cloud platforms. Scan your files and attachments stored in the cloud for viruses, worms, and trojans. attachmentAV detects malware in real-time. Supports Amazon S3, Atlassian, Cloudflare R2, Salesforce, WordPress, and more.

The [attachmentAV Virus and Malware Scan API](https://attachmentav.com/solution/virus-malware-scan-api/) provides a REST API allows you to integrate malware scans into your application. The solution comes in two variants:

* [attachmentAV Virus Scan API (SaaS)](https://attachmentav.com/help/virus-malware-scan-api/setup-guide/): get started quickly with a fully-managed service
* [attachmentAV Virus Scan API (Self-hosted on AWS)](https://attachmentav.com/help/virus-malware-scan-api-aws/setup-guide/): deploy the production-ready API on AWS

attachmentAV raises the bar for information security. Our solution is ISO 27001 certified and GDPR compliant. We are establishing, implementing, maintaining, and continually improving an information security management system (ISMS). Sensitive data is encrypted in transit as well as at rest and deleted immediately after processing. More than 1,000 customers trust our malware protection technology.

## Install SDK

After you have subscribed to attachmentAV Virus Scan API (SaaS) or deployed attachmentAV Virus Scan API (Self-hosted on AWS), proceed with installing and configuring the SDK. 

Find the latest version of the [virus-scan-sdk](https://central.sonatype.com/artifact/com.attachmentav/virus-scan-sdk) on Maven Central and add it to the dependencies of your project.

```xml
<dependency>
  <groupId>com.attachmentav</groupId>
  <artifactId>virus-scan-sdk</artifactId>
  <version>0.4.0</version>
</dependency>
```

## Configure SDK

### Configure SDK for the use with API (SaaS)

An [active subscription and API key](https://attachmentav.com/help/virus-malware-scan-api/setup-guide/#api-key) is required. Replace `<API_KEY_PLACEHOLDER>` with the API key.

```java
import com.attachmentav.api.AttachmentAvApi;
import com.attachmentav.client.ApiClient;
import com.attachmentav.client.ApiException;
import com.attachmentav.client.Configuration;
import com.attachmentav.model.ScanResult;

// ...

ApiClient client = Configuration.getDefaultApiClient();
client.setApiKey("<API_KEY_PLACEHOLDER>");
AttachmentAvApi api = new AttachmentAvApi();
```

### Configure SDK for the use with API (Self-hosted on AWS)

When following the setup guide, you specified the `ApiKeys` parameter for the CloudFormation stack. Replace `<API_KEY_PLACEHOLDER>` with one of those keys. 

```java
import com.attachmentav.api.AttachmentAvApi;
import com.attachmentav.client.ApiClient;
import com.attachmentav.client.ApiException;
import com.attachmentav.client.Configuration;
import com.attachmentav.model.ScanResult;

// ...

ApiClient client = Configuration.getDefaultApiClient();
client.setBearerToken("<API_KEY_PLACEHOLDER>");
client.setBasePath("https://example.com/api/v1");
AttachmentAvApi api = new AttachmentAvApi();
```

## Examples

### Sync Scan: File

Send a file to the attachmentAV Virus Scan API and process the scan result.

Maximum file size is 10 MB. The request timeout is 60 seconds.


```java
ScanResult result = api.scanSyncBinaryPost(new File("/path/to/file"));
System.out.println("Scan Result: " + result.getStatus());
```

Find full example [here](https://github.com/widdix/attachmentav-sdk-java/blob/main/examples/src/main/java/com/attachmentav/api/examples/SyncBinary.java)

### Sync Scan: Download

Send a URL to the attachmentAV Virus Scan API. attachmentAV will download the file and return the scan result immediately.

Maximum file size is 10 MB. The request timeout is 60 seconds.


```java
SyncDownloadScanRequest request = new SyncDownloadScanRequest();
request.setDownloadUrl("https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf");
ScanResult result = api.scanSyncDownloadPost(request);
System.out.println("Scan Result: " + result.getStatus());
```

Find full example [here](https://github.com/widdix/attachmentav-sdk-java/blob/main/examples/src/main/java/com/attachmentav/api/examples/SyncDownload.java)

### Sync Scan: S3

Send a S3 bucket name and object key to the attachmentAV Virus Scan API. attachmentAV will download the file and return the scan result immediately.

Maximum file size is 10 MB. The request timeout is 60 seconds.

> A [bucket policy](https://attachmentav.com/help/virus-malware-scan-api/setup-guide/#s3-bucket-policy) is required to grant attachmentAV access to private S3 objects.

```java
SyncS3ScanRequest request = new SyncS3ScanRequest();
request.setBucket("<BUCKET_NAME_PLACEHOLDER>");
request.setKey("<OBJECT_KEY_PLACEHOLDER>");
//request.setVersion("<OBJECT_VERSION_PLACEHOLDER>"); // for versioned buckets only
ScanResult result = api.scanSyncS3Post(request);
System.out.println("Scan Result: " + result.getStatus());
```

Find full example [here](https://github.com/widdix/attachmentav-sdk-java/blob/main/examples/src/main/java/com/attachmentav/api/examples/SyncS3.java)

### Async Scan: Download (callback)

Send a URL to the attachmentAV Virus Scan API. attachmentAV will send the scan result to the callback URL. See [callback URL](https://attachmentav.com/help/virus-malware-scan-api/setup-guide/#callback-url) for details.

Maximum file size is 5 GB. The request timeout is 29 seconds, the asynchronous scan job is not affected by this limit.

> Not supported by attachmentAV Virus Scan API (Self-hosted on AWS) yet. Contact [hello@attachmentav.com](hello@attachmentav.com) to let us know, in case you need this feature. 

```java
AsyncDownloadScanRequest request = new AsyncDownloadScanRequest();
request.setDownloadUrl("https://example.com/demo.txt");
request.setCallbackUrl("https://example.com/callback");
api.scanAsyncDownloadPost(request);
```

Find full example [here](https://github.com/widdix/attachmentav-sdk-java/blob/main/examples/src/main/java/com/attachmentav/api/examples/AsyncDownload.java)

### Async Scan: Download (polling)

Send a URL to the attachmentAV Virus Scan API. attachmentAV will download the file and store the scan result for 24 hours.

Maximum file size is 5 GB. The request timeout is 29 seconds, the asynchronous scan job is not affected by this limit.

> Not supported by attachmentAV Virus Scan API (Self-hosted on AWS) yet. Contact [hello@attachmentav.com](hello@attachmentav.com) to let us know, in case you need this feature. 

```java
String traceId = UUID.randomUUID().toString();
AsyncDownloadScanRequest request = new AsyncDownloadScanRequest();
request.setTraceId(traceId);
request.setDownloadUrl("https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf");
api.scanAsyncDownloadPost(request);
System.out.println("Async download submitted.");

// Wait some time...

ScanResult scanResult = api.scanAsyncResultGet(traceId);
System.out.println("Async download scan result: " + scanResult);
```

Find full example [here](https://github.com/widdix/attachmentav-sdk-java/blob/main/examples/src/main/java/com/attachmentav/api/examples/AsyncDownloadPolling.java)

### Async Scan: S3 (callback)

Send a S3 bucket name and object key to the attachmentAV Virus Scan API. attachmentAV will send the scan result to the callback URL. See [callback URL](https://attachmentav.com/help/virus-malware-scan-api/setup-guide/#callback-url) for details.

Maximum file size is 5 GB. The request timeout is 29 seconds, the asynchronous scan job is not affected by this limit.

> A [bucket policy](https://attachmentav.com/help/virus-malware-scan-api/setup-guide/#s3-bucket-policy) is required to grant attachmentAV access to private S3 objects.

> Not supported by attachmentAV Virus Scan API (Self-hosted on AWS) yet. Contact [hello@attachmentav.com](hello@attachmentav.com) to let us know, in case you need this feature.

```java
AsyncS3ScanRequest request = new AsyncS3ScanRequest();
request.setBucket("example-bucket");
request.setKey("demo.txt");
request.setCallbackUrl("https://example.com/callback");
api.scanAsyncS3Post(request);
```

Find full example [here](https://github.com/widdix/attachmentav-sdk-java/blob/main/examples/src/main/java/com/attachmentav/api/examples/AsyncS3.java)

### Async Scan: S3 (polling)

Send a S3 bucket name and object key to the attachmentAV Virus Scan API. attachmentAV will download the file and store the scan result for 24 hours.details.

Maximum file size is 5 GB. The request timeout is 29 seconds, the asynchronous scan job is not affected by this limit.

> A [bucket policy](https://attachmentav.com/help/virus-malware-scan-api/setup-guide/#s3-bucket-policy) is required to grant attachmentAV access to private S3 objects.

> Not supported by attachmentAV Virus Scan API (Self-hosted on AWS) yet. Contact [hello@attachmentav.com](hello@attachmentav.com) to let us know, in case you need this feature.

```java
String traceId = UUID.randomUUID().toString();
AsyncS3ScanRequest request = new AsyncS3ScanRequest();
request.setTraceId(traceId);
request.setBucket("<BUCKET_NAME_PLACEHOLDER>");
request.setKey("<OBJECT_KEY_PLACEHOLDER>");
//request.setVersion("<OBJECT_VERSION_PLACEHOLDER>"); // for versioned buckets only
api.scanAsyncS3Post(request);
System.out.println("Async S3 submitted.");

// Wait some time...

ScanResult scanResult = api.scanAsyncResultGet(traceId);
System.out.println("Async download scan result: " + scanResult);
```

Find full example [here](https://github.com/widdix/attachmentav-sdk-java/blob/main/examples/src/main/java/com/attachmentav/api/examples/AsyncS3.java)

### Usage

Get remaining credits and quota.

See [Usage](sdk/models/Usage.ts) for details.

> Not supported by attachmentAV Virus Scan API (Self-hosted on AWS).

```java
com.attachmentav.model.Usage result = api.usageGet();
System.out.println("Usage: " + result.toString());
```

Find full example [here](https://github.com/widdix/attachmentav-sdk-java/blob/main/examples/src/main/java/com/attachmentav/api/examples/Usage.java)

### Who am I

Get information abour yourself.

See [Whoami](sdk/models/Whoami.ts) for details.

> Not supported by attachmentAV Virus Scan API (Self-hosted on AWS).

```java
com.attachmentav.model.Whoami result = api.whoamiGet();
System.out.println("Who Am I: " + result.toString());
```

Find full example [here](https://github.com/widdix/attachmentav-sdk-java/blob/main/examples/src/main/java/com/attachmentav/api/examples/Whoami.java)

## Need help?

Do you need any help to get started with attachmentAV? [hello@attachmentav.com](mailto:hello@attachmentav.com).
