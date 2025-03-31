package Collections;
import java.util.*;
public class hashmapquestions {
	    // 1️⃣ Find the Most Frequent Element
	    static int mostFrequent(int[] arr) {
	        HashMap<Integer, Integer> freq = new HashMap<>();
	        int maxCount = 0, mostFreqNum = -1;
	        
	        for (int num : arr) {
	            freq.put(num, freq.getOrDefault(num, 0) + 1);
	            if (freq.get(num) > maxCount) {
	                maxCount = freq.get(num);
	                mostFreqNum = num;
	            }
	        }
	        
	        return mostFreqNum;
	    }

	    // 2️⃣ Anagram Checker
	    static boolean isAnagram(String s1, String s2) {
	        if (s1.length() != s2.length()) return false;
	        
	        HashMap<Character, Integer> count = new HashMap<>();
	        for (char c : s1.toCharArray()) count.put(c, count.getOrDefault(c, 0) + 1);
	        for (char c : s2.toCharArray()) count.put(c, count.getOrDefault(c, 0) - 1);

	        for (int value : count.values()) {
	            if (value != 0) return false;
	        }
	        return true;
	    }

	    // 3️⃣ First Non-Repeating Character
	    static char firstNonRepeating(String s) {
	        HashMap<Character, Integer> count = new LinkedHashMap<>();
	        for (char c : s.toCharArray()) count.put(c, count.getOrDefault(c, 0) + 1);
	        for (char c : s.toCharArray()) if (count.get(c) == 1) return c;
	        return '-';
	    }

	    // 4️⃣ Student Marks System (Find Top Student & Average Marks)
	    static void studentMarksSystem(HashMap<String, Integer> marks) {
	        String topStudent = "";
	        int highestMarks = Integer.MIN_VALUE;
	        int sum = 0;

	        for (Map.Entry<String, Integer> entry : marks.entrySet()) {
	            sum += entry.getValue();
	            if (entry.getValue() > highestMarks) {
	                highestMarks = entry.getValue();
	                topStudent = entry.getKey();
	            }
	        }
	        
	        double average = sum / (double) marks.size();
	        System.out.println("Top Student: " + topStudent + " (" + highestMarks + ")");
	        System.out.println("Average Marks: " + average);
	    }

	    // 5️⃣ Count Word Frequency in a Paragraph
	    static HashMap<String, Integer> wordFrequency(String text) {
	        HashMap<String, Integer> wordCount = new HashMap<>();
	        for (String word : text.split(" ")) {
	            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
	        }
	        return wordCount;
	    }

	    // 6️⃣ Find Duplicates in an Array
	    static List<Integer> findDuplicates(int[] arr) {
	        HashMap<Integer, Integer> freq = new HashMap<>();
	        List<Integer> duplicates = new ArrayList<>();

	        for (int num : arr) {
	            freq.put(num, freq.getOrDefault(num, 0) + 1);
	        }
	        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
	            if (entry.getValue() > 1) duplicates.add(entry.getKey());
	        }
	        return duplicates;
	    }

	    // 7️⃣ Frequency of Digits in a Number
	    static HashMap<Integer, Integer> digitFrequency(int num) {
	        HashMap<Integer, Integer> freq = new HashMap<>();
	        while (num > 0) {
	            int digit = num % 10;
	            freq.put(digit, freq.getOrDefault(digit, 0) + 1);
	            num /= 10;
	        }
	        return freq;
	    }

	    // 8️⃣ Group Words by Their First Letter
	    static HashMap<Character, List<String>> groupByFirstLetter(String[] words) {
	        HashMap<Character, List<String>> groups = new HashMap<>();
	        for (String word : words) {
	            char firstChar = word.charAt(0);
	            groups.putIfAbsent(firstChar, new ArrayList<>());
	            groups.get(firstChar).add(word);
	        }
	        return groups;
	    }

	    // 9️⃣ Employee Salary Records (Find Highest Paid Employee)
	    static void highestSalary(HashMap<String, Integer> salaries) {
	        String highestPaid = "";
	        int maxSalary = Integer.MIN_VALUE;

	        for (Map.Entry<String, Integer> entry : salaries.entrySet()) {
	            if (entry.getValue() > maxSalary) {
	                maxSalary = entry.getValue();
	                highestPaid = entry.getKey();
	            }
	        }
	        System.out.println("Highest Paid Employee: " + highestPaid + " (" + maxSalary + ")");
	    }

	    // 🔟 Character Frequency in a String
	    static HashMap<Character, Integer> characterFrequency(String s) {
	        HashMap<Character, Integer> freq = new HashMap<>();
	        for (char c : s.toCharArray()) {
	            freq.put(c, freq.getOrDefault(c, 0) + 1);
	        }
	        return freq;
	    }

	    // 1️⃣1️⃣ Find Missing Number in a Sequence
	    static int findMissingNumber(int[] arr, int n) {
	        int sum = n * (n + 1) / 2;
	        for (int num : arr) sum -= num;
	        return sum;
	    }

	    // 1️⃣2️⃣ Count Pairs with Given Sum
	    static int countPairsWithSum(int[] arr, int sum) {
	        HashMap<Integer, Integer> freq = new HashMap<>();
	        int count = 0;

	        for (int num : arr) {
	            count += freq.getOrDefault(sum - num, 0);
	            freq.put(num, freq.getOrDefault(num, 0) + 1);
	        }
	        return count;
	    }

	    // 1️⃣3️⃣ Check if Two Arrays are Equal
	    static boolean areArraysEqual(int[] arr1, int[] arr2) {
	        if (arr1.length != arr2.length) return false;
	        HashMap<Integer, Integer> freq = new HashMap<>();

	        for (int num : arr1) freq.put(num, freq.getOrDefault(num, 0) + 1);
	        for (int num : arr2) {
	            if (!freq.containsKey(num) || freq.get(num) == 0) return false;
	            freq.put(num, freq.get(num) - 1);
	        }
	        return true;
	    }

	    public static void main(String[] args) {
	        System.out.println("Most Frequent: " + mostFrequent(new int[]{1, 2, 3, 3, 4, 1, 3}));
	        System.out.println("Anagrams? " + isAnagram("listen", "silent"));
	        System.out.println("First Non-Repeating: " + firstNonRepeating("swiss"));
	        
	        System.out.println("Duplicates: " + findDuplicates(new int[]{1, 2, 3, 3, 4, 1}));
	        System.out.println("Digit Frequency: " + digitFrequency(122333));

	        String[] words = {"apple", "banana", "avocado", "cherry"};
	        System.out.println("Grouped Words: " + groupByFirstLetter(words));

	        HashMap<String, Integer> salaries = new HashMap<>();
	        salaries.put("Alice", 70000);
	        salaries.put("Bob", 85000);
	        salaries.put("Charlie", 60000);
	        highestSalary(salaries);
	        
	        System.out.println("Missing Number: " + findMissingNumber(new int[]{1, 2, 3, 5}, 5));
	        System.out.println("Count Pairs with Sum 5: " + countPairsWithSum(new int[]{1, 2, 3, 4, 2}, 5));
	        System.out.println("Arrays Equal? " + areArraysEqual(new int[]{1, 2, 3}, new int[]{3, 1, 2}));
	    }
	}
