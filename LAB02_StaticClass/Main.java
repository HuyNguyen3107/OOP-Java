import java.util.*;

public class Main {
    public static class Account {
        private String id;
        private String ten;
        private int soDu;

        public Account(String id, String ten, int soDu) {
            this.id = id;
            this.ten = ten;
            this.soDu = soDu;
        }

        public void rut(int soTien) {
            if (soTien <= soDu) {
                soDu -= soTien;
            }
        }

        public void nap(int soTien) {
            soDu += soTien;
        }

        public void chuyen(Account to, int soTien) {
            if (soTien <= soDu) {
                this.soDu -= soTien;
                to.soDu += soTien;
            }
        }

        @Override
        public String toString() {
            return "[" + id + ", " + ten + ", " + soDu + "]";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        while (t-- > 0) {
            Map<String, Account> map = new LinkedHashMap<>(); // preserve order
            String[] tokens = sc.nextLine().trim().split(" ");
            int index = 0;
            int n = Integer.parseInt(tokens[index++]);

            int count = 0;
            while (count < n) {
                StringBuilder tenBuilder = new StringBuilder();
                while (index < tokens.length && !isNumber(tokens[index])) {
                    tenBuilder.append(tokens[index++]).append(" ");
                }
                String ten = tenBuilder.toString().trim();
                if (index >= tokens.length) break; // đề phòng lỗi thiếu dữ liệu
                int soDu = Integer.parseInt(tokens[index++]);
                String id = String.format("%03d", count + 1);
                map.put(id, new Account(id, ten, soDu));
                count++;
            }

            String[] ops = sc.nextLine().trim().split(" ");
            index = 0;
            int m = Integer.parseInt(ops[index++]);

            for (int i = 0; i < m; i++) {
                String cmd = ops[index++];
                if (cmd.equals("rut")) {
                    String id = ops[index++];
                    int tien = Integer.parseInt(ops[index++]);
                    if (map.containsKey(id)) map.get(id).rut(tien);
                } else if (cmd.equals("nap")) {
                    String id = ops[index++];
                    int tien = Integer.parseInt(ops[index++]);
                    if (map.containsKey(id)) map.get(id).nap(tien);
                } else if (cmd.equals("chuyen")) {
                    String from = ops[index++];
                    String to = ops[index++];
                    int tien = Integer.parseInt(ops[index++]);
                    if (map.containsKey(from) && map.containsKey(to)) {
                        map.get(from).chuyen(map.get(to), tien);
                    }
                }
            }

            for (String id : map.keySet()) {
                System.out.print(map.get(id).toString());
            }
            System.out.println();
        }
    }

    private static boolean isNumber(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
