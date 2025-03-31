package Collections;
import java.util.*;

public class prime {
    static ArrayList<Integer> A1 = new ArrayList<>(); //static allows it to be accessed inside main() without creating an object.
    // Constructor to initialize prime numbers
    prime() {
        int l = 2;
        while (A1.size() < 15) {
            if (isPrime(l)) A1.add(l);
            l++;
        }
    }

    // Check if a number is prime
    static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) { // More optimized loop
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        new prime(); // Calls constructor to fill A1 with 15 prime numbers
        System.out.println("Initial Prime List: " + A1); 
        
        A1.add(2, 4); // Insert 4 at index 2
        System.out.println("After Adding 4 at Index 2: " + A1); 
        
        A1.set(2, 3); // Replace value at index 2 with 3
        System.out.println("After Replacing Index 2 with 3: " + A1); 
        
        A1.removeIf(x -> x < 5 || x > 20); // Remove numbers <5 or >20
        Collections.sort(A1); // Sort the list
        System.out.println("After Filtering and Sorting: " + A1);
    }
}
