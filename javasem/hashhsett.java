package javasem;
import java.util.HashSet;
public class hashhsett {
 public static void main(String[] args){
	HashSet<Integer> set = new HashSet<>();

	// ✅ Add elements
	set.add(10);
	set.add(20);
	set.add(10);  // Duplicate, won't be added

	// ✅ Remove an element
	set.remove(20);

	// ✅ Check if an element exists
	boolean exists = set.contains(10);  // true

	// ✅ Get size of HashSet
	int size = set.size();

	// ✅ Iterate through HashSet
	for (int num : set) {
	    System.out.println(num);
	}

	// ✅ Clear all elements
	set.clear();

}
}
