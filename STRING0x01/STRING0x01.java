import java.util.*;
import java.io.*;

public class STRING0x01 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String line = br.readLine();
            String child = line.split(", parent = ")[0].replace("child = ", "").replace("\"", "").trim();
            String parent = line.split(", parent = ")[1].replace("\"", "").trim();

            if (child.isEmpty()) {
                sb.append("0\n");
            } else {
                sb.append(parent.indexOf(child)).append("\n");
            }
        }
        System.out.println(sb);
    }
}