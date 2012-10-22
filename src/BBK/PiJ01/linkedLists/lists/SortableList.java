/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BBK.PiJ01.linkedLists.lists;

import BBK.PiJ01.linkedLists.elements.ComparableContainer;

/**
 *
 * @author Sam Wright <swrigh11@dcs.bbk.ac.uk>
 */
public class SortableList <T extends Comparable<T>> 
                        extends BaseLinkedList<ComparableContainer<T>> {
    
    public void insert(T value) {
        addElement(new ComparableContainer<T>(value));
    }
}
