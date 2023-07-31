package model.data;

import model.Shop;
import com.google.gson.Gson;
public class JsonFormatter implements Formatter{
    public String parseOut(Shop shop){
        Gson gson = new Gson();
        return gson.toJson(shop);
    }

    public Shop parseIn(String jsonString){
        Gson gson = new Gson();
        return gson.fromJson(jsonString, Shop.class);
    }
}
