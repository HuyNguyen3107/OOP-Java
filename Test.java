import java.util.*;

interface DBConnection {
    void connect();
}

class MysqlConnectionDemo implements DBConnection {
    public void connect() {
        System.out.println("MySQL connected");
    }
}

class OracleConnectionDemo implements DBConnection {
    public void connect() {
        System.out.println("Oracle connected");
    }
}

class PostgresConnectionDemo implements DBConnection {
    public void connect() {
        System.out.println("Postgres connected");
    }
}

class MongoDBConnectionDemo implements DBConnection {
    public void connect() {
        System.out.println("MongoDB connected");
    }
}

class StudentManager {
    private DBConnection connection;
    public StudentManager(DBConnection connection) {
        this.connection = connection;
    }

    // SELECT * FROM students
    public void list() {
        //1: connect to database
        this.connection.connect();
        // 2: create a query
        System.out.println("SELECT * FROM students");
    }
}

class CourseManager {
    private DBConnection connection;

    public CourseManager(DBConnection connection) {
        this.connection = connection;
    }

    // SELECT * FROM courses
    public void list() {
        //1: connect to database
        this.connection.connect();
        // 2: create a query
        System.out.println("SELECT * FROM courses");
    }
}

public class Test {
    public static void main(String[] args) {
        // 1: create a connection to the database
        DBConnection connection = new MongoDBConnectionDemo();
        // 2: create a student manager
        StudentManager studentManager = new StudentManager(connection);
        // 3: create a course manager
        CourseManager courseManager = new CourseManager(connection);
        // 4: list students and courses
        studentManager.list();
        courseManager.list();
    }
}