/*
 * The given code is provided to assist you to complete the required tasks. But the
 * given code is often incomplete. You have to read and understand the given code
 * carefully, before you can apply the code properly.
 */


/*
 * Please review Lecture 7 Algorithms Part III, slides 10-14 to complete this task.
 * */


import java.util.HashMap;
import java.util.HashSet;
import java.util.Collections;

/*
* EditCost defines three character edit costs. INSERT and DELETE will cost 1, and REPLACE will cost 2.
* Do not modify the character edit costs. Otherwise, your answers will not be marked correctly.
* */
enum EditCost
{
    INSERT (1),
    DELETE (1),
    REPLACE (2);

    private final int costValue;

    EditCost(int value) {
        this.costValue = value;
    }

    public int getEditCost(){
        return this.costValue;
    }
}

public class EditDistance {


/* This method computes the minimal total cost of a sequence of character edits between two strings.
 * The costs of character edits are defined in EditCost enum
 * @param seq1 the original string.
 * @param seq2 the target string.
 * @return the minimal cost of the character edits.
 * */
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
                    op_costs.add(EditCost.DELETE.getEditCost() +
                            costTable.get((x_coordinate + 1) + "," + y_coordinate));
                }
                // INSERT op
                if (y_coordinate < Math.abs(y_len)) {
                    op_costs.add(EditCost.INSERT.getEditCost() +
                            costTable.get(x_coordinate + "," + (y_coordinate + 1)));
                }
                // REPLACE op
                if (x_coordinate < Math.abs(x_len) && y_coordinate < Math.abs(y_len)) {
                    // Use existing char to replace (no cost)
                    if (seq1.charAt(x_coordinate) == seq2.charAt(y_coordinate)) {
                        op_costs.add(costTable.get((x_coordinate + 1) + "," + (y_coordinate + 1)));
                    } else {
                        // Cost time to replace
                        op_costs.add(EditCost.REPLACE.getEditCost() +
                                costTable.get((x_coordinate + 1) + "," + (y_coordinate + 1)));
                    }
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
