package presenter;

import model.Shop;
import model.Toy;
import model.data.DataIO;
import view.View;

import java.io.IOException;
import java.util.*;

public class Presenter {
    private static final String PRIZES_PATH = "prizes.txt";
    View view;
    Shop shop;
    DataIO dataIO;
    public Presenter(View view, Shop shop, DataIO dataIO) {
        this.view = view;
        this.dataIO = dataIO;
        this.shop = shop.loadShop(dataIO);
    }


    public void addToy(String name, int weight) {
        Toy toy = new Toy(name, weight);
        this.shop.addToy(toy);
    }

    public String getToys() {
        var toys =  this.shop.getToys();
        StringBuilder sb = new StringBuilder();
        for (Toy toy: toys
             ) {
            String item = String.format("%5d %30s %5.3f", toy.getId(), toy.getName(), toy.getWeight());
            sb.append(item);
            sb.append("\n");
        }
        return sb.toString();
    }

    public Queue<Toy> playPrizes(int quantity) {
        return this.shop.getPrizeSet(quantity);
    }

    public void saveShop() throws IOException {
        this.shop.saveShop(this.dataIO);
    }

    public int getShopSize() {
        return this.shop.getSize();
    }

    public void removeToy(int index) {
        this.shop.removeToy(index);
    }

    public int getWeight(int index) {
        return this.shop.getToyMap().get(index).getWeight();
    }

    public void updateWeight(int index, int newWeight) {
        this.shop.changeWeight(index, newWeight);
    }

    public void savePrizes(LinkedList<String> name) throws IOException {
        this.dataIO.saveData(name, PRIZES_PATH);
    }
}
