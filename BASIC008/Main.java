import java.util.*;

public class  Main {
    public static void main(String[] args) {
        System.out.println("Numbers between 100 and 200, divisible by 9:");
        int count = 0;
        for (int i = 100; i <= 200; i++) {
            if (i % 9 == 0) {
                System.out.println(i);
                count += i;
            }
        }
        System.out.println(count);
    }
}   