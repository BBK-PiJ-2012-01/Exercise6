/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BBK.PiJ01.linkedLists.util;

import BBK.PiJ01.common.BadInput;
import BBK.PiJ01.common.IOGeneric;
import BBK.PiJ01.linkedLists.elements.SortableContainer;
import BBK.PiJ01.linkedLists.iterators.SwappingIterator;
import BBK.PiJ01.linkedLists.lists.SortableList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sam Wright <swrigh11@dcs.bbk.ac.uk>
 */
public class QuickSort {
    static private <T extends Comparable<T>> SortableContainer<T> partition(
                                SortableList<T> lst,
                                SortableContainer<T> first,
                                SortableContainer<T> last,
                                SortableContainer<T> pivot) {
        // We need two iterators:
        //  * One to mark where the pivot should be
        //  * And that goes through the list finding
        //    elements to compare to the pivot.
        
        last.swapWith(pivot);
        
        SwappingIterator<T> pivot_placeholder_itr = lst.getForwardItr(first, last.getPrev());
        SortableContainer<T> new_pivot_container = pivot_placeholder_itr.next();
        SwappingIterator<T> checker = lst.getForwardItr(first, last.getPrev());
        
        while (checker.hasNext()) {
            if (checker.next().compareTo(last) < 0) {
                pivot_placeholder_itr.swapWith(checker);
                new_pivot_container = pivot_placeholder_itr.next();
            }
        }
        new_pivot_container.swapWith(last);
        return new_pivot_container;
    }
    
    static private <T extends Comparable<T>> void quicksort(
                                SortableList<T> lst,
                                SortableContainer<T> first,
                                SortableContainer<T> last) {
        if (first != last) {
            // Since we don't know the number of elements
            // between first and last, and even if we did
            // we'd still need to iterate through the list
            // to find eg. the middle element, we will just
            // choose the first element as the pivot.
            SortableContainer<T> pivot = first;
            
            // Partition the list so that all elements before
            // the pivot are smaller than it, and all elements
            // after the pivot are larger than it.
            pivot = partition(lst, first, last, pivot);
            
            // quicksort the smaller elements
            if (first != pivot)
                quicksort(lst, first, pivot.getPrev());
            
            // quicksort the larger elements
            if (pivot != last)
                quicksort(lst, pivot.getNext(), last);
        }
    }
    
    static public <T extends Comparable<T>> void ascending(SortableList<T> lst) {
        SortableContainer<T> first = lst.getForwardItr().next();
        SortableContainer<T> last = lst.getBackwardItr().next();
        
        quicksort(lst, first, last);
    }
}
