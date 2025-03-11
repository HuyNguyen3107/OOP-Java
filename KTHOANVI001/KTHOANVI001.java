import java.util.*;

public class KTHOANVI001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Số test case
        while (t-- > 0) {
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            
            // Khởi tạo tập hợp {1, 2, ..., n}
            for (int i = 1; i <= n; i++) {
                list.add(i);
            }
            
            // Liệt kê tất cả hoán vị theo thứ tự từ điển
            do {
                for (int num : list) {
                    System.out.print(num + " ");
                }
                System.out.println();
            } while (nextPermutation(list));
        }
        sc.close();
    }

    // Hàm sinh hoán vị kế tiếp theo thứ tự từ điển
    public static boolean nextPermutation(List<Integer> arr) {
        int i = arr.size() - 2;

        // Tìm phần tử đầu tiên từ cuối dãy giảm dần
        while (i >= 0 && arr.get(i) >= arr.get(i + 1)) {
            i--;
        }

        // Nếu không tìm thấy, nghĩa là đã là hoán vị cuối
        if (i < 0) {
            return false;
        }

        // Tìm phần tử lớn hơn arr[i] ở cuối dãy
        int j = arr.size() - 1;
        while (arr.get(j) <= arr.get(i)) {
            j--;
        }

        // Hoán đổi arr[i] và arr[j]
        Collections.swap(arr, i, j);

        // Đảo ngược đoạn cuối để đạt hoán vị nhỏ nhất tiếp theo
        Collections.reverse(arr.subList(i + 1, arr.size()));

        return true;
    }
}
