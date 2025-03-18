class Utils {
    public static void u(String s) throws IOException {
       
            System.out.println(s);
            z(s);
            try {
                System.out.println(Integer.parseInt(s)+1);
            } catch (Exception e) {
                System.out.println(s.toUpperCase());
            }
    }

    public static void z(String s) throws IOException {
        System.out.println(2);
        if (s.length() == 1)
            throw new IOException();
        System.out.println(3);
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            Utils.u("1");
        } catch (IOException e) {
            System.out.println("IOException");
        } catch (Exception e) {
            System.out.println("Exception");
        }
        System.out.println(4);
    }
}

// Chưa đúng nhé