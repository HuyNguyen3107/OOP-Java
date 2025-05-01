import java.util.*;

class Product {
    String name;
    int price;
    int stock;

    public Product(String name, int price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    @Override
    public String toString() {
        return name + " " + price + " " + stock;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        List<Product> products = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(" ");
            String name = parts[0];
            int price = Integer.parseInt(parts[1]);
            int stock = Integer.parseInt(parts[2]);
            products.add(new Product(name, price, stock));
        }

        String criteria = sc.nextLine();

        switch (criteria) {
            case "BY_NAME":
                products.sort(Comparator.comparing(p -> p.name));
                break;

            case "BY_PRICE":
                products.sort(Comparator.comparingInt((Product p) -> p.price)
                        .thenComparing(p -> p.name));
                break;

            case "BY_STOCK":
                products.sort(Comparator.comparingInt((Product p) -> -p.stock)
                        .thenComparing(p -> p.name));
                break;
        }

        for (Product p : products) {
            System.out.println(p);
        }
    }
}
