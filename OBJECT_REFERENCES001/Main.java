import java.util.*;

class SimpleDate {
    private String day;
    private String month;
    private String year;

    public SimpleDate(String day, String month, String year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public SimpleDate(String day) {
        this.day = day;
        this.month = "";
        this.year = "";
    }

    public String getDay() {
        return this.day;
    }

    public String getMonth() {
        return this.month;
    }

    public String getYear() {
        return this.year;
    }

    public boolean equals(SimpleDate simpleDate) {
        if (simpleDate instanceof SimpleDate) {
            if (this.day == simpleDate.getDay() && this.month == simpleDate.getMonth() && this.year == simpleDate.getYear()) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        SimpleDate sd = new SimpleDate("1", "2", "2000");
        SimpleDate ex1 = new SimpleDate("heh");
        SimpleDate ex2 = new SimpleDate("5", "2", "2012");
        SimpleDate ex3 = new SimpleDate("1", "2", "2000");

        System.out.println(sd.equals(ex1));
        System.out.println(sd.equals(ex2));
        System.out.println(sd.equals(ex3));
    }
}