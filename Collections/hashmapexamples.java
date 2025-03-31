package Collections;
import java.util.*;

public class hashmapexamples {

    static void wordcount(String text, HashMap<String, Integer> wordCount) {
        for (String word : text.split(" ")) {  // Splitting input text into words
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1); // Updating count
        }
    }

    public static void main(String[] args) {
        String text = "apple banana apple cherry banana apple";
        HashMap<String, Integer> wordCount = new HashMap<>();
        wordcount(text, wordCount);
        System.out.println("Word Frequencies: " + wordCount);
    }
}
