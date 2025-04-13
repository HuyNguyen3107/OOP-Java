import java.util.*;

class Item {
    private String name;
    private double price;
    private double discount;

    public Item(String name, double price, double discount) {
        this.name = name;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscount() {
        return discount;
    }
    public String toString() {
        return name + " $" + String.format("%.2f", price) + " (-$" + String.format("%.2f", discount) + ")";
    }
}

class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class GroceryBill {
    private Employee clerk;
    private List<Item> receipt = new ArrayList<>();
    private double total = 0.0;

    public GroceryBill(Employee clerk) {
        this.clerk = clerk;
    }

    public void add(Item item) {
        receipt.add(item);
        total += item.getPrice() - item.getDiscount();
    }

    public double getTotal() {
        return total;
    }
    public Employee getClerk() {
        return clerk;
    }

    public List<Item> getReceipt() {
        return receipt;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("items:\n");
        for (Item item : receipt) {
            sb.append("   ").append(item.toString()).append("\n");
        }
        sb.append("total: $").append(String.format("%.2f", total)).append("\n");
        sb.append("Clerk: ").append(clerk.getName());
        return sb.toString();
    }
}

class DiscountBill extends GroceryBill {
    private double discountAmount = 0.0;

    public DiscountBill(Employee clerk) {
        super(clerk);
    }

    @Override
    public void add(Item item) {
        super.add(item);
        discountAmount += item.getDiscount();
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("items:\n");
        for (Item item : getReceipt()) {
            sb.append("   ").append(item.toString()).append("\n");
        }
        sb.append("sub-total: $").append(String.format("%.2f", getTotal() + discountAmount)).append("\n");
        sb.append("discount: $").append(String.format("%.2f", discountAmount)).append("\n");
        sb.append("total: $").append(String.format("%.2f", getTotal())).append("\n");
        sb.append("Clerk: ").append(getClerk().getName());
        return sb.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Employee clerk1 = new Employee("Grocery Bill");
        GroceryBill bill1 = new GroceryBill(clerk1);

        bill1.add(new Item("item 1", 2.3, 0));   
        bill1.add(new Item("item 2", 3.45, 0));

        System.out.println(bill1.toString());
        System.out.println("");

        Employee clerk2 = new Employee("Discount Bill");
        DiscountBill bill2 = new DiscountBill(clerk2);

        bill2.add(new Item("item 3", 20, 15));
        bill2.add(new Item("item 4", 40, 35));
        bill2.add(new Item("item 5", 50, 35));

        System.out.println(bill2.toString());
    }
}