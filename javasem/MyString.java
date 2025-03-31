package javasem;

public class MyString {
    private String text;
    private String encryptedText; // Store encrypted text separately

    // Constructor
    public MyString(String text) {
        this.text = text;
    }

    // Encrypt method (shifts each letter by n positions in ASCII table)
    public String encrypt(int shift) {
        StringBuilder encrypted = new StringBuilder();
        for (char c : text.toCharArray()) {
            encrypted.append((char) (c + shift));
        }
        encryptedText = encrypted.toString(); // Store encrypted text
        return encryptedText;
    }

    // Decrypt method (shifts back each letter by n positions in ASCII table)
    public String decrypt(int shift) {
        StringBuilder decrypted = new StringBuilder();
        for (char c : encryptedText.toCharArray()) { // Use encrypted text
            decrypted.append((char) (c - shift));
        }
        return decrypted.toString();
    }

    public static void main(String[] args) {
        MyString myStr = new MyString("hello");
        int shift = 3;

        String encrypted = myStr.encrypt(shift);
        System.out.println("Encrypted: " + encrypted); // khoor

        String decrypted = myStr.decrypt(shift);
        System.out.println("Decrypted: " + decrypted); // hello
    }
}

//A-->65
//a--> 97
//char character = (char) num; // Convert ASCII to char
//int asciiValue = (int) ch; // Convert to ASCII
