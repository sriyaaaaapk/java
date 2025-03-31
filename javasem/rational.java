package javasem;
import java.util.Scanner;
public class rational {
	int num,den;
	rational(int num, int den){
		this.num=num;
		this.den=den;
		}
	rational(int num){
		this.num=num;
		this.den=1;
	}
	String display() {
		if (den==1) System.out.println(num);
		else if (num==0)System.out.println
		(num);
		else if(num>0 && den>0)	
			System.out.println(num+"/"+den);
		else if (num<0 && den>0)
			System.out.println(num+"/"+den);
		else if (num>0 && den<0)
			System.out.println(-num+"/"+-den);
		else if (num<0 && den<0 && den!=-1)	
			System.out.println(-num+"/"+-den);
		else if(num<0 && den==-1) 
			System.out.println(-num);
		else if (den==0)
			System.out.println("Invalid Number"); 
	return num+"/"+den;
	}
	static int hcf(int a, int b) {
		if (a<0)
			a=-a;
		if (b<0)
			b=-b;
		if (a==0) 
			return b;
		if (b==0)
			return a;
		if (a>=b) 
			return hcf(b,a%b);
		else 
			return hcf(a,b%a);
	}
	
	void reduce() {
		int gcd=hcf(num,den);
		num=num/gcd;
		den=den/gcd;
	}
	rational add(rational other) {
		rational out=new rational(0,0);
		out.num=this.num*other.den + this.den*other.num;
		out.den=this.den*other.den;
		out.reduce();
		return out;
	}
	rational sub(rational other) {
		rational out=new rational(0,0);
		out.num=this.num*other.den - this.den*other.num;
		out.den=this.den*other.den;
		out.reduce();
		return out;
	}
	rational mult(rational other) {
		rational out=new rational(0,0);
		out.num=this.num*other.num;
		out.den=this.den*other.den;
		out.reduce();
		return out;
		}
	rational div(rational other) {
		rational out=new rational(0,0);
		out.num=this.num*other.den;
		out.den=this.den*other.num;
		out.reduce();
		return out;
		}
	
	double toDecimal() {
	    return (double) num / den; // Cast to double for decimal division
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*
		// Take user input for both fractions in num/den format
        System.out.print("Enter the first signal S1 in num/den format (e.g., 3/7): ");
        String input1 = sc.nextLine();
        String[] parts1 = input1.split("/");  // Split input at "/"
        int num1 = Integer.parseInt(parts1[0]);  // First part as numerator
        int den1 = Integer.parseInt(parts1[1]);  // Second part as denominator
        rational r1 = new rational(num1, den1);

        System.out.print("Enter the second signal S2 in num/den format (e.g., 5/9): ");
        String input2 = sc.nextLine();
        String[] parts2 = input2.split("/");  // Split input at "/"
        int num2 = Integer.parseInt(parts2[0]);  // First part as numerator
        int den2 = Integer.parseInt(parts2[1]);  // Second part as denominator
        rational r2 = new rational(num2, den2);
       
     // Calculate S_eq = (S1 * S2) / (S1 + S2)
        rational numerator = r1.mult(r2);  // S1 * S2
        rational denominator = r1.add(r2);  // S1 + S2
        rational eq = numerator.div(denominator);  // Now use divide() instead of multiply
        
     // Simplify and display result
        eq.reduce();
        System.out.println("Combined Signal (S_eq): ");
        eq.display();
        */
		
        /*// Taking input for first rational number
        System.out.print("Enter numerator of S1: ");
        int num1 = sc.nextInt();
        System.out.print("Enter denominator of S1: ");
        int den1 = sc.nextInt();

        //Taking input for second rational number
        System.out.print("Enter numerator of S2: ");
        int num2 = sc.nextInt();
        System.out.print("Enter denominator of S2: ");
        int den2 = sc.nextInt();

        //Creating Rational objects
        rational r1 = new rational(num1, den1);
        rational r2 = new rational(num2, den2);
		rational p1= r1.mult(r2);
		rational p2=r1.add(r2);
		rational p =p1.div(p2);
		System.out.printf("equivalent:", p.display());*/
		/*r1.add(r2).display();
		r1.sub(r2).display();
		r1.mult(r2).display();
		r1.div(r2).display();*/
		
		sc.close();
	}
}
/*class Rational {
    private int numerator, denominator;

    public Rational(int num, int den) {
        if (den == 0) throw new ArithmeticException("Denominator cannot be zero");
        int gcd = gcd(num, den);
        this.numerator = num / gcd;
        this.denominator = den / gcd;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public String toString() {
        return numerator + "/" + denominator;
    }
}

// Polynomial class using Rational coefficients
class Polynomial {
    private Rational[] coefficients;

    public Polynomial(Rational[] coeffs) {
        this.coefficients = coeffs;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = coefficients.length - 1; i >= 0; i--) {
            if (i > 0)
                sb.append(coefficients[i] + "x^" + i + " + ");
            else
                sb.append(coefficients[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Rational[] coeffs = {new Rational(1, 2), new Rational(3, 4), new Rational(5, 6)};
        Polynomial poly = new Polynomial(coeffs);
        System.out.println("Polynomial: " + poly);
    }
}
*/
