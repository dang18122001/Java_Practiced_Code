import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MostAnagramsPS3 {
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

    public static void main(String[] args) {
        File file = new File("C:\\Users\\DangHuynh\\Downloads\\NJIT Fall 2020\\CS 114\\Homework\\words.txt"); // for your local machine
//        File file = new File("../resource/asnlib/public/words.txt");
        Scanner inp = new Scanner(System.in);
        int numLines = inp.nextInt();
        int n = 0;
        List<String> words = new ArrayList<>();
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

        int maxAnagrams = 0;
        int numberOfAnnagrams;
        String chosenWord = null;
        for (int i = 0; i < words.size() - 1; i++) {
            numberOfAnnagrams = 1;
            for (int j = i + 1; j < words.size(); j++) {
                if (areAnagram(words.get(i), words.get(j)))
                    numberOfAnnagrams++;
            }
            if (numberOfAnnagrams >= maxAnagrams) {
                maxAnagrams = numberOfAnnagrams;
                chosenWord = words.get(i);
            }
        }

        System.out.println(maxAnagrams);
        for (String word : words) {
            assert chosenWord != null;
            if (areAnagram(word, chosenWord))
                System.out.println(word);
        }
    }
}
