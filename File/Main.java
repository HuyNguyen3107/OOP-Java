import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("./filereader-in.txt");
            int c;
            while ((c = fileReader.read()) != -1) {
                System.out.println((char) c);
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());          
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}