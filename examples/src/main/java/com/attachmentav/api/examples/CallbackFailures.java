package com.attachmentav.api.examples;

import com.attachmentav.api.AttachmentAvApi;
import com.attachmentav.client.ApiClient;
import com.attachmentav.client.ApiException;
import com.attachmentav.client.Configuration;

public class CallbackFailures {

    public static void main(String[] args) throws ApiException {
        ApiClient client = Configuration.getDefaultApiClient();
        client.setApiKey("<API_KEY_PLACEHOLDER>");
        AttachmentAvApi api = new AttachmentAvApi();
        com.attachmentav.model.CallbackFailures result = api.callbackFailuresGet("https://api.yourcompany.com/attachmentav/callback", null);
        System.out.println("Callback failures: " + result.toString());
    }
}
