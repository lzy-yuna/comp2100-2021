import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Skeleton code for Edit Distance Computation of DNA sequences.
 * The DNA sequence consists of four characters only: {A, C, G, T}.
 * You are required to implement the minDistance method by dynamic programming.
 * The edit costs are defined in EditCost class.
 *
 * The given code is provided to assist you to complete the required tasks. But the 
 * given code is often incomplete. You have to read and understand the given code 
 * carefully, before you can apply the code properly. You might need to implement 
 * additional procedures, such as error checking and handling, in order to apply the 
 */

public class EditDistance {

    /* Compute the minimal total cost of character edits between two DNA sequences by dynamic programming.
     * 
     * @param seq1 the original sequence.
     * @param seq2 the target sequence.
     * @return the minimal cost of the character edits.
     */
    public static int minDistance(String seq1, String seq2){
        // TODO: Complete this method
        // START YOUR CODE
        int x_len = seq1.length();
        int y_len = seq2.length();
        int iteration = (x_len + 1) * (y_len + 1);

        // where the lowest cost from (x,y) to destination is stored
        HashMap<String, Integer> costTable = new HashMap<>();
        // initialize values for costTable
        for (int i = 0; i <= x_len; i++) {
            for (int j = 0; j <= y_len; j++) {
                String key = i + "," + j;
                int cost;
                if (i == x_len && j == y_len) {
                    cost = 0;
                } else {
                    cost = Integer.MAX_VALUE;
                }
                costTable.put(key, cost);
            }
        }
        // update values inside costTable
        for (int i = 0; i < iteration; i++) {
            for (String s : costTable.keySet()) {
                // get the current coordinates
                int x_coordinate = Integer.parseInt(s.split(",")[0]);
                int y_coordinate = Integer.parseInt(s.split(",")[1]);
                HashSet<Integer> op_costs = new HashSet<>();
                // DELETE op
                if (x_coordinate < Math.abs(x_len)) {
                    char current = seq1.charAt(x_coordinate);
                    op_costs.add(EditCost.getDeleteCost(EditCost.convertToIndex(current)) +
                            costTable.get((x_coordinate + 1) + "," + y_coordinate));
                }
                // INSERT op
                if (y_coordinate < Math.abs(y_len)) {
                    char current = seq2.charAt(y_coordinate);
                    op_costs.add(EditCost.getInsertCost(EditCost.convertToIndex(current)) +
                            costTable.get(x_coordinate + "," + (y_coordinate + 1)));
                }
                // REPLACE op
                if (x_coordinate < Math.abs(x_len) && y_coordinate < Math.abs(y_len)) {
                    // Use existing char to replace (no cost)
                    char c1 = seq1.charAt(x_coordinate);
                    char c2 = seq2.charAt(y_coordinate);
                    op_costs.add(EditCost.getReplaceCost(EditCost.convertToIndex(c1), EditCost.convertToIndex(c2)) +
                            costTable.get((x_coordinate + 1) + "," + (y_coordinate + 1)));
                }
                // if there is possible operation, update the lowest cost to costTable
                if (op_costs.size() != 0) {
                    costTable.put(s, Collections.min(op_costs));
                }
            }
        }
        // return the lowest cost from (0,0) to destination
        return costTable.get("0,0");
        // END YOUR CODE

    }

}