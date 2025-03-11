import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Đọc số test case
        
        StringBuilder output = new StringBuilder(); // Dùng StringBuilder để tăng tốc độ xuất
        
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim()); // Đọc n
            int[] arr = new int[n];

            // Khởi tạo tập hợp {1, 2, ..., n}
            for (int i = 0; i < n; i++) {
                arr[i] = i + 1;
            }

            // Liệt kê tất cả hoán vị theo thứ tự từ điển
            do {
                printArray(arr, output);
            } while (nextPermutation(arr));
        }

        // In toàn bộ output ra một lần
        System.out.print(output);
    }

    // Hàm in mảng ra màn hình đúng định dạng
    public static void printArray(int[] arr, StringBuilder output) {
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                output.append(arr[i]);
            } else {
                output.append(arr[i]).append(" ");
            }
        }
        output.append("\n");
    }

    // Hàm sinh hoán vị kế tiếp theo thứ tự từ điển
    public static boolean nextPermutation(int[] arr) {
        int i = arr.length - 2;

        // Tìm phần tử đầu tiên từ cuối dãy giảm dần
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }

        // Nếu không tìm thấy, nghĩa là đã là hoán vị cuối
        if (i < 0) {
            return false;
        }

        // Tìm phần tử lớn hơn arr[i] ở cuối dãy
        int j = arr.length - 1;
        while (arr[j] <= arr[i]) {
            j--;
        }

        // Hoán đổi arr[i] và arr[j]
        swap(arr, i, j);

        // Đảo ngược đoạn cuối để đạt hoán vị nhỏ nhất tiếp theo
        reverse(arr, i + 1, arr.length - 1);

        return true;
    }

    // Hàm hoán đổi hai phần tử trong mảng
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Hàm đảo ngược đoạn từ l đến r trong mảng
    public static void reverse(int[] arr, int l, int r) {
        while (l < r) {
            swap(arr, l, r);
            l++;
            r--;
        }
    }
}
