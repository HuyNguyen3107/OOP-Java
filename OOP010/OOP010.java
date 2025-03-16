class Product {
    private String name;
    private String location;
    private int weight;

    // Constructor 1: Chỉ có tên, location mặc định là "shelf", weight mặc định là 1
    public Product(String name) {
        this.name = name;
        this.location = "shelf";
        this.weight = 1;
    }

    // Constructor 2: Có tên và vị trí, weight mặc định là 1
    public Product(String name, String location) {
        this.name = name;
        this.location = location;
        this.weight = 1;
    }

    // Constructor 3: Có tên và trọng lượng, location mặc định là "shelf"
    public Product(String name, int weight) {
        this.name = name;
        this.location = "shelf";
        this.weight = weight;
    }

    // Phương thức toString() để hiển thị thông tin sản phẩm
    @Override
    public String toString() {
        return name + " (" + weight + "kg) can be found from the " + location;
    }
}

public class OOP010 {
    public static void main(String[] args) {
        // Tạo các đối tượng theo đề bài
        Product p1 = new Product("Tape measure");
        Product p2 = new Product("Plaster", "home improvement section");
        Product p3 = new Product("Tyre", 5);

        // In ra kết quả
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
    }
}
