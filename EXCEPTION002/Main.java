import java.util.Scanner;

// Custom Exception
class NotJavaFileException extends Exception {
    public NotJavaFileException(String message) {
        super(message);
    }
}

public class Main {

    public static int CheckFileExtension(String fileName) throws NotJavaFileException {
        if (fileName == null || fileName.trim().isEmpty()) {
            throw new NotJavaFileException("Not java file exception.Mark is -1");
        }

        if (fileName.endsWith(".java")) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < testCases; i++) {
            String fileName = sc.hasNextLine() ? sc.nextLine() : null;

            try {
                int mark = CheckFileExtension(fileName);
                System.out.println(mark);
            } catch (NotJavaFileException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
