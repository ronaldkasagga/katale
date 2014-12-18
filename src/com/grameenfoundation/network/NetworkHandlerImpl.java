package com.grameenfoundation.network;

import android.util.Log;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Ronald on 12/17/2014.
 */
public class NetworkHandlerImpl implements NetworkHandler {

    private static final int CONNECTION_TIMEOUT = 10 * 1000;
    private static final int READ_TIMEOUT = 10 * 1000;
    private InputStream in;
    private DataOutputStream out;
    private HttpURLConnection urlConnection = null;
    private int responseCode;
    private String responseString;
    private static NetworkHandler networkHandler;
    private MarketUrls marketUrls;

    public NetworkHandlerImpl(MarketUrls marketUrls){
        this.marketUrls = marketUrls;
    }

    @Override
    public InputStream getServerResponse() {

        try {
            return urlConnection.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

         return  null;
    }

    @Override
    public void uploadData(String data) {
        try {
            urlConnection =getBaseConnection(marketUrls);

            out = new DataOutputStream(urlConnection.getOutputStream());
            out.writeChars(data);
            responseCode = urlConnection.getResponseCode();
            responseString = urlConnection.getResponseMessage();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int makeRequest() {
        try {
            urlConnection =getBaseConnection(marketUrls);
            responseCode = urlConnection.getResponseCode();
            responseString = urlConnection.getResponseMessage();
        } catch (IOException e) {
            e.printStackTrace();
        }




        return responseCode;
    }

    @Override
    public void disconnect() {
        if(urlConnection != null)
            urlConnection.disconnect();
    }

    protected HttpURLConnection getBaseConnection(MarketUrls marketUrls) throws IOException {
        HttpURLConnection connection = null;
        URL url;
        try{

            url = new URL(marketUrls.getUrls());

            connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("POST");
            //connection.setRequestProperty("Charset","utf-8");
            connection.setRequestProperty("Content-Type", "application/x-json");
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setUseCaches(false);
            //connection.setInstanceFollowRedirects(false);

            connection.setConnectTimeout(CONNECTION_TIMEOUT);
            connection.setReadTimeout(READ_TIMEOUT);
        }catch (MalformedURLException e)
        {
            Log.i("URL ERROR", "URL FAILURE");

            throw new IOException("Malformed URL");
        }
        return  connection;
    }

}
