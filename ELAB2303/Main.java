class MyStuff {
    private String name;

    MyStuff(String name) {
        this.name = name;
    }

    
    public boolean equals(MyStuff obj) {
       return this.name.equals(obj.name);
    }
}
public class Main {
    public static void main(String[] args) {
        MyStuff m1 = new MyStuff("PC");
        MyStuff m2 = new MyStuff("PC");
        
        // a.
        if (m2.equals(m1))
            System.out.println("value compared: same");
        else
            System.out.println("reference compared: different");

        // b. Viết thêm code vào dấu ...
        if (m2 == m1)
            System.out.println("value compared: same");
        else
            System.out.println("reference compared: different");
    }
}