import java.util.*;

class FlightBooking {
    public String flightId = "OOP24";
    private static int seatAvailable = 180;
    private int userId;
    private boolean isConfirmed;

    public FlightBooking(int userId) {
        this.userId = userId;
        this.isConfirmed = false;
    }

    public static String bookSeat() {
        if (seatAvailable > 0) {
            seatAvailable--;
        }
        return "[Seat Available: " + seatAvailable + "]";
    }

    public static String cancelSeat() {
        seatAvailable++;
        return "[Seat Available: " + seatAvailable + "]";
    }

    public String confirmBooking() {
        this.isConfirmed = true;
        return "--User " + userId + " Confirmed--[Seat Available: " + seatAvailable + "]";
    }
}

public class OOP003 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        while (testCases-- > 0) {
            String[] input = scanner.nextLine().split(" ");
            StringBuilder result = new StringBuilder();
            Map<Integer, FlightBooking> bookings = new HashMap<>();

            for (int i = 0; i < input.length; i += 2) {
                int userId = Integer.parseInt(input[i]);
                String action = input[i + 1];

                switch (action) {
                    case "Booking":
                        if (!bookings.containsKey(userId)) {
                            bookings.put(userId, new FlightBooking(userId));
                        }
                        result.append(FlightBooking.bookSeat());
                        break;
                    case "Confirmed":
                        if (bookings.containsKey(userId)) {
                            result.append(bookings.get(userId).confirmBooking());
                        }
                        break;
                    case "Cancel":
                        result.append(FlightBooking.cancelSeat());
                        break;
                }
            }
            System.out.println(result.toString());
        }
        scanner.close();
    }
}
