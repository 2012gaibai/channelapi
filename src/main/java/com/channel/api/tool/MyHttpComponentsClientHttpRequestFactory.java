package com.channel.api.tool;

import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;


public class MyHttpComponentsClientHttpRequestFactory extends HttpComponentsClientHttpRequestFactory {

    protected MyHttpComponentsClientHttpRequestFactory(PoolingHttpClientConnectionManager pcm) {
        this.setHttpClient(HttpClients.custom().setConnectionManager(pcm).build());
    }
}