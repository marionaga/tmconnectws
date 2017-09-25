package com.id.tmli.intranet.service.impl;

import com.id.tmli.intranet.service.SendSmsBroadcastService;
import org.apache.http.*;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by hito.mario on 29/12/2016.
 */
public class SendSmsBroadcastServiceImpl implements SendSmsBroadcastService {

    public String sendSMS(String url) throws Exception {

        String resultCode = "";
        // set timeout with 5 seconds.
//        RequestConfig config = RequestConfig.custom().setConnectTimeout(5 * 1000).build();
//
//        //use custom retry handler to make retry handler effect.
//        CloseableHttpClient httpClient = HttpClients.custom().setRetryHandler(process()).setDefaultRequestConfig(config).build();
//
//        //Execute request and get response.
//        HttpGet request = new HttpGet(url);
//        HttpResponse response = httpClient.execute(request);
//
//        HttpEntity entity = response.getEntity();
//        resultCode = EntityUtils.toString(entity, "UTF-8");
//        System.out.println("result code : " + resultCode);
//        httpClient.close();
        HttpGet get = new HttpGet(url);
        PoolingHttpClientConnectionManager connManager
                = new PoolingHttpClientConnectionManager();

        connManager.setMaxTotal(5);
        connManager.setDefaultMaxPerRoute(5);

        CloseableHttpClient closableHttpClient = HttpClients.custom().setConnectionManager(connManager).build();
        HttpResponse response = closableHttpClient.execute(get);
        try {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                InputStream instream = entity.getContent();
                try {
                    // do something useful
                    resultCode = EntityUtils.toString(entity, "UTF-8");
                } finally {
                    instream.close();
                }
            }
        } finally {
            closableHttpClient.close();
        }
        System.out.println("result code : " + resultCode);
        return resultCode;
    }

    /*public HttpRequestRetryHandler process() {

        HttpRequestRetryHandler customRetryHandler = new HttpRequestRetryHandler() {

            @Override
            public boolean retryRequest(IOException exception, int executionCount, HttpContext context) {
                if (executionCount >= 3) {
                    return false;
                }
                return true;
            }
        };
        return customRetryHandler;
    }*/

    ConnectionKeepAliveStrategy myStrategy = new ConnectionKeepAliveStrategy() {
        @Override
        public long getKeepAliveDuration(HttpResponse response, HttpContext context) {
            HeaderElementIterator it = new BasicHeaderElementIterator
                    (response.headerIterator(HTTP.CONN_KEEP_ALIVE));
            while (it.hasNext()) {
                HeaderElement he = it.nextElement();
                String param = he.getName();
                String value = he.getValue();
                if (value != null && param.equalsIgnoreCase
                        ("timeout")) {
                    return Long.parseLong(value) * 1000;
                }
            }
            return 5 * 1000;
        }
    };
}
