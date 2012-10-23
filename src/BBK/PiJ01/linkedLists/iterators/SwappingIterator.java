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
    public void swapWith(SwappingIterator<T> that) {
        T this_old_obj = this_element.getObject();
        this_element.setObject(that.this_element.getObject());
        that.this_element.setObject(this_old_obj);
    }
}
