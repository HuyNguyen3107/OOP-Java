import java.util.*;

class Item {
    private String product;
    private int quantity;
    private int unitPrice;

    public Item(String product, int quantity, int unitPrice) {
        this.product = product;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public String getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void reduceQuantity(int amount) {
        this.quantity = Math.max(this.quantity - amount, 0);
    }

    public void increaseQuantity(int amount) {
        this.quantity += amount;
    }

    public void printInfo() {
        System.out.println("Product: " + product + " has quantity " + quantity + " with price: " + (quantity * unitPrice));
    }
}

class Warehouse {
    private Map<String, Integer> warehouseStock;
    private Map<String, Item> items;

    public Warehouse() {
        this.warehouseStock = new HashMap<>();
        this.items = new HashMap<>();
    }

    public void  importItem(Item item) {
        items.put(item.getProduct(), item);
        warehouseStock.put(item.getProduct(), 0);
    }

    public void addProduct(String product, int quantity) {
        if (items.containsKey(product)) {
            Item item = items.get(product);
            int available = item.getQuantity();
            int toAdd = Math.min(quantity, available);
            item.reduceQuantity(toAdd);
            warehouseStock.put(product, warehouseStock.get(product) + toAdd);
        }
    }

    public void increaseItemInWarehouseByOne() {
        for (String product : warehouseStock.keySet()) {
            Item item = items.get(product);
            if (item.getQuantity() > 0) {
                item.reduceQuantity(1);
                warehouseStock.put(product, warehouseStock.get(product) + 1);
            }
        }
    }

    public void takeToItem(String product, int quantity) {
        if (warehouseStock.containsKey(product)) {
            int available = warehouseStock.get(product);
            int toTake = Math.min(available, quantity);
            warehouseStock.put(product, available - toTake);
            items.get(product).increaseQuantity(toTake);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // (1) Tạo 2 Item
        Item milk = new Item("milk", 4, 2);
        Item buttermilk = new Item("buttermilk", 10, 2);
        milk.printInfo();
        buttermilk.printInfo();

        // (2) Thêm 2 items vào Warehouse
        Warehouse warehouse = new Warehouse();
        warehouse.importItem(milk);
        warehouse.importItem(buttermilk);

        // (3) Thêm sản phẩm vào kho
        warehouse.addProduct("milk", 1);
        warehouse.addProduct("buttermilk", 3);
        milk.printInfo();
        buttermilk.printInfo();

        // (4) Tăng số lượng sản phẩm trong kho
        warehouse.increaseItemInWarehouseByOne();
        milk.printInfo();
        buttermilk.printInfo();

        // (5) Rút sản phẩm từ kho về lại Item
        warehouse.takeToItem("milk", 5);
        warehouse.takeToItem("buttermilk", 1);
        milk.printInfo();
        buttermilk.printInfo();
    }
}