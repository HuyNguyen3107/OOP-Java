import java.util.*;

class Item {
    private String name;
    private int weight;

    public Item(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public Item(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }
}

abstract class Box {
    abstract void add(Item item);
    abstract boolean isInBox(Item item);
}

class BoxWithMaxWeight extends Box {
    private List<Item> items;
    private int maxWeight;
    private int currentWeight = 0;

    public BoxWithMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
        this.items = new ArrayList<>();
    }

    public void add(Item item) {
        if (currentWeight + item.getWeight() <= maxWeight) {
            items.add(item);
            currentWeight += item.getWeight();
        }
    }

    public boolean isInBox(Item item) {
        return items.contains(item);
    }
}

public class Main {
    public static void main(String[] args) {
        Box box = new BoxWithMaxWeight(10);
        Item item1 = new Item("Saludo", 5);
        Item item2 = new Item("Pirkka", 5);
        Item item3 = new Item("Kopi Luwak", 5);

        box.add(item1);
        box.add(item2);
        box.add(item3); 
        System.out.println(box.isInBox(item1)); // true
        System.out.println(box.isInBox(item2)); // true
        System.out.println(box.isInBox(item3)); // true
    }
}