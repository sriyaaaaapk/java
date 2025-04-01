package javasem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;


public class StringMethods {
	static void reverse(String S) {
		for (int i=S.length()-1; i>=0; i--)  System.out.print(S.charAt(i));
	}
	
	static boolean isPalindrome(String S) {
	    int left = 0, right = S.length() - 1;
	    while (left < right) {
	        if (S.charAt(left) != S.charAt(right)) {
	            return false;  // If mismatch found, not a palindrome
	        }
	        left++;
	        right--;
	    }
	    return true;
	}
 
	static void count(String S) {
		int vowels=0, consonants=0;
		for (char ch : S.toCharArray()) {
			if ((ch >= 'a' && ch <= 'z') || (ch>='A' && ch<= 'Z')) { // Only consider alphabets
                if ("aeiou".indexOf(ch) != -1)
                    vowels++;
                else
                    consonants++;
            }
		}
		System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
	}
	static int wordcount(String S, String word) {
		String[] words=S.split(" ");
		int c=0;
		for (String w: words) {
			if(w.equals(word)) {
				c++;
			}
		}
	return c;
	}
	static void frequency(String S) {
		HashMap<Character, Integer> freqMap = new HashMap<>(); //For "banana", the map will be {b=1, a=3, n=2}
        
        for (char ch : S.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }
        
        char maxChar = ' ';
        int maxCount = 0;
        for (char ch : freqMap.keySet()) {
            if (freqMap.get(ch) > maxCount) {
                maxCount = freqMap.get(ch);
                maxChar = ch;
            }
        }
        
        System.out.println("Most Frequent Character: " + maxChar);
	}
	
	
	static void sorttt(String S) {
		String[] words=S.split(" ");
		Arrays.sort(words);
		System.out.println(String.join(" ", words));
	}
	
	static void substrings(String S) {
		int n = S.length();
        
        for (int i = 0; i < n; i++) {  // Start index
            for (int j = i + 1; j <= n; j++) {  // End index
                System.out.println(S.substring(i, j));
            }
	}
	}

	static void duplicate(String S) {
		HashSet<Character> s = new LinkedHashSet<>();
		for (char ch : S.toCharArray()) {
	            s.add(ch);
	        }
		/*StringBuilder str = new StringBuilder();
    for (char ch : s) {
        str.append(ch);
    }
    
    System.out.println(str.toString());*/
		 
		String str="";
		for (char ch : s) {
			str=str+ String.valueOf(ch);
		} System.out.println(str);
	}
	static void lengthofstring(String S) { //countsnimberof total words
		String[] set= S.split(" ");
		System.out.println(set.length);
	 }
	static void extract(String S) {
		StringBuilder result= new StringBuilder();
		for (char ch: S.toCharArray()) {
			if (Character.isUpperCase(ch)) result.append(ch);
		}	System.out.println(result.toString());
	}
	
	static char nonrepeating(String S) {
		LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
		 // Count occurrences
        for (char ch : S.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Find the first non-repeating character
        for (char ch : map.keySet()) {
            if (map.get(ch) == 1) {
                return ch;
            }
        }
        return '\0'; // Return null character if no unique character is found
    }
	
	static boolean anagram(String S1,String S2) {
		if (S1.length() !=S2.length()) { return false;}
		// Convert to character arrays and sort
        char[] arr1 = S1.toCharArray();
        char[] arr2 = S2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);	
        // Check if sorted arrays are equal
        return Arrays.equals(arr1, arr2);
    }
	static void findPalindromicSubstrings(String S) {
	    int n = S.length();
	    for (int i = 0; i < n; i++) {
	        for (int j = i + 1; j <= n; j++) {
	            String sub = S.substring(i, j);
	            if (isPalindrome(sub)) {
	                System.out.println(sub); }	 }}}  
	static boolean isRotation(String S1, String S2) {
	    if (S1.length() != S2.length()) return false;
	    return (S1 + S1).contains(S2);
	}
	
	static String pigLatin(String S) {
	    String[] words = S.split(" ");
	    StringBuilder result = new StringBuilder();
	    for (String word : words) {
	        result.append(word.substring(1)).append(word.charAt(0)).append("ay ");
	    }
	    return result.toString().trim();
	}
	
