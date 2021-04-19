/*
 * DNA sequence characters {'A','C','G','T'} are indexed by {0, 1, 2, 3} respectively.
 * 
 * The Replace costs are defined in replaceMatrix.
 * For example, replaceMatrix[1][0] is the cost when 'C' is replaced by 'A'.
 * 
 * The Insert costs are defined in insertMatrix.
 * For example, insertMatrix[1] is the cost when 'C' is inserted.
 *
 * The Delete costs are defined in deleteMatrix.
 * For example, deleteMatrix[1] is the cost when 'C' is deleted.   
 */

public class EditCost {
		
	// The values of edit costs may be changed in marking.
    private static int[][] replaceMatrix = {{0,3,2,1},{3,0,1,2},{2,1,0,3},{1,2,3,0}};
    private static int[] insertMatrix = {1,1,2,3};
    private static int[] deleteMatrix = {2,2,1,1};
    private static char[] DNASequence = {'A','C','G','T'};


    public static int convertToIndex(char c){
        switch(c){
            case 'A':
                return 0;
            case 'C':
                return 1;
            case 'G':
                return 2;
            case 'T':
                return 3;
        }
        return -1;
    }

    public static int getReplaceCost(int indexX, int indexY){
        return replaceMatrix[indexX][indexY];
    }

    public static int getInsertCost(int indexX){
        return insertMatrix[indexX];
    }

    public static int getDeleteCost(int indexX){
        return deleteMatrix[indexX];
    }

}
