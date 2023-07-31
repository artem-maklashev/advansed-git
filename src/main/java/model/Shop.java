package model;

import model.data.DataIO;
import model.data.JsonFormatter;

import java.io.IOException;
import java.util.*;

public class Shop {

    private Map<Integer, Toy> toyMap;

    public Shop() {
        this.toyMap = new HashMap<Integer, Toy>();
    }
    public Map<Integer, Toy> getToyMap() {
        return toyMap;
    }

    public void addToy(Toy toy) {
        this.toyMap.put(toy.getId(), toy);
    }

    public void removeToy(int index) {
        this.toyMap.remove(index);
    }

    public void changeWeight(int index, int newWeight) {
        if (toyMap.containsKey(index)) {
            Toy t = toyMap.get(index);
            t.setWeight(newWeight);
        }
    }

    public Toy getPrizeToy() {
        Random random = new Random();
        int totalWeight = 0;
        for (Toy toy : toyMap.values()){
            totalWeight += toy.getWeight();
        }
        Toy prizeToy = null;
        float randomNumber = random.nextInt(totalWeight);
        float currentWeight = 0;
        for (Toy toy : toyMap.values()) {
            float weight = toy.getWeight();
            currentWeight += weight;
            if (randomNumber < currentWeight) {
                prizeToy = toy;
                break; // Exit the loop early once the prizeToy is found
            }
        }
        return prizeToy;
    }

    public Queue<Toy> getPrizeSet(int quantity) {
        Queue<Toy> toeQueue = new LinkedList<>();
        for (int i = 0; i < quantity; i++) {

            Toy prizeToy = getPrizeToy();
            if (prizeToy != null) {
                toeQueue.add(prizeToy);
            }
        }
        return toeQueue;
    }

    public List<Toy> getToys() {
        return new ArrayList<>(this.toyMap.values());
    }

    public Shop loadShop(DataIO dataIO){
//        String data = dataIO.loadData();
//        JsonFormatter formatter = new JsonFormatter();
        return dataIO.loadData();
    }

    public void saveShop(DataIO dataIO) throws IOException {
        dataIO.saveData(this);
    }

    public int getSize() {
        return toyMap.size();
    }
}
