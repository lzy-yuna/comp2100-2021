/**
 * Skeleton code for Binary Search.
 * You are required to implement the binary search method using proper recursion.
 *
 * The given code is provided to assist you to complete the required tasks. But the 
 * given code is often incomplete. You have to read and understand the given code 
 * carefully, before you can apply the code properly. You might need to implement 
 * additional procedures, such as error checking and handling, in order to apply the 
 * code properly.
 */

public class BinarySearch<T extends Comparable<T>>{

    /*
	 * Given a sorted 2D matrix A (sorted in all columns and rows) and a target key, implement 
	 * the search method to find and return the Element with the key that matches the target 
	 * within the range [minX, maxX]x[minY, maxY], otherwise return null.
     * You must use binary search with proper recursion in the columns and rows of A simultaneously.      
	 * 
     * @param A is a sorted 2d array, such that A[i][0].key < ...< A[i][n-1].key and A[0][j].key < ...< A[n-1][j].key for all i, j
     * @param minX is the minimum index in the first coordinate to be searched in A
     * @param maxX is the maximum index in the first coordinate to be searched in A
     * @param minY is the minimum index in the second coordinate to be searched in A
     * @param maxY is the maximum index in the second coordinate to be searched in A
     * @param target is the target key
     * @return the object with the matched key if exist, otherwise return null.
     */
    public Element<T> search(Element<T>[][] A, int minX, int maxX, int minY, int maxY, T target){
        tracker.calltracking(minX,maxX,minY,maxY); //Do not modify this method. Otherwise, your answers may not be marked correctly
        // TODO: Complete this method
        // START YOUR CODE
        if (minX > maxX || minY > maxY) {
            return null;
        }
        if (target.compareTo(A[minX][minY].key) < 0 || target.compareTo(A[maxX][maxY].key) > 0)
            return null;

        T lower_left = A[minX][maxY].key;
        if (lower_left.compareTo(target) == 0) {
            return A[minX][maxY];
        } else if (lower_left.compareTo(target) < 0) {
            return search(A, minX + 1, maxX, minY, maxY, target);
        } else {
            return search(A, minX, maxX, minY, maxY - 1, target);
        }
        // END YOUR CODE
    }
}