package com.attachmentav.api.examples;

import com.attachmentav.api.AttachmentAvApi;
import com.attachmentav.client.ApiClient;
import com.attachmentav.client.ApiException;
import com.attachmentav.client.Configuration;
import com.attachmentav.model.ScanResult;
import com.attachmentav.model.SyncDownloadScanRequest;

public class SyncDownload {
    public static void main(String[] args) throws ApiException {
        ApiClient client = Configuration.getDefaultApiClient();
        client.setApiKey("<API_KEY_PLACEHOLDER>");
        AttachmentAvApi api = new AttachmentAvApi();
        SyncDownloadScanRequest request = new SyncDownloadScanRequest();
        request.setDownloadUrl("https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf");
        ScanResult result = api.scanSyncDownloadPost(request);
        System.out.println("Scan Result: " + result.getStatus());
    }
}