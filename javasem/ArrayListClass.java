package javasem;
import java.util.*;
public class ArrayListClass {
	public static void main(String[] args) {
		
		

		ArrayList<Integer> list = new ArrayList<>();

		// ✅ Add elements
		list.add(5);
		list.add(10);
		list.add(15);

		// ✅ Insert at index
		list.add(1, 7);  // Inserts 7 at index 1

		// ✅ Get element at index
		int num = list.get(2);  // 10

		// ✅ Remove element by index
		list.remove(1);  // Removes the element at index 1

		// ✅ Remove element by value (if exists)
		list.remove(Integer.valueOf(10));

		// ✅ Check if list contains an element
		boolean contains5 = list.contains(5);  // true

		// ✅ Get size of ArrayList
		int size = list.size();

		// ✅ Iterate through ArrayList
		for (int i : list) {
		    System.out.println(i);
		}

		// ✅ Using index-based loop
		for (int i = 0; i < list.size(); i++) {
		    System.out.println(list.get(i));
		}

		// ✅ Clear all elements
		list.clear();

	ArrayList<Integer>A=new ArrayList<>(); //List<Integer>A=new ArrayList<>();
	A.add(2); A.add(5); A.add(8); 
	System.out.println(A);
	
	A.add(1,3); //(where to add, what to add)
	System.out.println(A);
	
	A.set(2,6); //replace
	System.out.println(A);
	
	A.remove(2); //index to remove
	System.out.println(A);
	
	Collections.shuffle(A);
	System.out.println(A);
	Collections.sort(A);
	System.out.println(A);
	
	/*ArrayList<String>S=new ArrayList<>();
	S.add("Rahul");
	S.add("Neha");
	S.add("Gokul");
	S.add("Preethi");
	System.out.println(S);
	
	S.remove("Neha"); //S.remove(2);
	System.out.println(S);
	
	S.add(1, "Lakshmi"); //(where to add,what to add)
	System.out.println(S);
	
	Collections.sort(S);
	System.out.println(S);*/
		
	
	/*ArrayList<point>P=new ArrayList<>();
	point x1=new point(1,2,3);
	point x2=new point(2,4,6);
	point x3=new point(1,1,2);
	P.add(x1); P.add(x2); P.add(x3);
	System.out.println(P);
	
	*/
	
	}
}

/*// Create a HashSet
HashSet<Integer> set = new HashSet<>();
set.add(10);
set.add(20);
set.add(30);

// Convert HashSet to ArrayList
ArrayList<Integer> list = new ArrayList<>(set);

// Print the ArrayList
System.out.println("ArrayList: " + list);*/