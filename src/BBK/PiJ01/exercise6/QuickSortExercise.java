/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BBK.PiJ01.exercise6;

import BBK.PiJ01.common.Exercise;
import BBK.PiJ01.linkedLists.lists.SortableList;
import BBK.PiJ01.linkedLists.util.QuickSort;

/**
 *
 * @author Sam Wright <swrigh11@dcs.bbk.ac.uk>
 */
public class QuickSortExercise implements Exercise {
    public String getTitle() {
        return "QuickSort";
    }

    @Override
    public String getDescription() {
        return "Demonstrates quicksort on a random set of integers";
    }
    
    public void run() {
        SortableList<Integer> lst = new SortableList<Integer>();
        
        for (int i=0; i<20; i++) {
            lst.insert((int)Math.abs(Math.random()*1000));
            //lst.insert(i);
        }
        
        QuickSort.ascending(lst);
        
        lst.printUsingItr( lst.getForwardItr() );
    }
    
}
