import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MostAnagrams {
    static boolean areAnagram(String word1, String word2) {
        char[] str1 = word1.toCharArray();
        char[] str2 = word2.toCharArray();

        // Get lengths of both strings
        int n1 = str1.length;
        int n2 = str2.length;

        // If length of both strings is not same,
        // then they cannot be anagram
        if (n1 != n2)
            return false;

        // Sort both strings
        Arrays.sort(str1);
        Arrays.sort(str2);

        // Compare sorted strings
        for (int i = 0; i < n1; i++)
            if (str1[i] != str2[i])
                return false;

        return true;
    }

    static boolean isPalindrome(String str) {
        // Pointers pointing to the beginning
        // and the end of the string
        int i = 0, j = str.length() - 1;

        // While there are characters toc compare
        while (i < j) {

            // If there is a mismatch
            if (str.charAt(i) != str.charAt(j))
                return false;

            // Increment first pointer and
            // decrement the other
            i++;
            j--;
        }

        // Given string is a palindrome
        return true;
    }

    public static void main(String[] args) {
        File file = new File("C:\\Users\\DangHuynh\\Downloads\\NJIT Fall 2020\\CS 114\\Homework\\words.txt"); // for your local machine
//        File file = new File("../resource/asnlib/public/words.txt");
        Scanner inp = new Scanner(System.in);
        int numLines = inp.nextInt();
        int n = 0;
        List<String> words = new ArrayList<>(120000);
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String line = scanner.next();
                words.addAll(Arrays.asList(line.split("[\\s.,?!:;'\"]+")));
                ++n;
                if (n >= numLines)
                    break;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int ans = 0;

        for (int i = 0; i < words.size() - 1; i++) {
            boolean haveAnagram = false;
            for (int j = i + 1; j < words.size(); j++) {
                if (areAnagram(words.get(i), words.get(j))) {
                    haveAnagram = true;
                    break;
                }
            }

            if (haveAnagram != true)
                if (isPalindrome(words.get(i)))
                    ans ++;
        }
        System.out.println(ans);
    }
}

