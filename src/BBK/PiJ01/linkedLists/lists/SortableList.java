/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BBK.PiJ01.linkedLists.lists;

import BBK.PiJ01.linkedLists.elements.SortableContainer;

/**
 *
 * @author Sam Wright <swrigh11@dcs.bbk.ac.uk>
 */
public class SortableList <T extends Comparable<T>> 
                        extends BaseLinkedList<SortableContainer<T>> {
    
    public void insert(T value) {
        addElement(new SortableContainer<T>(value));
    }
    
    @Override
    protected void cleanDeletedElement(SortableContainer<T> e) {
        e.setNext(null);
        e.setPrev(null);
    }
    
    @Override
    protected SortableContainer<T> getPrevElement(SortableContainer<T> e) {
        if (e.getPrev() == null)
            return null;
        return (SortableContainer<T>) e.getPrev();
    }
}
