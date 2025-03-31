package javasem;
import java.util.HashMap;
public class Hashmap {
	
public static void main(String[] args) {
	HashMap<String, Integer> map = new HashMap<>();

	// ✅ Add key-value pairs
	map.put("Alice", 90);
	map.put("Bob", 85);
	map.put("Charlie", 92);

	// ✅ Get value by key
	int score = map.get("Alice");  // 90

	// ✅ Remove a key-value pair
	map.remove("Bob");

	// ✅ Check if key exists
	boolean hasAlice = map.containsKey("Alice");  // true

	// ✅ Check if value exists
	boolean has90 = map.containsValue(90);  // true

	// ✅ Iterate through keys
	for (String name : map.keySet()) {
	    System.out.println(name);
	}

	// ✅ Iterate through values
	for (int marks : map.values()) {
	    System.out.println(marks);
	}

	// ✅ Iterate through key-value pairs
	for (HashMap.Entry<String, Integer> entry : map.entrySet()) {
	    System.out.println(entry.getKey() + " -> " + entry.getValue());
	}

	// ✅ Clear the HashMap
	map.clear();

}
}

