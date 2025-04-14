import java.util.*;

interface Movable {
    void move(int dx, int dy);
}

class Organism implements Movable {
    private int x, y;

    public Organism(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }

    public String toString() {
        return "x:" + x + ";y:" + y;
    }
}

class Herd {
    // list: ArrayList<Movable>
    private List<Movable> list = new ArrayList<>();

    public Herd() {
    }

    public void addToHerd(Movable m) {
        list.add(m);
    }

    public void move(int dx, int dy) {
        for (Movable m : list) {
            m.move(dx, dy);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Movable m : list) {
            sb.append(m.toString()).append("\n");
        }
        return sb.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());

        while(t-- > 0) {
            String[] input = scanner.nextLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            Herd herd = new Herd();
            herd.addToHerd(new Organism(x, y));
            herd.move(1, 1);
            System.out.print(herd.toString());
        }
    }
}