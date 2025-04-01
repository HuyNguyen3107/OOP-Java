import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        while(t-- > 0) {
            String[] arr = sc.nextLine().split(" ");
            Map<String, Integer> map = new HashMap<>();
            Map<String, Integer> results = new HashMap<>();

            for (int i = 0; i < arr.length; i += 2) {
                map.put(arr[i], Integer.parseInt(arr[i + 1]));
            }

            for (String key : map.keySet()) {
                String value = map.get(key) + "";
                if (results.containsKey(value)) {
                    results.put(value, results.get(value) + 1);
                } else {
                    results.put(value, 1);
                }
                
            }

            int min = Integer.MAX_VALUE;
            int minKey = Integer.MAX_VALUE;

            for (String key : results.keySet()) {
                if (results.get(key) < min) {
                    min = results.get(key);
                    minKey = Integer.parseInt(key);
                } else if (results.get(key) == min) {
                    minKey = Math.min(minKey, Integer.parseInt(key));
                }
            }

            System.out.println(minKey);
        }
    }
}