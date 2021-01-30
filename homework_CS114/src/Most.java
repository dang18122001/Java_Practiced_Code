import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Most {
        /**
         * Finds the number of anagrams of word from the list of words.
         *
         * @param word
         *            - word of which anagram is to be found
         * @param words
         *            - list of words
         * @return - the number of anagrams of word from the list of words
         */
        static int anagrams(String word, List<String> words) {
            int count = 0;
            // Get character array from word
            char[] wordChar = word.toCharArray();
            // Sort wordChar array
            Arrays.sort(wordChar);
            for (int i = 0; i < words.size(); i++) {
                boolean isAnagram = true;
                // Get word at i
                String listWord = words.get(i);
                // Check if word is not same and length of word with word at ith
                // position in the list
                if (!word.equalsIgnoreCase(listWord) && (word.length() == listWord.length())) {
                    // Get character array from listWord
                    char[] listWordChar = listWord.toCharArray();
                    // Sort listWordChar arrays
                    Arrays.sort(listWordChar);
                    // Compare all characters in the array
                    for (int j = 0; j < wordChar.length; j++) {
                        // Check if characters are same
                        if (wordChar[j] != listWordChar[j]) {
                            isAnagram = false;
                            break;
                        }
                    }
                    if (isAnagram) {
                        // If all characters match
                        count += 1;
                        // Remove listWord from words list
                        words.remove(i);
                        i -= 1;
                    }
                }
            }
            return count;
        }
        public static void main(String[] args) {
            // Get input file
            File file = new File("C:\\Users\\DangHuynh\\Downloads\\NJIT Fall 2020\\CS 114\\Homework\\words.txt");
            // Scanner to get user input
            Scanner input = new Scanner(System.in);
            // Get number of lines to read
            System.out.print("Enter number of lines to read: ");
            int maxLines = input.nextInt();
            // for counting the number of words read
            int n = 0;
            // List to hold the words
            List<String> words = new ArrayList<String>();
            // Open file to read
            try {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    // Read a line
                    String line = scanner.nextLine();
                    // Add the words in the line to the list
                    for (String word : line.split("[\\s.,?!:;\'\"]+"))
                        words.add(word);
                    // Increment n
                    ++n;
                    // Check if n is greater than maxWords
                    if (n >= maxLines)
                        break;
                }
                // Close file
                scanner.close();
                // Compute max, the maximum number of anagrams for any word
                int max = 0;
                String maxAnagramWord = null;
                for (int i = 0; i < words.size(); i++) {
                    // Get and remove word at i
                    String word = words.remove(i);
                    // Get the number of anagrams of word
                    int count = anagrams(word, words);
                    // Check if count is greater than max ad count is not zero
                    if ((count != 0) && (count >= max)) {
                        max = count;
                        if (maxAnagramWord == null)
                            maxAnagramWord = word;
                        else
                            maxAnagramWord = maxAnagramWord + ", " + word;
                    }
                }
                // Display max number of anagrams
                if (maxAnagramWord != null) {
                    System.out.println("The word(s) with maximum number of anagrams is: " + maxAnagramWord);
                    System.out.println("The number of anagrams of \"" + maxAnagramWord + "\" is " + max);
                } else
                    System.out.println("No word with anagram found.");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

