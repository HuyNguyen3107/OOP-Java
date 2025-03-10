import java.util.*;

public class KTCOBAN003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Số lượng test case
        
        while (t-- > 0) {
            long L = sc.nextLong();
            long R = sc.nextLong();

            long start = (long) Math.ceil(Math.sqrt(L)); // Căn bậc hai nhỏ nhất trong phạm vi
            long end = (long) Math.floor(Math.sqrt(R)); // Căn bậc hai lớn nhất trong phạm vi

            System.out.println(Math.max(0, end - start + 1));
        }
    }
}
