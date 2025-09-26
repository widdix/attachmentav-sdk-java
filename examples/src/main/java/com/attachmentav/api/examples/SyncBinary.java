package com.attachmentav.api.examples;

import com.attachmentav.api.AttachmentAvApi;
import com.attachmentav.client.ApiClient;
import com.attachmentav.client.ApiException;
import com.attachmentav.client.Configuration;
import com.attachmentav.model.ScanResult;

import java.io.File;

public class SyncBinary {

    public static void main(String[] args) throws ApiException {
        ApiClient client = Configuration.getDefaultApiClient();
        client.setApiKey("<API_KEY_PLACEHOLDER>");
        AttachmentAvApi api = new AttachmentAvApi();
        ScanResult result = api.scanSyncBinaryPost(new File("/path/to/file"));
        System.out.println("Scan Result: " + result.getStatus());
    }
}
