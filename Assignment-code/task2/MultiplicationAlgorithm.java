/*
 * The given code is provided to assist you to complete the required tasks. But the
 * given code is often incomplete. You have to read and understand the given code
 * carefully, before you can apply the code properly.
 */


/*
 * Please review Lecture 5 Algorithms Part I, slide 49 to complete this task.
 * */

public class MultiplicationAlgorithm {

    /**
     * Using divide-and-conquer to implement the Karatsuba multiplication to compute the product x times y. 
	 * x and y are two n-digit input numbers.
     *
     * @param input x
     * @param input y
     */
    public static long KMultiply(long x, long y){
        // TODO: Complete this method
        tracker.calltracking(x,y); //Do not modify this method. Otherwise, you will be penalized for violation.
        // START YOUR CODE
        long digit_length = Long.toString(x).length();

        if (digit_length == 1) {
            return x * y;
        } else {
            // half of the number length, use number rounding here
            long half_length =  Math.round(digit_length / 2d);
            long multiplier = (long) Math.pow(10,half_length);
            long b = x % multiplier;
            long d = y % multiplier;
            long a = (x - b) / multiplier;
            long c = (y - d) / multiplier;

            // recursive calculate the a * c
            long axc = KMultiply(a, c);
            // recursive calculate the b * d
            long bxd = KMultiply(b, d);
            // recursive calculate the (a + b) * (c + d)
            long a_bxc_d = KMultiply(a + b, c + d);
            // calculate a * d - c * b by (a + b) * (c + d) - a * c - b * d
            long axd_cxb = a_bxc_d - axc - bxd;

            return ((long) (axc * Math.pow(10, half_length * 2))) + axd_cxb * multiplier + bxd;
        }
        // END YOUR CODE
    }
}
