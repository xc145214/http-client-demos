package com.xc.httpclient.base;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2016/9/3.
 */
public class HttpTimeOutTest {
    String URL = "http://www.example.com";

    @Test
    public void configViaStringParams() throws Exception {

        int timeout = 5;
        RequestConfig config = RequestConfig
                .custom()
                .setConnectTimeout(timeout * 1000)
                .setConnectionRequestTimeout(timeout * 1000)
                .setSocketTimeout(timeout * 1000)
                .build();

        HttpClient client = HttpClientBuilder
                .create()
                .setDefaultRequestConfig(config)
                .build();

        HttpGet get = new HttpGet(URL);
        HttpResponse response = client.execute(get);
        System.out.println("HTTP Status of response: " + response.getStatusLine().getStatusCode());
    }

    @Test
    public void hardTimeOut() throws Exception {
        final HttpGet get = new HttpGet(URL);
        HttpClient client = HttpClientBuilder
                .create()
                .build();

        int hardTimeout = 5;
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (get != null) {
                    get.abort();
                }
            }
        };
        new Timer(true).schedule(task, hardTimeout * 1000);

        HttpResponse response = client.execute(get);
        System.out.println("HTTP Status of response: " + response.getStatusLine().getStatusCode());

    }

    /**
     * DNS 轮询超时。
     *
     * @throws Exception
     */
    @Test
    public void dnsTimeout() throws Exception {

        int timeout = 3;
        RequestConfig config = RequestConfig
                .custom()
                .setConnectTimeout(timeout * 1000)
                .setConnectionRequestTimeout(timeout * 1000)
                .setSocketTimeout(timeout * 1000)
                .build();

        CloseableHttpClient client = HttpClientBuilder
                .create()
                .setDefaultRequestConfig(config)
                .build();

        HttpGet request = new HttpGet("http://www.baidu.com:81");
        HttpResponse reponse = client.execute(request);
        System.out.println(reponse.getStatusLine().getStatusCode());
        client.close();
    }
}
