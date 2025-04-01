package javasem;
public class FractionConverter {

    // Method to convert improper fraction to mixed fraction
    public static String improperToMixed(int numerator, int denominator) {
        if (denominator == 0) {
            return "Denominator cannot be zero!";
        }

        // Whole number part
        int wholeNumber = numerator / denominator;
        // Fractional part (remainder)
        int remainder = numerator % denominator;

        if (remainder == 0) {
            return String.valueOf(wholeNumber); // Just the whole number if no remainder
        }

        return wholeNumber + " " + Math.abs(remainder) + "/" + Math.abs(denominator); // Return as mixed fraction
    }

    // Method to convert mixed fraction to improper fraction
    public static String mixedToImproper(int wholeNumber, int numerator, int denominator) {
        if (denominator == 0) {
            return "Denominator cannot be zero!";
        }

        // Improper fraction = (whole number * denominator) + numerator
        int improperNumerator = (wholeNumber * denominator) + numerator;
        return improperNumerator + "/" + denominator;
    }

    // Method to extract fractions from a string manually (without regex)
    public static String extractAndConvertFractions(String input) {
        StringBuilder currentNumber = new StringBuilder();
        int numerator = 0, denominator = 0;
        int wholeNumber = 0;
        boolean isFraction = false;
        boolean isMixedFraction = false;

        // Extract numbers from the sentence
        for (char ch : input.toCharArray()) {
            if (Character.isDigit(ch) || ch == '-') {
                currentNumber.append(ch);  // Accumulate digits
            } else if (ch == '/') {
                if (currentNumber.length() > 0) {
                    numerator = Integer.parseInt(currentNumber.toString());
                    currentNumber.setLength(0); // Reset after the numerator
                    isFraction = true;
                }
            } else if (ch == ' ' || ch == '.') {
                if (isFraction && currentNumber.length() > 0) {
                    denominator = Integer.parseInt(currentNumber.toString());
                    isFraction = false;

                    // Convert improper to mixed fraction
                    String mixed = improperToMixed(numerator, denominator);
                    return "Improper Fraction: " + numerator + "/" + denominator + " => Mixed Fraction: " + mixed;
                }
            }
        }

        return "No fraction found!";
    }

    public static void main(String[] args) {
        // Example sentences for conversion
        String improperFractionString = "The improper fraction is 7/3.";
        String mixedFractionString = "The mixed fraction is 2 1/3.";

        // Convert improper fraction to mixed fraction
        System.out.println(extractAndConvertFractions(improperFractionString));

        // Convert mixed fraction to improper fraction
        System.out.println(mixedToImproper(2, 1, 3));  // "2 1/3" => "7/3"
    }
}

