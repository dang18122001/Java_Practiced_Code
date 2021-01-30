import java.util.Arrays;
import java.util.Scanner;

public class SumsTo {

    static String number = "";
    static String output = "";

    /*
    The two methods takes two parameters: a String of digits and an integer sum.
    The methods will  determines if +’s can be inserted into a string of digits
        so that the resulting arithmetic expression sums to a given number.
    The methods will return a String of digits and appropriate "+".
     */

    // Method 1 is used for sorted input string.
    public void toSumMethod1(String firstString, String sum) {

        // Base case: Stack.size = 0.
        if (firstString.equals("")) {
            if (sum.equals(number))
                output = number.concat(output);
            else
                output = "false";
        }

        // Recursive case:
        else {
            String lastElement = firstString.substring(firstString.length() - 1);
            firstString = firstString.substring(0, firstString.length() - 1);
            number = lastElement.concat(number);

            if (Long.parseLong(number) > Long.parseLong(sum)) {
                firstString = firstString.concat(number.substring(0, 1));
                number = number.substring(1);
                long newSum = Long.parseLong(sum) - Long.parseLong(number);
                sum = String.valueOf(newSum);
                output = number.concat(output);
                output = " + ".concat(output);
                number = "";
            }
            toSumMethod1(firstString, sum);
        }
    }

    // Method 2 is used for unsorted input string.
    public String toSumMethod2(String firstString, long sum) {
        for (int i = 1; i < firstString.length() - 1; i++) {

            // Create two substrings which store two parts of the input string.
            String substring1 = firstString.substring(0, i);
            String substring2 = firstString.substring(i);

            // Check if the sum of two substrings is equal to sum.
            if (Long.parseLong(substring1) + Long.parseLong(substring2) == sum)
                return substring1 + " + " + substring2;

            // Create new value of sum = sum - substring1.
            long newSum = sum - Long.parseLong(substring1);

            // Check if other variances of substring2 plus substring1 is equal to sum.
            if (Long.parseLong(substring1) < sum &&
                    !toSumMethod2(substring2, newSum).equals("false"))
                return substring1 + " + " + toSumMethod2(substring2, newSum);
        }

        // If all of the variances are not acceptable, return false.
        return "false";
    }

    // Main function.
    public static void main(String[] args) {

        // Create scanner.
        Scanner scan = new Scanner(System.in);

        // Take first input as firstString.
        String firstInput = scan.next();

        // Take second input as sum.
        long secondInput = scan.nextLong();

        // Create an object of SumsTo.
        SumsTo obj = new SumsTo();

        // Create a char array of firstInput.
        char[] firstInputArray = firstInput.toCharArray();

        // Create a copy of firstInputArray.
        char[] firstInputArrayTemp = new char[firstInputArray.length];
        System.arraycopy(firstInputArray, 0, firstInputArrayTemp, 0, firstInputArray.length);

        // Sort firstInputArrayTemp.
        Arrays.sort(firstInputArrayTemp);

        // Run toSum function to get the output.
        // If firstInput is a sorted string, use toSumMethod1.
        if (Arrays.equals(firstInputArray, firstInputArrayTemp)) {

            obj.toSumMethod1(firstInput, String.valueOf(secondInput));
            System.out.println(output);
        }

        // If firstInput is not a sorted string, use toSumMethod2.
        else
            System.out.println(obj.toSumMethod2(firstInput, secondInput));
        }
    }
