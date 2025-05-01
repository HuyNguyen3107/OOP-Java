import java.util.*;

class Task {
    String name;
    int priority;
    int time;

    public Task(String name, int priority, int time) {
        this.name = name;
        this.priority = priority;
        this.time = time;
    }

    @Override
    public String toString() {
        return name + " " + priority + " " + time;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        List<Task> tasks = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(" ");
            String name = parts[0];
            int priority = Integer.parseInt(parts[1]);
            int time = Integer.parseInt(parts[2]);
            tasks.add(new Task(name, priority, time));
        }

        // Sắp xếp theo độ ưu tiên, rồi thời gian, rồi tên
        tasks.sort(Comparator.comparingInt((Task t) -> t.priority)
                .thenComparingInt(t -> t.time)
                .thenComparing(t -> t.name));

        // In ra công việc ưu tiên nhất (đầu danh sách)
        System.out.println(tasks.get(0));
    }
}
