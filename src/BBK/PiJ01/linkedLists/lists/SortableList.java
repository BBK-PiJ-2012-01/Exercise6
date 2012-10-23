/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BBK.PiJ01.linkedLists.lists;

import BBK.PiJ01.linkedLists.elements.SortableContainer;
import BBK.PiJ01.linkedLists.iterators.SwappingIterator;

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
    
    @Override
    public SwappingIterator<T> getForwardItr() {
        return new ForwardIterator();
    }
    
    @Override
    public SwappingIterator<T> getBackwardItr() {
        return new BackwardIterator();
    }
    
    protected class ForwardIterator extends SwappingIterator<T> {
        @Override
        protected SortableContainer<T> getStartingElement() {
            return first_element;
        }

        @Override
        protected SortableContainer<T> getFinishingElement() {
            return last_element;
        }

        @Override
        protected SortableContainer<T> getNextElement() {
            return getNextElement(next_element);
        }

        @Override
        protected void insertAfterRef(SortableContainer<T> e, SortableContainer<T> ref) {
            insertNextToRef(e, ref);
        }

        @Override
        protected void insertBeforeRef(SortableContainer<T> e, SortableContainer<T> ref) {
            insertPrevToRef(e, ref);
        }
    }
    
    protected class BackwardIterator extends SwappingIterator<T> {
        @Override
        protected SortableContainer<T> getStartingElement() {
            return last_element;
        }

        @Override
        protected SortableContainer<T> getFinishingElement() {
            return first_element;
        }

        @Override
        protected SortableContainer<T> getNextElement() {
            return getPrevElement(next_element);
        }

        @Override
        protected void insertAfterRef(SortableContainer<T> e, SortableContainer<T> ref) {
            insertPrevToRef(e, ref);
        }

        @Override
        protected void insertBeforeRef(SortableContainer<T> e, SortableContainer<T> ref) {
            insertNextToRef(e, ref);
        }
    }
}
