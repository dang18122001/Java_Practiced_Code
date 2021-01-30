import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AllHomophones {

    public static void main(String[] args) {
        UALDictionary<String, String> PDict = new UALDictionary<>();
        File file = new File("C:\\Users\\DangHuynh\\Downloads\\NJIT Fall 2020\\" +
                "CS 114\\cmudict.0.7a.txt");
        Scanner sc = new Scanner(System.in);
        String inputWord = sc.next();
        String chosenPronunciation = "";

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.startsWith(";;;"))
                    continue; // skip comment lines
                Pronunciation p = new Pronunciation(line);

                if (p.getWord().equals(inputWord)) {
                    chosenPronunciation = p.getPhonemes();
                }
                PDict.insert(p.getPhonemes(), p.getWord());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (String word: PDict.findAll(chosenPronunciation)) {

            System.out.println(word);
        }
    }
}