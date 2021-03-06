/**
 * The calculateMark method must return the MarkGrade based on the following:
 * 
 * + The "lab", "Assignment1" and "Assignment2" marks are between 0 and 10 (inclusive).
 * + The "FinalExam" is between 0 and 100 (inclusive).
 * 
 * If any of these components are not within the expected range 
 * then a ComponentOutOfRangeException is thrown.
 * 
 * If a student does not attend the final exam (attendedFinal will be false) 
 * then a grade of NCN should be given and
 * the final mark must be set to null.
 * 
 * The lab mark is worth 10% of the final grade and marked out of 10, 
 * the assignments are worth 15% each of the final grade and marked out of 10, and
 * the final exam is worth 60% and marked out of 100. These marks are combined EXACTLY 
 * and then rounded to produce an integer out of 100 (round up for values exactly 
 * half way between integer values). Once this is done
 * the grade can be determined using the following ranges:
 *  + 0 ~ 44 : N
 *  + 45 ~ 49 : PX
 *  + 50 ~ 59 : P
 *  + 60 ~ 69 : C
 *  + 70 ~ 79 : D
 *  + 80 ~ 100 : HD
 *  
 * This calculateMark does not represent the way you will be assessed in this course. 
 * This is just a simple task to understand how software testing works. 
 *  
 */
public interface MarkCalculator {
    MarkGrade calculateMark(int lab, int assignment1, int assignment2, int finalexam, boolean attendedFinal) throws ComponentOutOfRangeException; 
}
