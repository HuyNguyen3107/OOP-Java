import java.util.*;

class Song {
    String name;
    String author;
    int duration; // in seconds

    public Song(String name, String author, int duration) {
        this.name = name;
        this.author = author;
        this.duration = duration;
    }

    public boolean equals(Song song) {
        return this.name.equals(song.name) && this.author.equals(song.author) && this.duration == song.duration;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < t; i++) {
            String song1 = scanner.nextLine();
            String song2 = scanner.nextLine();
            String[] song1Details = song1.split(" ");
            String[] song2Details = song2.split(" ");

            Song s1 = new Song(song1Details[0], song1Details[1], Integer.parseInt(song1Details[2]));
            Song s2 = new Song(song2Details[0], song2Details[1], Integer.parseInt(song2Details[2]));

            System.out.println(s1.equals(s2));
        }
    }
}