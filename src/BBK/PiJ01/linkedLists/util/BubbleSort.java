/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BBK.PiJ01.linkedLists.util;

import BBK.PiJ01.linkedLists.elements.ComparableContainer;
import BBK.PiJ01.linkedLists.iterators.Iterator;
import BBK.PiJ01.linkedLists.lists.SortableList;

/**
 *
 * @author Sam Wright <swrigh11@dcs.bbk.ac.uk>
 */
public class BubbleSort {
    static <T extends Comparable<T>> void sort(SortableList<T> lst) {
        Iterator<ComparableContainer<T>> itr_ahead = lst.getForwardItr();
        Iterator<ComparableContainer<T>> itr_behind = lst.getForwardItr();
        
        itr_ahead.next();
        boolean swapped_this_run;
        
        do {
            swapped_this_run = false;
            while (itr_ahead.hasNext()) {
                if (itr_ahead.next().compareTo(itr_behind.next()) < 0) {
                    itr_ahead.swapWith(itr_behind);
                    swapped_this_run = true;
                }
            }
        } while(swapped_this_run);
    }
}
