package com.xc.httpclient.base;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

/**
 * 取消请求。
 * Created by Administrator on 2016/9/5.
 */
public class HttpCancelRequestTest {
    final String SAMPLE_URL = "http://www.example.com";
    @Test
    public void abortRequest() throws Exception {
        HttpClient clent = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(SAMPLE_URL);
        HttpResponse response = clent.execute(request);

        System.out.println(response.getStatusLine());
        request.abort();
    }
}
