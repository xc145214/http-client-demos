package com.xc.httpclient.base;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;



/**
 * Created by Administrator on 2016/9/3.
 */
public class HttpGetStatusCodeTest {

    /**
     * 获取http状态码。
     * @throws Exception
     */
    @Test
    public void getGetStatus() throws Exception {
        String URL = "http://www.example.com";
        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpResponse response = client.execute(new HttpGet(URL));
        int statusCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(statusCode,HttpStatus.SC_OK);
        client.close();
    }
}
