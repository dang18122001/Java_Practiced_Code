public class RecursiveMultiply {

    public static long multiplyTwoIntegers(long a, long b) {

        // Base case: a = 1;
        if (a == 1)
            return b;

        // Recursion;
        if (a % 2 != 0)
            return b + multiplyTwoIntegers(a/2, b + b);
        else
            return multiplyTwoIntegers(a/2, b + b);
    }

    static boolean xxx(int[] a, int n) {
        if (n <= 1)
            return false;
        for (int i = 0; i < n - 2; ++i)
            for (int j = i; j < n - 1; ++j)
                if (a[i] + a[j] == a[n - 1])
                    return true;
        return xxx(a, n - 1);
    }

    public static void main(String[] args) {

//        RecursiveMultiply a = new RecursiveMultiply();
//        long outputNumber = a.multiplyTwoIntegers(20000000, 20000000);
//        System.out.println(outputNumber);
        final long start = System.currentTimeMillis();
        System.out.println(multiplyTwoIntegers(7, 9));
        final long end = System.currentTimeMillis();
        long total = end - start;
        System.out.println(total + "ms");
//        int[] a = {4, 9, 2, 1, 7, 6};
//        System.out.println(xxx(a, 6));
    }
}

