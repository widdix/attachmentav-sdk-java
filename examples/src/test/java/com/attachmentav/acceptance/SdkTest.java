
package com.attachmentav.acceptance.core;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

// SDK imports
import com.attachmentav.api.AttachmentAvApi;
import com.attachmentav.client.ApiClient;
import com.attachmentav.client.ApiException;
import com.attachmentav.client.Configuration;
import com.attachmentav.client.auth.ApiKeyAuth;
import com.attachmentav.client.auth.HttpBearerAuth;
import com.attachmentav.model.ScanResult;
import com.attachmentav.model.SyncDownloadScanRequest;
import com.attachmentav.model.SyncS3ScanRequest;
import com.attachmentav.model.AsyncDownloadScanRequest;
import com.attachmentav.model.AsyncS3ScanRequest;

public class SdkTest {
    
    private AttachmentAvApi api;
    private File testFile;
    private static final String TEST_FILE_CONTENT = "This is a test file for AttachmentAV scanning.";
    
    @BeforeClass
    public void setUp() throws IOException {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        
        String apiKey = System.getenv("ATTACHMENTAV_API_KEY");
        if (apiKey == null || apiKey.trim().isEmpty()) {
            throw new IllegalStateException("ATTACHMENTAV_API_KEY environment variable is required but not set");
        }
        ApiKeyAuth apiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("apiKeyAuth");
        apiKeyAuth.setApiKey(apiKey);
        api = new AttachmentAvApi(defaultClient);
        
        testFile = createTestFile();
    }

    
    private File createTestFile() throws IOException {
        Path tempFile = Files.createTempFile("attachmentav-test", ".txt");
        try (FileWriter writer = new FileWriter(tempFile.toFile())) {
            writer.write(TEST_FILE_CONTENT);
        }
        return tempFile.toFile();
    }

    @Test
    public void testSyncBinaryPost() throws ApiException {
        ScanResult result = api.scanSyncBinaryPost(testFile);
        Assert.assertEquals(result.getStatus(), "clean", "Expected clean file scan result");
    }

    @Test
    public void testSyncDownloadPost() throws ApiException {
        SyncDownloadScanRequest request = new SyncDownloadScanRequest();
        request.setDownloadUrl("https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf");    
        ScanResult result = api.scanSyncDownloadPost(request);    
        Assert.assertEquals(result.getStatus(), "clean", "Expected clean file scan result");
    }

    @Test
    public void testSyncS3Post() throws ApiException {
        SyncS3ScanRequest request = new SyncS3ScanRequest();
        request.setBucket("bucketav-release-data");
        request.setKey("latest.json");
        ScanResult result = api.scanSyncS3Post(request);
        Assert.assertEquals(result.getStatus(), "clean", "Expected clean file scan result");
    }

    @Test
    public void testAsyncDownloadPost() throws ApiException {
        AsyncDownloadScanRequest request = new AsyncDownloadScanRequest();
        request.setDownloadUrl("https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf");
        request.setCallbackUrl("https://example.com");
        api.scanAsyncDownloadPost(request);
    }

    @Test
    public void testAsyncS3Post() throws ApiException {
        AsyncS3ScanRequest request = new AsyncS3ScanRequest();
        request.setBucket("bucketav-release-data");
        request.setKey("latest.json");
        request.setCallbackUrl("https://example.com");
        api.scanAsyncS3Post(request);
    }

}
