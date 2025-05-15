import java.util.*;

interface PricedItem {
    double getPrice();
}

interface SourceableItem {
    String getSource();
}

class Dish implements PricedItem, SourceableItem {
    private String name;
    private double price;
    private String restaurantName;

    public Dish(String name, double price, String restaurantName) {
        this.name = name;
        this.price = price;
        this.restaurantName = restaurantName;
    }

    public double getPrice() {
        return price;
    }

    public String getSource() {
        return restaurantName;
    }

    public String getResult() {
        return name + " - " + String.format("%.2f", price);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());
        while(t-- > 0) {
            List<Dish> dishes = new ArrayList<>();

        String input;
        input = scanner.nextLine();
        while (!input.equals("Checkout")) {
            String[] parts = new String[4];
            int index = 0;
            StringBuilder currentPart = new StringBuilder();
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if (c == ' ') {
                    if (currentPart.length() > 0) {
                        parts[index++] = currentPart.toString();
                        currentPart.setLength(0);
                    }
                } else if (c == '"') {
                    int endQuoteIndex = input.indexOf('"', i + 1);
                    if (endQuoteIndex != -1) {
                        currentPart.append(input, i, endQuoteIndex + 1);
                        parts[index++] = currentPart.toString();
                        currentPart.setLength(0);
                        i = endQuoteIndex;
                    }
                } else {
                    currentPart.append(c);
                }
            }
            if (currentPart.length() > 0) {
                parts[index++] = currentPart.toString();
            }
            String name = parts[1];
            double price = Double.parseDouble(parts[2]);
            String restaurantName = parts[3];
            Dish dish = new Dish(name, price, restaurantName);
            dishes.add(dish);
            input = scanner.nextLine();
        }

        String restaurantName = scanner.nextLine();

        for (Dish dish : dishes) {
            if (dish.getSource().equals(restaurantName)) {
                System.out.println(dish.getResult());
            }
        }
        }
    }
}