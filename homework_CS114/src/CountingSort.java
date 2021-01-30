public class CountingSort {
    public void intSort(int[] arr, int a, int b) {
        // Find the length of arr.
        int n = arr.length;
        int k = b - a + 1;

        // Create count array with all elements = 0.
        int[] count = new int[k];
        for (int i = 0; i < k; i++)
            count[i] = 0;

        // Modify count that store the count of each element in range.
        for (int value : arr) count[value - a]++;

        // Modify the count array such that each element at each index
        //  stores the sum of previous counts.
        for (int i = 1; i < k; i++)
            count[i] = count[i] + count[i-1];

        // Create output array, and store output to it.
        int[] output = new int[n];
        for (int j : arr) {
            output[count[j - a] - 1] = j;
            count[j - a]--;
        }

        // Copy output to arr.
        System.arraycopy(output, 0, arr, 0, n);
    }

    public static void main(String[] args) {
        CountingSort obj = new CountingSort();
        int[] inputArray = {1, 4, 1, 2, 7, 5, 2, 7, 15, 20, 7, 16, 24, 6, 13, 16, 18, 7, 22, 20, 14};
        obj.intSort(inputArray, 1, 30);
        for (int j : inputArray) System.out.print(j + " ");
    }
}
