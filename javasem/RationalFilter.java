package javasem;

import java.util.*;

class Rational {
    int num, den;

    public Rational(int num, int den) {
        if (den == 0) throw new ArithmeticException("Denominator cannot be zero");
        this.num = num;
        this.den = den;
        simplify();
    }

    private void simplify() {
        int gcd = gcd(num, den);
        num /= gcd;
        den /= gcd;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public double toDecimal() {
        return (double) num / den; // Convert to decimal
    }

    @Override
    public String toString() {
        return num + "/" + den;
    }
}

/*public class RationalFilter {
    public static void main(String[] args) {
        List<Rational> rationals = Arrays.asList(
            new Rational(1, 3),
            new Rational(3, 4),
            new Rational(5, 10),
            new Rational(2, 5),
            new Rational(7, 8),
            new Rational(1, 2)
        );

        System.out.println("Rationals greater than 1/2:");

        // Loop correctly placed inside main
        for (int i = 0; i < rationals.size(); i++) {
            double n = rationals.get(i).toDecimal();
            if (n > 0.5) {
                System.out.println(rationals.get(i));
            }
        }
    }*/
    
    public class RationalFilter {
        public static void main(String[] args) {
            HashMap<String, Rational> discounts = new HashMap<>();
            discounts.put("Customer A", new Rational(1, 5));  // 20% discount
            discounts.put("Customer B", new Rational(2, 10)); // 20% discount
            discounts.put("Customer C", new Rational(3, 4));  // 75% discount

            System.out.println("Customers with more than 50% discount:");
            for (String customer : discounts.keySet()) {
                if (discounts.get(customer).toDecimal() > 0.5) {
                    System.out.println(customer + " -> " + discounts.get(customer));
                }
            }
        }
    }

