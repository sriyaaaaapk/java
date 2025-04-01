package javasem;
import java.util.*;

public class SentenceParser {

    // Method to check if a number is prime
    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // Method to extract numbers from a sentence without using regex
    public static List<Integer> extractNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();
        StringBuilder currentNumber = new StringBuilder();

        for (char ch : input.toCharArray()) {
            if (Character.isDigit(ch) || ch == '-') {
                currentNumber.append(ch); // Accumulate digits
            } else if (currentNumber.length() > 0) {
                numbers.add(Integer.parseInt(currentNumber.toString()));
                currentNumber.setLength(0); // Reset StringBuilder for next number
            }
        }

        // Add the last number if the sentence ends with a number
        if (currentNumber.length() > 0) {
            numbers.add(Integer.parseInt(currentNumber.toString()));
        }

        return numbers;
    }

    // Method to find prime numbers in the sentence
    public static List<Integer> findPrimeNumbers(String sentence) {
        List<Integer> primes = new ArrayList<>();
        List<Integer> numbers = extractNumbers(sentence);
        for (int num : numbers) {
            if (isPrime(num)) {
                primes.add(num);
            }
        }
        return primes;
    }

    // Method to extract and format dates (simple format check)
    public static List<String> extractAndFormatDates(String sentence) {
        List<String> formattedDates = new ArrayList<>();
        StringBuilder currentDate = new StringBuilder();

        for (char ch : sentence.toCharArray()) {
            if (Character.isDigit(ch) || ch == '-' || ch == '/') {
                currentDate.append(ch);
            } else {
                if (currentDate.length() == 10) {
                    String date = currentDate.toString();
                    // Check if it's a date format (DD-MM-YYYY or YYYY/MM/DD)
                    if ((date.charAt(2) == '-' && date.charAt(5) == '-') || (date.charAt(4) == '/')) {
                        if (date.charAt(2) == '-') {
                            formattedDates.add(date.substring(6) + "-" + date.substring(3, 5) + "-" + date.substring(0, 2));
                        } else {
                            formattedDates.add(date.replace("/", "-"));
                        }
                    }
                    currentDate.setLength(0); // Reset
                }
            }
        }

        return formattedDates;
    }

    // Method to extract and sort numbers (integers and decimals)
    public static List<Double> extractAndSortNumbers(String input) {
        List<Double> numbers = new ArrayList<>();
        StringBuilder currentNumber = new StringBuilder();

        for (char ch : input.toCharArray()) {
            if (Character.isDigit(ch) || ch == '.' || ch == '-') {
                currentNumber.append(ch); // Accumulate characters for numbers
            } else if (currentNumber.length() > 0) {
                try {
                    numbers.add(Double.parseDouble(currentNumber.toString())); // Parse the accumulated number
                } catch (NumberFormatException e) {
                    // Handle error in case of malformed numbers (shouldn't happen)
                }
                currentNumber.setLength(0); // Reset StringBuilder for next number
            }
        }

        // Add the last number if the sentence ends with a number
        if (currentNumber.length() > 0) {
            try {
                numbers.add(Double.parseDouble(currentNumber.toString()));
            } catch (NumberFormatException e) {
                // Handle malformed number (e.g., when it's empty or corrupted)
            }
        }

        Collections.sort(numbers); // Sort the list of numbers
        return numbers;
    }

    public static void main(String[] args) {
        // Test cases

        String sentence1 = "The prime numbers are 7, 12, 19, 24, and 31!";
        System.out.println("Prime Numbers: " + findPrimeNumbers(sentence1));

        String sentence2 = "The dates are 23-04-2025 and 2024/03/15.";
        System.out.println("Formatted Dates: " + extractAndFormatDates(sentence2));

        String sentence3 = "The temperatures were 32.5, 15.6, and 5/2.";
        System.out.println("Sorted Numbers: " + extractAndSortNumbers(sentence3));
    }
}
