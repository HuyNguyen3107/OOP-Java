import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class Warehouse {
    private HashMap<String, Integer> stock;
    private HashMap<String, Integer> prices;

    public Warehouse() {
        this.stock = new HashMap<>();
        this.prices = new HashMap<>();
    }

    public void addProduct(String product, int price, int stock) {
        this.stock.put(product, stock);
        this.prices.put(product, price);
    }

    public int price(String product) {
        return this.prices.getOrDefault(product, -99);
    }

    public int stock(String product) {
        return this.stock.getOrDefault(product, 0);
    }

    public boolean take(String product) {
        if (this.stock.containsKey(product) && this.stock.get(product) > 0) {
            this.stock.put(product, this.stock.get(product) - 1);
            return true;
        }
        return false;
    }

    public Set<String> products() {
        return new HashSet<>(this.stock.keySet());
    }
}


public class Main {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        
        // Thêm sản phẩm vào kho
        warehouse.addProduct("milk", 3, 10);
        warehouse.addProduct("coffee", 5, 6);
        warehouse.addProduct("buttermilk", 2, 2);
        warehouse.addProduct("yogurt", 2, 20);
        
        // Lấy sản phẩm khỏi kho
        warehouse.take("buttermilk");
        warehouse.take("milk");
        warehouse.take("buttermilk");
        
        // In danh sách sản phẩm còn tồn kho
        for (String product : warehouse.products()) {
            if (warehouse.stock(product) > 0) {
                System.out.println(product);
            }
        }
    }
}