import java.util.*;

interface TacoBox {
    int tacoRemaining();
    void eat();
}

class TripleTacoBox implements TacoBox {
    private int tacos = 3;
    public int tacoRemaining() {
        return tacos;
    }

    public void eat() {
        if (tacos > 0) {
            tacos--;
        } 
    }
}

class CustomTacoBox implements TacoBox {
    private int tacos = 0;
    public CustomTacoBox(int tacos) {
        this.tacos = tacos;
    }

    public int tacoRemaining() {
        return tacos;
    }

    public void eat() {
        if (tacos > 0) {
            tacos--;
        } 
    }
}

public class Main {
    public static void main(String[] args) {
        TacoBox tacoTriple = new TripleTacoBox();

        tacoTriple.eat();
        tacoTriple.eat();

        System.out.println("Triple taco boxes left: " + tacoTriple.tacoRemaining());

        TacoBox tacoCustom = new CustomTacoBox(8);
        tacoCustom.eat();
        System.out.println("Custom taco boxes left: " + tacoCustom.tacoRemaining());
    }
}