import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Clear {
    public static void main(String[] args) throws IOException {
        Select.rm = new Random();
        int pics = 17;
        File[] file = new File[pics];
        String prefix = "../resource/asnlib/publicdata/";
//        String prefix = "C:/Users/DangHuynh/Downloads/NJIT Fall 2020/CS 114/PS 10/";
        for (int p = 1; p <= pics; ++p) {
            String suff = String.valueOf(p);
            String filename = prefix + "birds" + suff + ".ppm";
            System.out.println("Opening "+filename);
            file[p-1] = new File(filename);
        }

        long start = System.currentTimeMillis();

        // create a scanner for each of the pictures
        //
        Scanner[] scan = new Scanner[pics];

        int rows = 0, cols = 0, mx = 0;
        for (int i = 0; i < pics; ++i) {
            try {
                scan[i] = new Scanner(file[i]);
                String line = scan[i].nextLine();
                cols = Integer.parseInt(scan[i].next());
                rows = Integer.parseInt(scan[i].next());
                mx = Integer.parseInt(scan[i].next());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        // open output file and print out header

        BufferedWriter output = new BufferedWriter(new FileWriter("clear.ppm"));
        output.write(String.format("%s\n", "P3"));
        output.write(String.format("%d  %d\n", cols, rows));
        output.write(String.format("%d\n", mx));
        System.out.println(rows + ", " + cols + ", " + mx);

        int[] pixelArray = new int[pics];

        for (int i = 0; i < cols; ++i)
            for (int j = 0; j < rows; ++j)
                for (int c = 0; c < 3; c++) {
                    for (int k = 0; k < pics; ++k) {
                        pixelArray[k] = Integer.parseInt(scan[k].next());
                    }
                    int maxPixel = Select.select(pixelArray, 0, pics-1, pics-1);
                    output.write(String.format("%d\n", maxPixel));
                }

        for (int i = 0; i < pics; ++i) {
            scan[i].close();
        }
        output.close();
    }
}
