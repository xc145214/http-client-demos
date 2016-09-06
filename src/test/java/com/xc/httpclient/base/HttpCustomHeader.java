package com.xc.httpclient.base;

import com.google.common.collect.Lists;
import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.junit.Test;

import java.util.List;

/**
 * Created by Administrator on 2016/9/5.
 */
public class HttpCustomHeader {
    String URL = "http://www.example.com";
    @Test
    public void SetHeaderOnRequest() throws Exception {
        HttpClient client = HttpClients.custom().build();

        HttpUriRequest request = RequestBuilder
                .get()
                .setUri(URL)
                .setHeader(HttpHeaders.CONTENT_TYPE,"application/json")
                .build();
        client.execute(request);
    }

    @Test
    public void setHeaderOnClient() throws Exception {
        Header header = new BasicHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        List<Header> headers = Lists.newArrayList(header);
        HttpClient client = HttpClients.custom().setDefaultHeaders(headers).build();
        HttpUriRequest request = RequestBuilder.get().setUri(URL).build();
        client.execute(request);
    }
}
