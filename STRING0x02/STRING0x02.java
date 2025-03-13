import java.util.*;
import java.io.*;

public class STRING0x02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String time = br.readLine().split(" = ")[1].replace("\"", "").trim();
            char[] chars = time.toCharArray();

            if (chars[0] == '?') {
                chars[0] = (chars[1] == '?' || chars[1] <= '3') ? '2' : '1';
            }
            if (chars[1] == '?') {
                chars[1] = (chars[0] == '2') ? '3' : '9';
            }

            // Xử lý phút
            if (chars[3] == '?') {
                chars[3] = '5';
            }
            if (chars[4] == '?') {
                chars[4] = '9';
            }
            sb.append("\"").append(new String(chars)).append("\"\n");
        }
      System.out.print(sb);
    }
}