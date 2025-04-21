import java.util.*;

interface Identifiable {
    String getId();
}

class Human implements Identifiable {
    private String name;
    private int age;
    private String id;

    public Human (String name, int age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public String getId() {
        return this.id;
    }
}

class Robot implements Identifiable {
    String model;
    String id;

    public Robot(String model, String id) {
        this.model = model;
        this.id = id;
    }

    public String getId() {
        return this.id;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-- > 0) {
            List<Identifiable> arr = new ArrayList<>();
            String input = sc.nextLine();
            while(!input.equals("End")) {
                String[] strArr = input.split(" ");
                if (strArr[0].equals("Human")) {
                    Identifiable human = new Human(strArr[1], Integer.parseInt("2"), strArr[strArr.length - 1]);
                    arr.add(human);
                } else if (strArr[0].equals("Robot")) {
                    Identifiable robot = new Robot(strArr[1], strArr[strArr.length - 1]);
                    arr.add(robot);
                }
                input = sc.nextLine();
            }
            String checkStr = sc.nextLine();
            for (Identifiable id : arr) {
                if (id.getId().endsWith(checkStr)) {
                    System.out.println(id.getId());
                }
            }
        }
    }
}