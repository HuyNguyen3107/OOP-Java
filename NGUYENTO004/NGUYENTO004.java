import java.io.*;

public class NGUYENTO004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int t = Integer.parseInt(br.readLine().trim()); // Số lượng test case
        
        while (t-- > 0) {
            long n = Long.parseLong(br.readLine().trim());
            long largestPrime = -1;

            // Bước 1: Loại bỏ tất cả ước số 2
            while (n % 2 == 0) {
                largestPrime = 2;
                n /= 2;
            }

            // Bước 2: Kiểm tra các số lẻ từ 3 đến sqrt(n)
            for (long i = 3; i * i <= n; i += 2) {
                while (n % i == 0) {
                    largestPrime = i;
                    n /= i;
                }
            }

            // Bước 3: Nếu sau cùng n > 1, thì n là số nguyên tố lớn nhất
            if (n > 1) {
                largestPrime = n;
            }

            sb.append(largestPrime).append("\n");
        }
        
        System.out.print(sb);
    }
}
