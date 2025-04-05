import java.util.*;

class Amount {
    private String currency;
    private int amount;

    public Amount(String currency, int amount) {
        this.currency = currency;
        this.amount = amount;
    }

    public int add(Amount amount) {
        if (!this.currency.equals(amount.currency)) {
            throw new IllegalArgumentException("Currency doesn't match");
        }
        return this.amount + amount.amount;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());

        while(t-- > 0) {
            String[] input = scanner.nextLine().split(" ");
            String currency1 = input[0];
            int amount1 = Integer.parseInt(input[1]);
            String currency2 = input[2];
            int amount2 = Integer.parseInt(input[3]);

            Amount a1 = new Amount(currency1, amount1);
            Amount a2 = new Amount(currency2, amount2);

            try {
                System.out.println(a1.add(a2));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}