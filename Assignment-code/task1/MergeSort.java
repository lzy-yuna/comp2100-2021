/*
 * The given code is provided to assist you to complete the required tasks. But the
 * given code is often incomplete. You have to read and understand the given code
 * carefully, before you can apply the code properly.
 */


/*
* Please review Lecture 5 Algorithms Part I, slide 20 to complete this task.
* */
public class MergeSort {

    /**
     * Sorts an array [1...n] by divide-and-conquer. It must use merge() method.
     *
     * @param input array a needs to be sorted.
     */
    public static void mergeSort(int[] a) {
        /*  */
        int[] L = null; // This array will store the left half of array 
        int[] R = null; // This array will store the right half of array 
        // TODO: Complete this method
        // START YOUR CODE
        // initialize left and right arrays
        L = new int[Math.round(a.length / 2f)];
        R = new int[a.length - L.length];
        // copy data into arrays
        System.arraycopy(a, 0, L, 0, L.length);
        System.arraycopy(a, L.length, R, 0, R.length);
        // if the length of separated array is larger than 1, recursive call
        if (L.length > 1)
            mergeSort(L);
        if (R.length > 1)
            mergeSort(R);
        // END YOUR CODE
        merge(a,L,R); //Do not modify this part of code.
    }


    /**
     * Merges sorted subarray L and subarray R into sorted array a.
     *
     * @param merged array a,
     * @param input sorted subarray L,
     * @param input sorted subarray R.
     */
    public static void merge(int[] a, int[] L, int[] R) {

        tracker.calltracking(a,L,R); //Do not modify this method. Otherwise, you will be penalized for violation.
        // TODO: Complete this method
        // START YOUR CODE
        
        // If left or right is empty, the array a should be identical to the non-empty one
        if (L.length == 0 || R.length == 0) {
            return;
        } else {
            // x for counter of L, y for counter of R, z for counter of a
            int x = 0, y = 0, z = 0;
            do {
                if (L[x] < R[y]) {
                    a[z] = L[x];
                    x++;
                } else {
                    a[z] = R[y];
                    y++;
                }
                z++;
            } while (x < L.length && y < R.length);

            // adding remaining elements to a
            if (y >= R.length) {
                while (x < L.length) {
                    a[z] = L[x];
                    x++;
                    z++;
                }
            } else {
                while (y < R.length) {
                    a[z] = R[y];
                    y++;
                    z++;
                }
            }
        }
        // END YOUR CODE
    }
}