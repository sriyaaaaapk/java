package javasem;

import java.util.Scanner;

class pointclass {
    double x, y, z;
    
    pointclass(double x2, double y2){
    	 this.x = x2;
         this.y = y2;
    }
    // Default constructor
    pointclass() {
        this.x = this.y = this.z = 0;
    }
    
    // Check if three points are collinear
    static boolean areCollinear(pointclass A, pointclass B, pointclass C) {
        // Calculate slopes (AB and BC)
        double slopeAB = (double)(B.y - A.y) / (B.x - A.x);
        double slopeBC = (double)(C.y - B.y) / (C.x - B.x);
        
        return slopeAB == slopeBC;
    }
     
    static double slope(pointclass A, pointclass B) {
    	double num = B.y -A.y;
        double den = B.x - A.x;        
        return num/den;
    }

    // Parameterized constructor
    pointclass(double a, double b, double c) {
        x = a;
        y = b;
        z = c;
    }

    void setData(double a, double b, double c) {
        x = a;
        y = b;
        z = c;
    }

    void getData() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter x coordinate:");
        x = sc.nextDouble();

        System.out.println("Enter y coordinate:");
        y = sc.nextDouble();

        System.out.println("Enter z coordinate:");
        z = sc.nextDouble();
    }

    void display() {
        System.out.println("(" + x + ", " + y + ", " + z + ")");
    }

    double dist(pointclass other) {
        double a = x - other.x;
        double b = y - other.y;
        double c = z - other.z;
        return Math.sqrt(a * a + b * b + c * c);
    }

    static double distance(pointclass p1, pointclass p2) {
        double a = p1.x - p2.x;
        double b = p1.y - p2.y;
        double c = p1.z - p2.z;
        return Math.sqrt(a * a + b * b + c * c);
    }

    pointclass vectr(pointclass other) {
        return new pointclass(other.x - x, other.y - y, other.z - z);
    }

    double dot(pointclass other) {
        return x * other.x + y * other.y + z * other.z;
    }

    double mod() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    double angle(pointclass other) {
        return Math.acos(dot(other) / (mod() * other.mod())) * 180 / Math.PI;
    }

    pointclass cross(pointclass other) {
        return new pointclass(
            (other.z * y - other.y * z),
            (other.x * z - other.z * x),
            (other.y * x - other.x * y)
        );
    }

    pointclass add(pointclass other) {
        return new pointclass(x + other.x, y + other.y, z + other.z);
    }

    pointclass unit() {
        double magnitude = mod();
        return new pointclass(x / magnitude, y / magnitude, z / magnitude);
    }

    pointclass scalar(double alpha) {
        return new pointclass(alpha * x, alpha * y, alpha * z);
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + "," + z + ")";
    }
    
    pointclass reflectionthroughx() {
    	return new pointclass(this.x, -this.y); //reflection through x shall make y negavtive
    }
    
    pointclass rotate90() {
    	 return new pointclass(-this.y, this.x); // New coordinates after 90° rotation
    } //180--> x=-x y=-y
    //270--> x=y y=-x


    public static void main(String[] args) {
    	pointclass A= new pointclass(2,3);
    	/*pointclass rotatedA= A.rotate90();
    	System.out.println("(" + rotatedA.x + "," + rotatedA.y + "," +rotatedA.z + ")");*/
    	pointclass B= new pointclass(4,7);
    	 System.out.println(slope(A,B));
    	//pointclass C= new pointclass(5,6);
    	
    	/*if (areCollinear(A, B, C)) {
            System.out.println("The points are collinear.");
        } else {
            System.out.println("The points are not collinear.");
        }*/
    	/*pointclass reflectedPoint = p.reflectionthroughx();

        // Display the reflected point
        System.out.print("Reflected Point across X-axis: ");
        reflectedPoint.display();*/
        /*pointclass p1 = new pointclass(1, 0, 0);
        p1.display();

        pointclass p2 = new pointclass(0, 1, 0);
        p2.display();

        System.out.println("Distance: " + p1.dist(p2));

        System.out.println("Vector from p1 to p2:");
        p1.vectr(p2).display();

        System.out.println("Angle between p1 and p2: " + p1.angle(p2) + " degrees");

        System.out.println("Cross product of p1 and p2:");
        p1.cross(p2).display();

        System.out.println("Addition of p1 and p2:");
        p1.add(p2).display();
    }
	
	/*double x,y,z;
	pointclass(double a, double b, double c) {
        x = a;
        y = b;
        z = c;
    }
	static double distance(pointclass p1, pointclass p2) {
        double a = p1.x - p2.x;
        double b = p1.y - p2.y;
        double c = p1.z - p2.z;
        return Math.sqrt(a * a + b * b + c * c);
    }
	
	static String midpoint(pointclass p1, pointclass p2) {
		double a = (p1.x + p2.x)/2;
        double b = (p1.y + p2.y)/2;
        double c = (p1.z + p2.z)/2;
        return "(" + a + "," + b + "," + c + ")";
	}
	
	static void vectr(pointclass p1,pointclass p2) {
        double a=p1.x - p2.x;
        double b = p1.y - p2.y;
        double c= p1.z - p2.z;
        System.out.println(("(" + a + ", " + b + ", " + c + ")"));
        }
	
	public static void main(String args[]) {
		pointclass p1 = new pointclass(1,2,3);
		pointclass p2 = new pointclass(4,5,6);
		//int d=(int) (((distance(p1, p2)*1000))/1000.0);
		//System.out.println("Distance between city A and city B:" + midpoint(p1,p2));
		vectr(p1, p2);
	}*/
    }
}