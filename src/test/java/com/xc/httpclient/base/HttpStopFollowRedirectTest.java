package com.xc.httpclient.base;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Administrator on 2016/9/5.
 */
public class HttpStopFollowRedirectTest {

    @Test
    public void stopRedirect() throws Exception {
        HttpClient client =  HttpClientBuilder
                .create()
                .disableRedirectHandling()
                .build();

        HttpResponse response = client.execute(new HttpGet("http://t.co/I5YYd9tddw"));

        Assert.assertEquals(response.getStatusLine().getStatusCode(),301);

    }
}
