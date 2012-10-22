/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BBK.PiJ01.linkedLists.lists;

import BBK.PiJ01.linkedLists.elements.ComparableContainer;
import BBK.PiJ01.linkedLists.iterators.Iterator;

/**
 *
 * @author Sam Wright <swrigh11@dcs.bbk.ac.uk>
 */
public class SortedList <T extends Comparable<T>> 
                        extends BaseLinkedList<ComparableContainer<T>> {
    
    public void insert(T value) {
        Iterator<ComparableContainer<T>> itr = getForwardItr();
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