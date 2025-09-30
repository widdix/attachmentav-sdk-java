package com.attachmentav.api.examples;

import com.attachmentav.api.AttachmentAvApi;
import com.attachmentav.client.ApiClient;
import com.attachmentav.client.ApiException;
import com.attachmentav.client.Configuration;
import com.attachmentav.model.AsyncS3ScanRequest;

public class AsyncS3 {
    public static void main(String[] args) throws ApiException {
        ApiClient client = Configuration.getDefaultApiClient();
        client.setApiKey("<API_KEY_PLACEHOLDER>");
        AttachmentAvApi api = new AttachmentAvApi();
        AsyncS3ScanRequest request = new AsyncS3ScanRequest();
        request.setCallbackUrl("https://api.yourcompany.com/attachmentav/callback");
        request.setBucket("<BUCKET_NAME_PLACEHOLDER>");
        request.setKey("<OBJECT_KEY_PLACEHOLDER>");
        //request.setVersion("<OBJECT_VERSION_PLACEHOLDER>"); // for versioned buckets only
        api.scanAsyncS3Post(request);
        System.out.println("Async S3 submitted");
    }
}
