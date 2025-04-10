import java.util.*;

interface Identifiable {
    String getId();
}

interface Birthable {
    String getBirthDate();
}

class Citizen implements Identifiable, Birthable {
    private String name;
    private int age;
    private String id;
    private String birthDate;

    public Citizen(String name, int age, String id, String birthDate) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getId() {
        return id;
    }

    public String getBirthDate() {
        return birthDate;
    }
}

class Pet implements Birthable {
    private String name;
    private String birthDate;

    public Pet(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public String getBirthDate() {
        return birthDate;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = Integer.parseInt(scanner.nextLine());

        while (testCases-- > 0) {
            List<Birthable> birthables = new ArrayList<>();

            while (true) {
                String line = scanner.nextLine();
                if (line.equals("End")) break;

                String[] parts = line.split(" ");
                String type = parts[0];

                if (type.equals("Citizen")) {
                    String name = parts[1];
                    int age = Integer.parseInt(parts[2]);
                    String id = parts[3];
                    String birthDate = parts[4];
                    birthables.add(new Citizen(name, age, id, birthDate));
                } else if (type.equals("Pet")) {
                    String name = parts[1];
                    String birthDate = parts[2];
                    birthables.add(new Pet(name, birthDate));
                }
            }

            String year = scanner.nextLine();

            for (Birthable b : birthables) {
                if (b.getBirthDate().endsWith(year)) {
                    System.out.println(b.getBirthDate());
                }
            }
        }
    }
}
