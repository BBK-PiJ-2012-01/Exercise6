/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BBK.PiJ01.exercise6;

import BBK.PiJ01.common.Exercise;
import BBK.PiJ01.linkedLists.elements.ComparableContainer;
import BBK.PiJ01.linkedLists.iterators.Iterator;

/**
 *
 * @author Sam Wright <swrigh11@dcs.bbk.ac.uk>
 */
public class BubbleSortExercise implements Exercise {
    public String getTitle() {
        return "Bubble sort";
    }
    
    public String getDescription() {
        return "Demonstrates a bubble sort of a linked-list of\n"
                + "a list of randomly-generated integers.";
    }
    
    public void run() {
        
        Iterator<ComparableContainer<Integer>> itr = getForwardItr();
        ComparableContainer<T> new_value_obj = new ComparableContainer<T>(value);
        
        while (itr.hasNext()) {
            if (itr.next().compareTo(new_value_obj) > 0) {
                itr.insertBehind(new_value_obj);
                return;
            }
        }
        addElement(new_value_obj);
    }
}

