import java.util.Scanner;

// Lớp Product
class Product {
    private String productId;
    private String name;
    private double price;

    public Product(String productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public void display() {
        System.out.printf("Sản phẩm: %s (Mã: %s)\n", name, productId);
        System.out.printf("Giá: %.1f\n", price);
    }
}

// Lớp Order
class Order {
    private String orderId;
    private Product product;
    private int quantity;

    public Order(String orderId, Product product, int quantity) {
        this.orderId = orderId;
        this.product = product;
        this.quantity = quantity;
    }

    public double calculateTotal() {
        return quantity * product.getPrice();
    }

    public void display() {
        System.out.println("--- Thông tin đơn hàng ---");
        System.out.println("Đơn hàng: " + orderId);
        product.display();
        System.out.println("Số lượng: " + quantity);
        System.out.printf("Tổng tiền: %.1f\n", calculateTotal());
    }
}

// Lớp chính
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String productId = scanner.nextLine();
        String name = scanner.nextLine();
        double price = Double.parseDouble(scanner.nextLine());
        String orderId = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());

        Product product = new Product(productId, name, price);
        Order order = new Order(orderId, product, quantity);

        order.display();
    }
}
