package javasem;
import java.util.*;
//class complex 
class complex implements Comparable<complex>
{
	double real,imag;
	complex(double real, double imag){
		this.real=real;
		this.imag=imag;
	}
	
	void display() {
		if(this.imag>0)
			System.out.println(real+"+j"+imag);
		else
			System.out.println(real+"-j"+-imag);
	}
	
	double mag() {
		return Math.sqrt(real*real+imag*imag);
		}
	
	public int compareTo(complex other) {
        return Double.compare(this.mag(), other.mag());
    }
	
	@Override
    public String toString() {
        return real + " + " + imag + "i";
    }
	
		double phase() {
		return Math.atan2(imag,real);  
		//atan2(imag,real) since atan2 already gives the correct angle in the range [-pie,pie]
	}
	
		
	static complex ptr(double mag, double phase) {
		complex out=new complex(0,0);
		out.real=Math.round(mag*Math.cos(phase)*1000)/1000.0;
		out.imag=Math.round(mag*Math.sin(phase)*1000)/1000.0;
		return out;
	}
	
	
	public static void main(String[] args) {
		List<complex> numbers = Arrays.asList(new complex(3, 4), new complex(1, 1), new complex(0, 2));
        Collections.sort(numbers);
        System.out.println("Sorted complex numbers by magnitude:");
        for (complex c : numbers) {
            System.out.println(c + " | Magnitude: " + c.mag());
        }
		/*Scanner sc = new Scanner(System.in);
		double real=sc.nextDouble();
		double imag=sc.nextDouble();
		 
	        // Taking user input
	        System.out.print("Impedance of inductor (jX_L): ");
	        double Z_I = sc.nextDouble();
	        
	        System.out.print("Impedance of capacitor (-jX_C): ");
	        double Z_C = sc.nextDouble();
	        
	        System.out.print("Resistance (R): ");
	        double Z_R = sc.nextDouble();

	        // Compute total impedance Z = R + j(X_L - X_C)
	        complex Z_total = new complex(Z_R, Z_I - Z_C);

	        // Display result
	        System.out.print("Total Impedance: ");
	        Z_total.display();
		
	        /*complex c3=new complex(1.5);
		System.out.print("c1: ");
        c1.display();
        System.out.print("c2: ");
        c2.display();
        System.out.print("c3: ");
        c3.display();

        // Addition
        System.out.print("c1 + c2: ");
        c1.add(c2).display();

        // Subtraction
        System.out.print("c1 - c2: ");
        c1.sub(c2).display();

        // Multiplication
        System.out.print("c1 * c2: ");
        c1.mul(c2).display();

        // Conjugate
        System.out.print("Conjugate of c1: ");
        c1.conj().display();

        // Division
        System.out.print("c1 / c2: ");
        c1.div(c2).display();

        // Magnitude
        System.out.println("Modulus of c1: " + c1.mod());

        // Phase
        System.out.println("Phase of c1 (in degrees): " + c1.phase() * 180 / Math.PI);

        // Convert from polar to rectangular
        System.out.print("Polar to Rectangular conversion of c1: ");
        complex.ptr(c1.mod(), c1.phase()).display();*/
	//sc.close();
	}

}
		
