import java.util.*;

class Money {
    private int euros;
    private int cent;

    public Money(int euros, int cent) {
        this.euros = euros;
        this.cent = cent;
    }

    public Money plus(Money added) {
        int totalEuros = this.euros + added.euros;
        int totalCents = this.cent + added.cent;

        return new Money(totalEuros, totalCents); 
    }

    public boolean lessThan(Money compared) {
        if (this.euros < compared.euros) {
            return true;
        } else if (this.euros == compared.euros && this.cent < compared.cent) {
            return true;
        }
        return false;
    }

    public Money minus(Money decremented) {
        if (this.lessThan(decremented)) {
            return new Money(0, 0); // Return zero if decremented is greater
        }
        if (this.euros == decremented.euros && this.cent == decremented.cent) {
            return new Money(0, 0); // Return zero if they are equal
        }

        int tempEuros = this.euros;
        int tempCents = this.cent;

        if (this.cent < decremented.cent) {
            tempEuros -= 1; // Decrease euros by 1 if cents are less
            tempCents += 100; // Add 100 cents to the current cents
        }
        int totalEuros = tempEuros - decremented.euros; // Calculate total euros
        int totalCents = tempCents - decremented.cent; // Calculate total cents

        return new Money(totalEuros, totalCents); // Return the result of the subtraction
    }

    public String toString() {
        return String.format("%d.%02de", euros, cent);
    }
}

public class Main {
    public static void main(String[] args) {
        Money a = new Money(10, 8);
        Money b = new Money(5, 5);
        // c = a + b

        Money c = a.plus(b);
        System.out.println(a.toString());
        System.out.println(b.toString());
        System.out.println(c.toString());
        Money u = new Money(10, 0);
        Money y = new Money(3, 0);
        Money w = new Money(5, 0);
        System.out.println(u.lessThan(y)); // false
        System.out.println(y.lessThan(w)); // true

        Money m = new Money(10, 0);
        Money n = new Money(3, 50);
        Money o = m.minus(n);
        System.out.println(m.toString()); // 10.00e
        System.out.println(n.toString()); // 3.50e
        System.out.println(o.toString()); // 6.50e
        o = o.minus(m); // 0.00e
        System.out.println(o.toString()); // 0.00e
    }
}