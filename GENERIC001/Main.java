import java.util.*;

class Pair<T> {
    private T first;
    private T second;

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public void setSecond(T second) {
        this.second = second;
    }

    public void swap() {
        T temp = first;
        first = second;
        second = temp;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < test; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");

            // Kiểm tra xem có phải số không (dựa vào ký tự đầu tiên)
            if (parts[0].matches("-?\\d+")) {
                Integer a = Integer.parseInt(parts[0]);
                Integer b = Integer.parseInt(parts[1]);
                Pair<Integer> pair = new Pair<>(a, b);
                pair.swap();
                System.out.println(pair.getFirst() + " " + pair.getSecond());
            } else {
                Pair<String> pair = new Pair<>(parts[0], parts[1]);
                pair.swap();
                System.out.println("'" + pair.getFirst() + "' '" + pair.getSecond() + "'");
            }
        }
    }
}
