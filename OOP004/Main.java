import java.util.*;

class Point {
    private int x;
    private int y;

    public Point() {
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    public double distanceTo(Point p) {
        return Math.sqrt(Math.pow(p.x -this.x, 2) + Math.pow(p.y - this.y, 2));
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-- > 0) {
            String[] input = sc.nextLine().split(" ");
            int x1 = Integer.parseInt(input[0]);
            int y1 = Integer.parseInt(input[1]);
            int x2 = Integer.parseInt(input[2]);
            int y2 = Integer.parseInt(input[3]);

            Point p1 = new Point(x1, y1);
            p1.move(1, 1); // Move p1 by (1, 1) for demonstration
            Point p2 = new Point(x2, y2);

            double distance = p1.distanceTo(p2);
            System.out.printf("%.2f\n", distance);
        }
    }
}