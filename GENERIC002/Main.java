import java.util.*;

public class Main {

    public static <T> int findFirstMatch(T[] array, T target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < test; i++) {
            String line = sc.nextLine();
            String[] parts = line.split("\\|");

            String[] array = parts[0].trim().split(" ");
            String target = parts[1].trim();

            // Gọi hàm generic
            int index = findFirstMatch(array, target);
            System.out.println(index);
        }
    }
}
