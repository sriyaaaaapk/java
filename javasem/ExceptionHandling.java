package javasem;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
public class ExceptionHandling {
    private static final Set<String> RESERVED_KEYWORDS = new HashSet<>(Arrays.asList(
            "abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "const",
            "continue", "default", "do", "double", "else", "enum", "extends", "final", "finally", "float",
            "for", "goto", "if", "implements", "import", "instanceof", "int", "interface", "long", "native",
            "new", "null", "package", "private", "protected", "public", "return", "short", "static", "strictfp",
            "super", "switch", "synchronized", "this", "throw", "throws", "transient", "try", "void", "volatile",
            "while", "true", "false", "default"
    ));

    public static boolean isValidIdentifier(String identifier) {
        // Handle null input
        if (identifier == null || identifier.isEmpty()) {
            throw new IllegalArgumentException("Identifier cannot be null or empty");
        }
        if (RESERVED_KEYWORDS.contains(identifier)) {
            return false;  // It's a reserved keyword, so it's not a valid identifier
        }
        // Regex: First character must be a letter or '_', rest can include digits
        String regex = "^[a-zA-Z_][a-zA-Z0-9_]*$";
        
        // Match with regex
        return identifier.matches(regex);
    }
public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an identifier: ");
        String input = scanner.nextLine();

        try {
            if (isValidIdentifier(input)) {
                System.out.println(input + " is a valid Java identifier.");
            } else {
                System.out.println(input + " is NOT a valid Java identifier.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        scanner.close();
    }
}

/*For Strings, Java likes to play tricks on you. Here’s what you must know:

String Basics

String s = "Hello";
String s2 = new String("Hello"); // Avoid this, unnecessary memory usage
💡 Strings are immutable → Any modification creates a new object.

Common String Methods
✅ s.length() → Get length
✅ s.charAt(0) → Get character at index
✅ s.substring(1, 4) → Extract substring (1 to 3)
✅ s.indexOf('e') → Find character position
✅ s.equals("Hello") → Checks exact equality
✅ s.equalsIgnoreCase("hello") → Case-insensitive check
✅ s.toUpperCase() / s.toLowerCase() → Change case
✅ s.trim() → Removes spaces at start & end
✅ s.replace('l', 'p') → Replace characters

String vs. StringBuilder vs. StringBuffer
💀 String = Immutable (slow for modifications)
⚡ StringBuilder = Fast & mutable (best for performance)
🛡️ StringBuffer = Like StringBuilder, but thread-safe

StringBuilder sb = new StringBuilder("Hello");
sb.append(" World"); // Faster than using String concatenation
System.out.println(sb.toString());

String Comparisons
🚨 Don't use == to compare Strings, use .equals()
String a = "Hello";
String b = new String("Hello");

System.out.println(a == b); // false (checks memory location)
System.out.println(a.equals(b)); // true (checks actual content)

Reversing a String (Classic Interview Question)
String str = "hello";
String reversed = new StringBuilder(str).reverse().toString();
System.out.println(reversed); // "olleh"*/

/*
try {
// Code that might throw an exception
} catch (ExceptionType e) {
// Handle the exception
System.out.println("Something went wrong: " + e.getMessage());
} finally {
// Optional: Runs no matter what (even if there's an exception)
System.out.println("Cleanup code if needed.");
}

try {
int a = 10 / 0; // This will throw ArithmeticException
} catch (ArithmeticException e) {
System.out.println("Can't divide by zero!");
}

try {
int[] arr = new int[3];
arr[5] = 10; // Throws ArrayIndexOutOfBoundsException
} catch (ArithmeticException e) {
System.out.println("Math error!");
} catch (ArrayIndexOutOfBoundsException e) {
System.out.println("Array index out of bounds!");
}*/
