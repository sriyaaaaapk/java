package Collections;
import java.util.*;
public class vect {
    double x, y, z;

    vect(double x, double y, double z) { 
        this.x = x;
        this.y = y;
        this.z = z;
    }
 // Vector addition function
    public vect add(vect v) {
        return new vect(this.x + v.x, this.y + v.y, this.z + v.z);
    }

    double mag() { 
        return Math.sqrt(x * x + y * y + z * z); 
    }

    @Override
    public String toString() { 
        return "(" + x + "," + y + "," + z + ")"; 
    }

public static void main(String[] args) {
	ArrayList<vect> v1 = new ArrayList<>();
	vect x1 = new vect(0, 0, 1);
	vect x2 = new vect(1, 0, 1);
	vect x3 = new vect(1, 1, 1);
	vect x4 = new vect(1, 2, 3);
	vect x5 = new vect(-1, 1, 0);
	v1.add(x1);
	v1.add(x2);
	v1.add(x3);
	v1.add(x4);
	v1.add(x5);
	v1.remove(1);  // Removes element at index 1 (x2)
	v1.remove(x1); // Removes x1 object
	v1.set(0, new vect(1, 3, 4)); // Updates index 0
	System.out.println(v1);
	
//A Comparator is used to define custom sorting logic for objects. Since Java does not know how to compare vect objects by default, we need to tell it how to sort them.
	Comparator<vect> m = new Comparator<vect>() {
	    @Override
	    public int compare(vect v1, vect v2) {
	        int com= Double.compare(v1.mag(), v2.mag());
	        System.out.println(com);
	        return com;
/*Double.compare(v1.mag(), v2.mag()) compares the two magnitudes:
	Returns -1 if v1.mag() < v2.mag() 
	Returns 1 if v1.mag() > v2.mag() 
	Returns 0 if both are equal*/
	    }
	};
	Collections.sort(v1, m);
	System.out.println(v1);


}
}
