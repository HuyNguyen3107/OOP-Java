import java.util.*;

class Note {
    private int id;
    private String rawDate;
    private String content;

    public Note(int id, String date, String content) {
        this.id = id;
        this.rawDate = date;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public String getFormattedDate() {
        String mmm = rawDate.substring(0, 3);
        String dd = rawDate.substring(3, 5);
        String yy = rawDate.substring(5);
        return dd + " " + mmm + " " + yy;
    }

    public String getRawDate() {
        return rawDate;
    }

    public String getContent() {
        return content;
    }
}

class Account {
    private static int idCounter = 1;
    private String id;
    private String name;
    private List<Note> notes = new ArrayList<>();
    private int noteCounter = 1;

    public Account(String name) {
        this.name = name;
        this.id = String.format("%03d", idCounter++);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void addNote(String date, String content) {
        notes.add(new Note(noteCounter++, date, content));
    }

    public Note getNoteById(int id) {
        for (Note n : notes) {
            if (n.getId() == id) return n;
        }
        return null;
    }

    public void shareNote(Note note) {
        // Chia sẻ: copy note nhưng phải giữ đúng rawDate (chưa định dạng lại)
        notes.add(new Note(noteCounter++, note.getRawDate(), note.getContent()));
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int n = Integer.parseInt(sc.nextLine().trim());
            if (n <= 0) throw new Exception();

            Map<String, Account> accounts = new LinkedHashMap<>();

            for (int i = 0; i < n; i++) {
                String name = sc.nextLine().trim();
                Account acc = new Account(name);
                accounts.put(acc.getId(), acc);
            }

            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split(" ", 3);
                if (parts.length < 3) throw new Exception();

                String accId = parts[0];
                String command = parts[1];
                String content = parts[2];

                Account actor = accounts.get(accId);
                if (actor == null) throw new Exception();

                if (command.equals("Add")) {
                    String[] split = content.split(" ", 2);
                    if (split.length < 2) throw new Exception();

                    String date = split[0];
                    String noteContent = split[1];

                    if (!date.matches("(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)\\d{4}"))
                        throw new Exception();

                    actor.addNote(date, noteContent);

                } else if (command.equals("Share")) {
                    String[] split = content.split(" ");
                    if (split.length != 2) throw new Exception();

                    String targetId = split[0];
                    int noteId = Integer.parseInt(split[1]);

                    Account receiver = accounts.get(targetId);
                    if (receiver == null) throw new Exception();

                    Note note = actor.getNoteById(noteId);
                    if (note == null) throw new Exception();

                    receiver.shareNote(note);
                } else {
                    throw new Exception(); // lệnh không hợp lệ
                }
            }

            for (Account acc : accounts.values()) {
                System.out.println("Account: " + acc.getName());
                for (Note note : acc.getNotes()) {
                    System.out.println(note.getFormattedDate() + " | " + note.getContent());
                }
            }
        } catch (Exception e) {
            System.out.println("invalid input");
        }
    }
}
