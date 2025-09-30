package com.attachmentav.api.examples;

import com.attachmentav.api.AttachmentAvApi;
import com.attachmentav.client.ApiClient;
import com.attachmentav.client.ApiException;
import com.attachmentav.client.Configuration;
import com.attachmentav.model.AsyncDownloadScanRequest;

public class AsyncDownload {

    public static void main(String[] args) throws ApiException {
        ApiClient client = Configuration.getDefaultApiClient();
        client.setApiKey("<API_KEY_PLACEHOLDER>");
        AttachmentAvApi api = new AttachmentAvApi();
        AsyncDownloadScanRequest request = new AsyncDownloadScanRequest();
        request.setCallbackUrl("https://api.yourcompany.com/attachmentav/callback");
        request.setDownloadUrl("https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf");
        api.scanAsyncDownloadPost(request);
        System.out.println("Async download submitted");
    }
}
