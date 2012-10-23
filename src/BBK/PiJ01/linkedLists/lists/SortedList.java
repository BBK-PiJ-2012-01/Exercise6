/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BBK.PiJ01.linkedLists.lists;

import BBK.PiJ01.linkedLists.elements.SortableContainer;
import BBK.PiJ01.linkedLists.iterators.Iterator;

/**
 *
 * @author Sam Wright <swrigh11@dcs.bbk.ac.uk>
 */
public class SortedList <T extends Comparable<T>> 
                        extends BaseLinkedList<SortableContainer<T>> {
    
    public void insert(T value) {
        Iterator<SortableContainer<T>> itr = getForwardItr();
        SortableContainer<T> new_value_obj = new SortableContainer<T>(value);
        
        while (itr.hasNext()) {
            if (itr.next().compareTo(new_value_obj) > 0) {
                itr.insertBehind(new_value_obj);
                return;
            }
        }
        addElement(new_value_obj);
    }
}