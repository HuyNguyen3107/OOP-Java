import java.util.Scanner;

public class STRING007 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine(); 
        for (int i = 0; i < n; i++) {
            String sentence = scanner.nextLine();
            boolean result = isPangram(sentence);
            System.out.println(result);
        }
        
    }
    
    public static boolean isPangram(String sentence) {
        boolean[] marked = new boolean[26];
        for (char c : sentence.toLowerCase().toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                marked[c - 'a'] = true;
            }
        }
        for (boolean present : marked) {
            if (!present) {
                return false;
            }
        }
        return true;
    }
}