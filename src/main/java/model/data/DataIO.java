package model.data;

import model.Shop;
import model.Toy;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public interface DataIO {
    Shop loadData();
    void saveData(Shop shop) throws IOException;
    void saveData(LinkedList<String> data, String pathFile) throws IOException;
}
