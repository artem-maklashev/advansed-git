package model.data;

import model.Shop;

public interface Formatter {
    Shop parseIn(String string);
    String parseOut(Shop shop);
}
