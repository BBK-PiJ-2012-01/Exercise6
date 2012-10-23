/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BBK.PiJ01.linkedLists.iterators;

import BBK.PiJ01.linkedLists.elements.SortableContainer;

/**
 *
 * @author Sam Wright <swrigh11@dcs.bbk.ac.uk>
 */
public abstract class SwappingIterator <T extends Comparable<T>> extends Iterator<SortableContainer<T>> {
    public SwappingIterator(SortableContainer<T> first, SortableContainer<T> last) {
        super(first, last);
    }
    
    public void swapWith(SwappingIterator<T> that) {
        this_element.swapWith(that.this_element);
    }
    
    public void swapWith(SortableContainer<T> that_element) {
        this_element.swapWith(that_element);
    }
}
