import java.io.*;
import java.util.*;
import java.math.*;

public class KTCOBAN016 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            StringBuilder ones = new StringBuilder(n);

            if (n % 2 == 0) {
                if (n % 4 == 0) {
                    if (n % 8 == 0) {
                        for (int i = 0; i < n / 8; i++) {
                            ones.append("11111111");
                        }
                    } else {
                        for (int i = 0; i < n / 4; i++) {
                            ones.append("1111");
                        }
                    }
                } else {
                    for (int i = 0; i < n / 2; i++) {
                        ones.append("11");
                    }
                }
            }
            else {
                ones.append("1");
                if ((n - 1) % 4 == 0) {
                        if ((n - 1) % 8 == 0) {
                            for (int i = 0; i < (n - 1) / 8; i++) {
                                ones.append("11111111");
                            }
                        } else {
                            for (int i = 0; i < (n - 1) / 4; i++) {
                                ones.append("1111");
                            }
                        }
                    } else {
                        for (int i = 0; i < (n - 1) / 2; i++) {
                            ones.append("11");
                        }
                    }
            }
            BigInteger s = new BigInteger(ones.toString());
            output.append(s.multiply(s)).append("\n");
        }

        System.out.println(output);
    }
}