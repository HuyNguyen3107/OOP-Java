import java.util.Scanner;

public class BASIC006 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim()); // Đọc số lượng test case

        for (int i = 0; i < n; i++) {
            String s = sc.nextLine(); // Đọc dòng dữ liệu đầu vào
            System.out.println(countDigits(s)); // Đếm số ký tự là chữ số và in kết quả
        }

        sc.close();
    }

    public static int countDigits(String s) {
        int count = 0;
        for (char c : s.toCharArray()) { // Duyệt từng ký tự trong chuỗi
            if (Character.isDigit(c)) { // Kiểm tra ký tự có phải số không
                count++;
            }
        }
        return count;
    }
}