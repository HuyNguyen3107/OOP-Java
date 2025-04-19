import java.util.*;

// Ngoại lệ tùy chỉnh
class UsedCarException extends Exception {
    public UsedCarException(String vin) {
        super("Invalid UsedCar: VIN " + vin);
    }
}

// Lớp UsedCar
class UsedCar {
    private String vin;
    private String make;
    private int year;
    private int mileage;
    private double price;

    public UsedCar(String vin, String make, int year, int mileage, double price) throws UsedCarException {
        if (!vin.matches("\\d{4}")) {
            throw new UsedCarException(vin);
        }

        List<String> validMakes = Arrays.asList("Ford", "Honda", "Toyota", "Chrysler");
        if (!validMakes.contains(make)) {
            throw new UsedCarException(vin);
        }

        if (year < 1990 || year > 2014) {
            throw new UsedCarException(vin);
        }

        if (mileage < 0 || price < 0) {
            throw new UsedCarException(vin);
        }

        this.vin = vin;
        this.make = make;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("UsedCar{vin='%s', make='%s', year=%d, mileage=%d, price=%.1f}",
                vin, make, year, mileage, price);
    }
}

// Lớp chính
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = Integer.parseInt(sc.nextLine());

        List<UsedCar> validCars = new ArrayList<>();

        for (int i = 0; i < testCases; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(",");

            if (parts.length != 5) continue;

            String vin = parts[0].trim();
            String make = parts[1].trim();
            int year = Integer.parseInt(parts[2].trim());
            int mileage = Integer.parseInt(parts[3].trim());
            double price = Double.parseDouble(parts[4].trim());

            try {
                UsedCar car = new UsedCar(vin, make, year, mileage, price);
                validCars.add(car);
            } catch (UsedCarException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("List of successfully constructed UsedCar objects:");
        if (validCars.isEmpty()) {
            System.out.println("No used cars");
        } else {
            for (UsedCar car : validCars) {
                System.out.println(car);
            }
        }
    }
}
