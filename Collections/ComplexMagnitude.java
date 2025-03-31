package Collections;
import java.util.ArrayList;

class complex{
	double real,imag;
	public complex(double real, double imag){
		this.real=real;
		this.imag=imag;
	}
	
	void display() {
		if(this.imag>0)
			System.out.println(real+"+j"+imag);
		else
			System.out.println(real+"-j"+-imag);
	}
	
	// Override toString() so that System.out.println(c) works properly
    @Override
    public String toString() {
        return imag >= 0 ? real + "+j" + imag : real + "-j" + (-imag);
    }

	
	double mag() {
		return Math.sqrt(real*real+imag*imag);
		}
}
public class ComplexMagnitude{

	    public static void main(String[] args) {
	        ArrayList<complex> numbers = new ArrayList<>();
	        numbers.add(new complex(4, 1));
	        numbers.add(new complex(2, 0.5));
	        numbers.add(new complex(0.6, 3));
	        numbers.add(new complex(4,0.2));
	        numbers.add(new complex(0.8,0));

	        System.out.println("Complex numbers with magnitude > 2:");
	        for (complex c : numbers) {
	            if (c.mag() > 1) {
	                System.out.println(c);
	            }
}
	    }
}
