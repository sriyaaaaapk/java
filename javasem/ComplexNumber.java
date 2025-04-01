package javasem;
public class ComplexNumber {
    private int real;
    private int imaginary;

    // Constructor to initialize complex number
    public ComplexNumber(int real, int imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    // Method to add two complex numbers
    public ComplexNumber add(ComplexNumber other) {
        int resultReal = this.real + other.real;
        int resultImaginary = this.imaginary + other.imaginary;
        return new ComplexNumber(resultReal, resultImaginary);
    }

    // Method to display the complex number in the form a + jb
    public void display() {
        System.out.println(this.real + " + j" + this.imaginary);
    }

    // Method to extract a complex number from the string
    public static ComplexNumber extractComplexNumber(String str) {
        int realPart = 0;
        int imaginaryPart = 0;

        // Remove 'j' and split into real and imaginary parts
        str = str.replaceAll("j", "");

        // Check if '+' or '-' exists in the string to separate real and imaginary parts
        if (str.contains("+") || str.contains("-")) { //since its removing -, multiply with -1 if negative thus introduce new loop
            String[] parts = str.split("[+-]");
            // Determine the sign of the imaginary part
            if (str.contains("+")) {
                realPart = Integer.parseInt(parts[0].trim());
                imaginaryPart = Integer.parseInt(parts[1].trim());
            } else {
                realPart = Integer.parseInt(parts[0].trim());
                imaginaryPart = Integer.parseInt(parts[1].trim()) *(-1);
            }
        
        
        return new ComplexNumber(realPart, imaginaryPart);
    }

    public static void main(String[] args) {
        // Given string
        String s = "2+j3";
        // Extract complex numbers
        ComplexNumber complex1 = extractComplexNumber(s);

       

        // Display the result
        System.out.print(complex1);
        
    }
}
