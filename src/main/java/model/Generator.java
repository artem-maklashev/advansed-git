package model;

import java.util.Objects;
import java.util.PriorityQueue;

public class Generator {

    private float totalWeight;
    private PriorityQueue<Toy> toys = new PriorityQueue<>();

    Generator(PriorityQueue<Toy> toys) {
        this.toys = toys;
    }

    public void setTotalWeight() {
        totalWeight = 0;
        for (Toy toy : this.toys) {
            totalWeight += toy.getWeight();
        }
        this.totalWeight = totalWeight;
    }

    public Toy getToy() {
        Toy toy = null;
        int randomIndex = -1;
        int random = (int) (Math.random() * this.totalWeight);
        PriorityQueue<Toy> temp = this.toys;
        for (int i = 0; i < this.toys.size(); i++) {
            random -= Objects.requireNonNull(temp.poll()).getWeight();
            if (random <= 0) {
                randomIndex = i;
                PriorityQueue<Toy> temp2 = this.toys;
                for (int j = 0; j <=randomIndex;
                j++){
                    toy = temp2.poll();
                }
            }
        }
        return toy;
    }


}
