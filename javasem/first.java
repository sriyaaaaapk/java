package javasem;

public class first {
    static int duplicateCount(String text) {
        String input = text.toLowerCase(); // Convert to lowercase for case insensitivity
        int[] charCounts = new int[36]; // 26 for 'a-z' + 10 for '0-9'

        // Count occurrences of each character
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                charCounts[c - 'a']++; // Store counts for letters
            } else if (Character.isDigit(c)) {
                charCounts[c - '0' + 26]++; // Store counts for digits in a separate index range
            }
        }

        // Count characters that appear more than once
        int count = 0;
        for (int frequency : charCounts) {
            if (frequency > 1) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String st = "sriyaa";
        System.out.println("Duplicate character count: " + duplicateCount(st)); 
    }
}
