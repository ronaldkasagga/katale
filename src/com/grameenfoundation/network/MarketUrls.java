package com.grameenfoundation.network;

/**
 * Created by Ronald on 12/17/2014.
 */
public enum MarketUrls {

    POST_STOCK(""), GET_STOCK("");
    private  String urls;

    private MarketUrls(String urls)
    {
        this.urls = urls;
    }
    public String getUrls(){
        return urls;
    }
}
