/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BBK.PiJ01.linkedLists.util;

import BBK.PiJ01.linkedLists.iterators.SwappingIterator;
import BBK.PiJ01.linkedLists.lists.SortableList;

/**
 *
 * @author Sam Wright <swrigh11@dcs.bbk.ac.uk>
 */
public class BubbleSort {
    static public <T extends Comparable<T>> void ascending(SortableList<T> lst) {
        while(sortLoop(lst, true, true)) {}
    }
    
    static public <T extends Comparable<T>> void descending(SortableList<T> lst) {
        while(sortLoop(lst, true, false)) {}
    }
    
    static public <T extends Comparable<T>> boolean sortLoop(SortableList<T> lst, boolean forwards, boolean ascending) {
        SwappingIterator<T> itr_ahead;
        SwappingIterator<T> itr_behind;
        boolean swapped_this_run = false;
        
        if (forwards) {
            itr_ahead = lst.getForwardItr();
            itr_behind = lst.getForwardItr();
        } else {
            itr_ahead = lst.getBackwardItr();
            itr_behind = lst.getBackwardItr();
        }
        itr_ahead.next();

        while (itr_ahead.hasNext()) {
            if (itr_ahead.next().compareTo(itr_behind.next()) < 0 ^ascending^forwards) {
                itr_ahead.swapWith(itr_behind);
                swapped_this_run = true;
            }
        }
        return swapped_this_run;
    }
}
