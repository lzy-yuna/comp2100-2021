/*
* This class is for marking purpose. Do not modify any code associated with the tracker.
* */

public class tracker {
    public static int counter = 0;
    public static String Ls = "";

    public static void calltracking(int[] a, int[] L, int[] R){
        counter++;
        for(int i : L){
            Ls+=i+"";
        }
    }
}
