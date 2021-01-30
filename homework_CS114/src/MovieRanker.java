import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Collections;

/* Starter code for PS8.
 */

public class MovieRanker {

    public static void main(String[] args) {
//        File file = new File("C:\\Users\\DangHuynh\\Downloads\\NJIT Fall 2020\\CS 114\\ratings.tsv");

        File file = new File("C:\\Users\\DangHuynh\\Downloads\\ratings.tsv");

        ArrayList<MovieRating> rl = new ArrayList<MovieRating>();

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] tkns = line.split("\\t"); // tabs separate tokens
                MovieRating nr = new MovieRating(tkns[0], tkns[1], tkns[2]);
                rl.add(nr);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        int minVotes = 1;
        int numRecords = 1;
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println();
            System.out.println("Enter minimum vote threshold and number of records:");
            minVotes = input.nextInt();
            numRecords = input.nextInt();
            if (minVotes * numRecords == 0)
                break;
            long startTime = System.currentTimeMillis();

            /* Fill in code to determine the top numRecords movies that have at least
             * minVotes votes. For each record mr, in decreaseing order of average rating,
             * execute a System.out.println(mr).
             * Do not sort the movie list!
             */
            MaxHeap<MovieRating> r = new MaxHeap();
            for (MovieRating i : rl) {
                if (i.getVotes() >= minVotes) {
                    r.insert(i);
                }
            }


            for (int i=0; i < numRecords && r.heapsize() != 0; i++) {
                MovieRating a = r.removemax();
                System.out.println(a);
            }
            System.out.println();
            long readTime = System.currentTimeMillis();
            System.out.println("Time: "+(System.currentTimeMillis()-startTime)+" ms");
        }
    }
}
