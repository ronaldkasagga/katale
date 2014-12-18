package com.grameenfoundation.network;

import java.io.InputStream;

/**
 * Created by Ronald on 12/17/2014.
 */
public interface NetworkHandler {
    InputStream getServerResponse();
    void uploadData(String data);
    int makeRequest();
    void disconnect();
}
