package com.grameenfoundation.tasks;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.grameenfoundation.models.Market;
import com.grameenfoundation.network.MarketUrls;
import com.grameenfoundation.network.NetworkHandler;
import com.grameenfoundation.network.NetworkHandlerImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Ronald on 12/17/2014.
 */
public class FetchMarketTask extends AsyncTask<Void,Void,Void>{
    private NetworkHandler networkHandler;
    private Context context;
    private BufferedReader br;
    private StringBuffer stringBuffer;
    private Gson gson;
    private Type collectionType;
    private List<Market> markets;
    private GetAllStockOnMarket getAllStockOnMarket;
    private Handler handler = new Handler();
    public FetchMarketTask(Context context){
        this.context = context;

    }

    @Override
    protected void onPreExecute(){
        networkHandler = new NetworkHandlerImpl(MarketUrls.GET_STOCK);
        gson = new Gson();
        collectionType = new TypeToken<List<Market>>(){}.getType();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        if(networkHandler.makeRequest() == 200){
            br = new BufferedReader(new InputStreamReader(networkHandler.getServerResponse()));
            stringBuffer = new StringBuffer();
            String line ="";
            try {
                while ((line = br.readLine()) != null){
                    stringBuffer.append(line);

                }

                markets = gson.fromJson(stringBuffer.toString(),collectionType);


            }catch (IOException e){

            }
        }
        return null;
    }
    public void setGetAllStockOnMarket(GetAllStockOnMarket getAllStockOnMarket){
        this.getAllStockOnMarket = getAllStockOnMarket;
    }

    final Runnable onStockReceived = new Runnable() {
        @Override
        public void run() {
        getAllStockOnMarket.onMarketStockReceived(markets);
        }
    };

    @Override
    protected void onPostExecute(Void result){
             if(!markets.isEmpty()){
                 handler.post(onStockReceived);
             }
    }
}
