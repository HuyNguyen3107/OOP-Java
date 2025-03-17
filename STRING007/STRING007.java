import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Đọc số lượng chuỗi cần kiểm tra
        int n = scanner.nextInt();
        scanner.nextLine(); // Đọc bỏ dòng trống sau số n
        
        // Duyệt qua từng chuỗi
        for (int i = 0; i < n; i++) {
            String sentence = scanner.nextLine();
            boolean result = isPangram(sentence);
            System.out.println(result);
        }
        
        scanner.close();
    }
    
    public static boolean isPangram(String sentence) {
        // Tạo một mảng boolean để đánh dấu sự xuất hiện của mỗi chữ cái
        boolean[] marked = new boolean[26];
        
        // Duyệt qua từng ký tự trong chuỗi
        for (char c : sentence.toLowerCase().toCharArray()) {
            // Kiểm tra nếu ký tự là chữ cái tiếng Anh
            if (c >= 'a' && c <= 'z') {
                // Đánh dấu chữ cái đã xuất hiện
                marked[c - 'a'] = true;
            }
        }
        
        // Kiểm tra xem tất cả các chữ cái đã được đánh dấu chưa
        for (boolean present : marked) {
            if (!present) {
                return false;
            }
        }
        
        return true;
    }
}