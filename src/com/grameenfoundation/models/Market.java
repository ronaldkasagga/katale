package com.grameenfoundation.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ronald on 12/16/2014.
 */
public class Market {

    private String name;

    public Market(String name) {
        this.name = name;
    }

    public static List<Market> getAll() {
        List<Market> markets = new ArrayList<Market>();
        markets.add(new Market("Kalerwe"));
        markets.add(new Market("Owino"));
        markets.add(new Market("Nakawa"));
        markets.add(new Market("Bugolobi"));
        return markets;
    }

    public static List<String> getAllAsStringList(){
        List<String> markets = new ArrayList<String>();
        for(Market market: getAll())
            markets.add(market.name);
        return markets;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
