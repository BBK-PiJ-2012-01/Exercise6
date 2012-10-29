/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BBK.PiJ01.exercise6;

import BBK.PiJ01.common.BadInput;
import BBK.PiJ01.common.Exercise;
import BBK.PiJ01.common.ExerciseChooser;
import java.util.ArrayList;

/**
 *
 * @author Sam Wright <swrigh11@dcs.bbk.ac.uk>
 */
public class Exercise6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws BadInput {
        ArrayList<Exercise> exercises = new ArrayList<Exercise>();
        
        exercises.add(new SpyExercise());
        exercises.add(new DoWhilePractise());
        exercises.add(new DoublyLinkedListExercise());
        exercises.add(new CircularListExercise());
        exercises.add(new QueuesExercise());
        exercises.add(new StacksExercise());
        exercises.add(new ArrayToList());
        exercises.add(new SortedListExercise());
        exercises.add(new BubbleSortExercise());
        exercises.add(new CocktailSortExercise());
        exercises.add(new QuickSortExercise());
        exercises.add(new SortComparison());
        
        ExerciseChooser ech = new ExerciseChooser(exercises);
        ech.run();
    }
}
