package Collections;
import java.util.*;
public class Unique {
	 static void pangramchecker(String P){
		 HashSet<Character> HS = new HashSet<>();
		 P = P.toLowerCase().replaceAll("[^a-z]", "");
		 //for (char c : P.toCharArray()) HS.add(c);
		 for (int i = 0; i < P.length(); i++) HS.add(P.charAt(i)); // Add each character to HashSet
		 if (HS.size() == 26)
	            System.out.println("it is a pangram!");
	        else
	            System.out.println("it is not a pangram!");
	 }
	 static void uniqueword(String sentence) {
		 sentence = sentence.toLowerCase().replaceAll("[^a-z ]", ""); // Remove punctuation
	        String[] words = sentence.split(" "); //word's array
	        
	        HashSet<String> uniqueWords = new HashSet<>(Arrays.asList(words)); // HashSet removes duplicates
	        for (int i = 0; i < words.length; i++) {  
	        	uniqueWords.add(words[i]); // Add each word to HashSet
}
	        List<String> sortedWords = new ArrayList<>(uniqueWords);
	        Collections.sort(sortedWords); // Sorting
	        System.out.println(sortedWords); 
	 }
	 
	 static void uniquedigit(int num) {
		 HashSet<Character> digitSet = new HashSet<>();
         for (char ch : String.valueOf(Math.abs(num)).toCharArray()) 
         //Converts the absolute integer (num) into a String
         //Converts the string representation of the number into an array of characters.
         {
	            digitSet.add(ch);
	        }

	        System.out.println(digitSet); 
	 }
	 
	 //finding the first non repeating character in a string
	 /*import java.util.*;

	 public class FirstNonRepeating {
	     public static void main(String[] args) {
	         String s = "swiss";
	         LinkedHashMap<Character, Integer> count = new LinkedHashMap<>();

	         for (char c : s.toCharArray()) {
	             count.put(c, count.getOrDefault(c, 0) + 1);
	         }

	         for (char c : s.toCharArray()) {
	             if (count.get(c) == 1) {
	                 System.out.println(c);
	                 return;
	             }
	         }

	         System.out.println("No unique character found");
	     }*/
	 

	 public static void main(String[] args) {
	        String sentence = "Hello world! The world is big, and Hello to everyone.";
	        uniqueword(sentence);
	        String P = "The quick brown fox jumps over the lazy dog";
	        pangramchecker(P);
	        int num=-5959;
	        uniquedigit(num);
	 }
}