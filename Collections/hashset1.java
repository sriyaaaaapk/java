package Collections;
import java.util.*;
//ArrayList methods:
/*  add(E element)	Adds an element to the list.
add(int index, E element)	Inserts an element at a specific position.
get(int index)	Retrieves an element.
set(int index, E element)	Updates an element.
remove(int index)	Removes an element by index.
remove(Object o)	Removes the first occurrence of an object.
size()	Returns the number of elements.
isEmpty()	Checks if the list is empty.
removeIf(Predicate<T>)	Removes elements based on a condition.
sort(Comparator<T>)	Sorts elements using a comparator. */
public class hashset1 {
	
	 public static void main(String[] args) {
		 HashSet<String> set = new HashSet<>();
		 set.add("Apple");
		 set.add("Banana");
		 set.add("Cherry");
		 set.add("Apple");
		 
		 tree();
	 
	 
		 // Iterate using for-each loop
	         for (String item : set)   System.out.println(item);
	         
	         System.out.println(set.size());
	         
	         // Iterate using Iterator
	         Iterator<String> iterator = set.iterator();
	         while (iterator.hasNext()) {
	            System.out.println(iterator.next());
	         }
	         
	         System.out.println(set.size());
	 }
	     
	 
	 static void tree() {
		 TreeSet<String> t = new TreeSet<>(); //(String.CASE_INSENSITIVE_ORDER.reversed())
		 //descending order TreeSet<String> t = new TreeSet<>(Collections.reverseOrder());
		 t.add("Apple");
		 t.add("Banana");
		 t.add("Cherry");
		 t.add("apple");
		 
		 for (String item : t) {
	            System.out.println(item);
	        }
	        
	        System.out.println("Size of TreeSet: " + t.size());
	 }
	 }
	