	static void splitString(String S, int length) {
	    int x = S.length();
	    while (x % length != 0) {
	        S += "*"; // Padding with '*'
	    }

	    for (int i = 0; i < x; i += length) {
	        System.out.println(S.substring(i, i + length));
	    }
	}


	
	static String findMostFrequentWord(String sentence) {
        String[] words = sentence.toLowerCase().split(" ");
        Map<String, Integer> freqMap = new HashMap<>();

        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        String maxWord = "";
        int maxFreq = 0;
        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() > maxFreq) {
                maxWord = entry.getKey();
                maxFreq = entry.getValue();
            }
        }
        return maxWord;
    }
	
	static String compress(String str) {
        StringBuilder compressed = new StringBuilder();
        int count = 1;

        for (int i = 0; i < str.length(); i++) {
            if (i + 1 < str.length() && str.charAt(i) == str.charAt(i + 1)) {
                count++;
            } else {
                compressed.append(str.charAt(i)).append(count);
                count = 1;
            }
        }
        return compressed.toString();
    }
	
	static String longestPalindrome(String s) {
        if (s.isEmpty()) return "";
        String longest = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String sub = s.substring(i, j + 1);
                if (new StringBuilder(sub).reverse().toString().equals(sub) && sub.length() > longest.length()) {
                    longest = sub;
                }
            }
        }
        return longest;
    }
	static void lastindex(String S) {
        char ch = 'a';  // Character to search for
        int index = S.lastIndexOf(ch);
        if (index != -1) {
            System.out.println("Last occurrence of '" + ch + "' is at index: " + index);
        } else {
            System.out.println("Character not found in string.");
        }
    }
	
	static int nthIndex(String S, char ch, int n) {
	    int index = -1;  // Store the found index
	    int count = 0;   // Count occurrences of ch

	    for (int i = 0; i < S.length(); i++) {
	        if (S.charAt(i) == ch) {
	            count++; // Found an occurrence
	            if (count == n) {
	                return i;  // Return index of nth occurrence
	            }
	        }
	    }
	    return -1; // Return -1 if the character appears less than n times
	}
	public static void main(String[] args) {
		
/*		String sentence = "sriya bakes a cake and the cake rocks.";
        System.out.println("Most frequent word: " + findMostFrequentWord(sentence));
		System.out.println(pigLatin("hello"));
		String S = "apple banana apple orange apple banana";
	    System.out.println(wordcount(S, "apple"));  // Output: 3
	    System.out.println(wordcount(S, "banana")); // Output: 2
	    System.out.println(wordcount(S, "grape"));  // Output: 0
		 System.out.println(nthIndex("banana", 'a', 2));  // Output: 3 (2nd occurrence)
		    System.out.println(nthIndex("banana", 'a', 3));  // Output: 5 (3rd occurrence)
		    System.out.println(nthIndex("banana", 'a', 4));
		lastindex("banana");
		 System.out.println(longestPalindrome("sriya")); // Output: "bab" or "aba"
	     System.out.println(longestPalindrome("cbbd"));  // Output: "bb"
		String input = "aaabbc";
        System.out.println("Compressed: " + compress(input));
		
		splitString("HelloWorld", 3);
		System.out.println(pigLatin("hello world")); // Output: "ellohay orldway"
		
		System.out.println(isRotation("listen", "silent"));
		findPalindromicSubstrings("racecar");

		String S1= "listen";
		String S2= "silent";
		if (anagram(S1, S2)) {
            System.out.println("The strings are anagrams.");
        } else {
            System.out.println("The strings are NOT anagrams.");
        }
		
		String S="swiss";
System.out.print(nonrepeating(S));
duplicate(S);
countwords(S);
String[] subs=new String[S.length()-2];

for (int i=0; i<S.length()-2;i++) {
	subs[i]=S.substring(i, i+3);
	System.out.print(subs[i] + " ");
}
System.out.println();
Arrays.sort(subs);
for (int i=0; i<S.length()-2;i++) 	System.out.print(subs[i] + " ");
System.out.println();
System.out.println(S.indexOf('o'));
System.out.println(S.contains("nio"));*/
	
		/*String str="Academician";
		String str1=str.substring(3, 7);
	    System.out.println(str.length());//Output 11
		System.out.println(str1);//Output "demi"
		System.out.println(str.charAt(6));//Ouput'i'
		System.out.println(str.indexOf('m'));//Output 5 //character
		System.out.println(str.contains ("mic"));//Output true //string
		String[]st=str.split("e"); //string
		System.out.println(st[0]+" "+st[1]);//0--> Acad 1-->mician*/
	}
	
}
/*
    static void thirdIndex(String S, char ch) {
    int first = S.indexOf(ch);  // First occurrence
    if (first == -1) {
        System.out.println("Character '" + ch + "' not found.");
        return;
    }

    int second = S.indexOf(ch, first + 1);  // Second occurrence
    if (second == -1) {
        System.out.println("Character '" + ch + "' occurs only once.");
        return;
    }

    int third = S.indexOf(ch, second + 1);  // Third occurrence
    if (third == -1) {
        System.out.println("Character '" + ch + "' occurs only twice.");
    } else {
        System.out.println("Third occurrence of '" + ch + "' is at index: " + third);
    }
}

public static void main(String[] args) {
    thirdIndex("banana", 'a');  // Output: Third occurrence of 'a' is at index: 5
}
*/
