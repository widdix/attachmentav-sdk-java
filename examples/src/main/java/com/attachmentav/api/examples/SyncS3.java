package com.attachmentav.api.examples;

import com.attachmentav.api.AttachmentAvApi;
import com.attachmentav.client.ApiClient;
import com.attachmentav.client.ApiException;
import com.attachmentav.client.Configuration;
import com.attachmentav.model.ScanResult;
import com.attachmentav.model.SyncS3ScanRequest;

public class SyncS3 {

    public static void main(String[] args) throws ApiException {
        ApiClient client = Configuration.getDefaultApiClient();
        client.setApiKey("<API_KEY_PLACEHOLDER>");
        AttachmentAvApi api = new AttachmentAvApi();
        SyncS3ScanRequest request = new SyncS3ScanRequest();
        request.setBucket("<BUCKET_NAME_PLACEHOLDER>");
        request.setKey("<OBJECT_KEY_PLACEHOLDER>");
        //request.setVersion("<OBJECT_VERSION_PLACEHOLDER>"); // for versioned buckets only
        ScanResult result = api.scanSyncS3Post(request);
        System.out.println("Scan Result: " + result.getStatus());
    }
}
