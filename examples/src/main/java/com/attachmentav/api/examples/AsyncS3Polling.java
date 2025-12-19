package com.attachmentav.api.examples;

import com.attachmentav.api.AttachmentAvApi;
import com.attachmentav.client.ApiClient;
import com.attachmentav.client.ApiException;
import com.attachmentav.client.Configuration;
import com.attachmentav.model.AsyncS3ScanRequest;
import com.attachmentav.model.ScanResult;

import java.util.UUID;

public class AsyncS3Polling {

    public static void main(String[] args) throws ApiException, InterruptedException {
        ApiClient client = Configuration.getDefaultApiClient();
        client.setApiKey("<API_KEY_PLACEHOLDER>");
        AttachmentAvApi api = new AttachmentAvApi();
        String traceId = UUID.randomUUID().toString();
        AsyncS3ScanRequest request = new AsyncS3ScanRequest();
        request.setTraceId(traceId);
        request.setBucket("<BUCKET_NAME_PLACEHOLDER>");
        request.setKey("<OBJECT_KEY_PLACEHOLDER>");
        //request.setVersion("<OBJECT_VERSION_PLACEHOLDER>"); // for versioned buckets only
        api.scanAsyncS3Post(request);
        System.out.println("Async S3 submitted. Start to poll for scan result...");
        int i = 0;
        while (true) {
            try {
                System.out.println('.');
                ScanResult scanResult = api.scanAsyncResultGet(traceId);
                System.out.println("Async download scan result: " + scanResult);
                System.exit(0);
            } catch (ApiException e) {
                if (e.getCode() == 404) {
                    i++;
                    if (i < 10) {
                        Thread.sleep(5000);
                    } else {
                        System.err.println("Async download scan result not found");
                        System.exit(1);
                    }
                } else {
                    throw e;
                }
            }
        }
    }
}
