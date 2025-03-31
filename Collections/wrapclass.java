package Collections;
/*In Java, primitive data types (like int, double, char) are not objects. But Java sometimes requires objects instead of primitives (e.g., in collections like ArrayList).
Wrapper classes help by providing an object representation for primitive types.*/
public class wrapclass {

	public static void main(String args[]) {
		String S= "123";
		
		int a= Integer.parseInt(S);
		Integer A= Integer.parseInt(S);
		System.out.println(a+2);
		System.out.println(A+2);
		//here 'a' is a primitive data type. primitive data type can't take a method
		//integer and int can be used interchangeably
		
		S=String.valueOf(a);
		System.out.println(S+ "45"); //12345
		S=String.format("%d", a);
		System.out.println(S+"45"); //12345
		S=A.toString();
		System.out.println(S+"45"); //12345
		
		String P="Rahul";
		String Q="Neha";
		String R="Preethi";
		System.out.println(P.compareTo(Q)); //it's P-Q character position.
		System.out.println(P.compareTo(R));
		
		int x =(int) 'a';
		int y =(int) 'b';
		System.out.println(x+y); 
		System.out.println((int)'a');
		System.out.println((int) 'b');
		
		// Using Character wrapper class
        Character alpha = 'a';
        Character beta = 'b';
        System.out.println(alpha);
        System.out.println(beta);
        System.out.println(alpha.compareTo(beta));  //-1 ('a' is before 'b')
		
		// Comparing Strings lexicographically
        String word1 = "Rahul";
        String word2 = "Preethi";
        System.out.println(word1.compareTo(word2));
	
/*

//valueOf(primitive) Creates a wrapper object from a primitive value.
Integer num = Integer.valueOf(10); // Converts int to Integer object
Double decimal = Double.valueOf(3.14); // Converts double to Double object
int num = 123;
String intStr = String.valueOf(num); // "123"


//toString() Converts a wrapper object to a String. 
Integer num = 123;
String str = num.toString(); // "123"
System.out.println(str + "456"); // "123456"

//typeValue() Extracts the primitive value from a wrapper object.
Integer num = Integer.valueOf(100);
int primitiveNum = num.intValue(); // Extracts int 100

//parseType(String s) Converts a String to its corresponding primitive type.
String str = "42";
int num = Integer.parseInt(str); // Converts "42" to int 42
double decimal = Double.parseDouble("3.14"); // Converts "3.14" to double 3.14

//compareTo(WrapperClass obj) Compares two wrapper objects.
Integer a = 5, b = 10;
System.out.println(a.compareTo(b)); // -1 (5 is less than 10)
System.out.println(b.compareTo(a)); // 1 (10 is greater than 5)
System.out.println(a.compareTo(5)); // 0 (5 is equal to 5)

//equals(Object obj) Checks if two wrapper objects are equal.
Integer x = 100, y = 100;
System.out.println(x.equals(y)); // true

//isNaN() & isInfinite() Only for Float and Double, used to check invalid numbers.
Double val = Double.NaN;
System.out.println(val.isNaN()); // true

Double infinity = Double.POSITIVE_INFINITY;
System.out.println(infinity.isInfinite()); // true

//hashCode()Returns the hash code for a wrapper object (used in hashing structures like HashMap).

Integer num = 123;
System.out.println(num.hashCode()); // 123 (For Integer, hashCode = value itself) */
}
}
//Autoboxing: Java automatically converts primitives → wrapper objects.
//Unboxing: Java automatically converts wrapper objects → primitives.