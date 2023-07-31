package model;

public class Toy implements Comparable<Toy> {
    private static int idCounter = 1;
    private final int id;
    private String name;
    private int weight;

    public Toy(String name, int weight) {
        this.id = idCounter++;
        this.name = name;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Toy o) {
        // Сравнение по id
        int result = Integer.compare(this.id, o.getId());
        if (result != 0) {
            return result;
        }

        // Если id совпадает сравниваем по названию
        result = this.name.compareTo(o.getName());
        if (result != 0) {
            return result;
        }

        // Если названия совпадают сравниваем во весу
        return Float.compare(this.weight, o.getWeight());
    }
}