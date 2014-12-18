package com.grameenfoundation.tasks;

import com.grameenfoundation.models.Market;

import java.util.List;

/**
 * Created by Ronald on 12/17/2014.
 */
public interface GetAllStockOnMarket {
    void onMarketStockReceived(List<Market> markets);
}
