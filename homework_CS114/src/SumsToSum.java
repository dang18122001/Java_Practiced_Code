import java.util.*;
public class SumsToSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //The input is a line containing two strings of digits, each of length at most 18.
        String start = sc.next(); // digit string we may insert "+" into
        long goal = sc.nextLong(); // the sum we want to obtain
        String expr = "";
        String res = getRes(start, goal);
        // System.out.println(goal+", "+res);
        if (res != null) {
            System.out.println(res);
            // print out the arithmetic expression
        } else
            System.out.println(res);
    }
    private static String getRes(String start, long goal) {
        int length = start.length();
        for(int i=1; i<length-1;i++) {
            String str1 = start.substring(0,i);
            String str2 = start.substring(i);
            if (Long.parseLong(str1)+Long.parseLong(str2) == goal )
                return str1 + " + " + str2;
            if ( Long.parseLong(str1) < goal && !getRes(str2, goal-Long.parseLong(str1)).equals("false")) {
                return str1 + " + " + getRes(str2, goal-Long.parseLong(str1));
            }
        }
        return "false";
    }


}
