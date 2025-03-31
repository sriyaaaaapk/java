package Collections;
import java.util.HashMap;
import java.util.Map;
public class hashmap1 {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        // put(key, value) – Insert or Update a Key-Value Pair
        map.put("Apple", 100);
        map.put("Banana", 50);
        map.put("Cherry", 75);
        map.put("Apple", 120); // Updates value
        System.out.println("HashMap after put(): " + map);

        // get(key) – Retrieve a Value by Key
        System.out.println("Get 'Apple': " + map.get("Apple"));
        System.out.println("Get 'Mango': " + map.get("Mango")); // null

        // containsKey(key) – Check If a Key Exists
        System.out.println("Contains 'Banana'? " + map.containsKey("Banana"));
        System.out.println("Contains 'Mango'? " + map.containsKey("Mango"));

        // containsValue(value) – Check If a Value Exists
        System.out.println("Contains value 50?" + map.containsValue(50));
        System.out.println("Contains value 200?" + map.containsValue(200));

        // remove(key) – Delete a Key-Value Pair
        map.remove("Banana");
        System.out.println("HashMap after removing 'Banana': " + map);

        // Remove only if a specific value is present
        map.remove("Apple", 120);
        System.out.println("HashMap after conditional remove: " + map);

        // size() – Get the Number of Entries
        System.out.println("Size of HashMap: " + map.size());

        // isEmpty() – Check If the Map is Empty
        System.out.println("Is HashMap empty? " + map.isEmpty());

        // keySet() – Get All Keys
        System.out.println("Keys in HashMap: " + map.keySet());

        // values() – Get All Values
        System.out.println("Values in HashMap: " + map.values());

        // entrySet() – Get All Key-Value Pairs
        System.out.println("Key-Value Pairs:");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue());
        }

        // forEach() – Iterate Using Lambda Expression
        System.out.println("Using forEach:");
        map.forEach((key, value) -> System.out.println(key + " : " + value));

        // getOrDefault(K key, V defaultValue) – Get a Value or Default
        System.out.println("Get 'Mango' or default 0: " + map.getOrDefault("Mango", 0));

        // clear() – Remove All Entries
        map.clear();
        System.out.println("Is HashMap empty after clear()? " + map.isEmpty());
    }
}
