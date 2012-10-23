/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BBK.PiJ01.linkedLists.elements;

/**
 *
 * @author Sam Wright <swrigh11@dcs.bbk.ac.uk>
 */
public class SortableContainer <T extends Comparable<T>> extends DoublyElement 
                            implements Comparable<SortableContainer<T>>,
                                        ContainerInterface<T> {
    T obj;
    
    public SortableContainer(T obj) {
        setObject(obj);
    }
    
    @Override
    public SortableContainer<T> getPrev() {
        return (SortableContainer<T>) prev;
    }
    
    @Override
    public SortableContainer<T> getNext() {
        return (SortableContainer<T>) next;
    }
    
    public void setObject(T obj) {
        this.obj = obj;
    }
    
    public T getObject() {
        return obj;
    }
    
    public int compareTo(SortableContainer<T> other) {
        return obj.compareTo( other.getObject() );
    }
    
    public void swapWith(SortableContainer<T> other) {
        T old_obj = obj;
        obj = other.getObject();
        other.setObject(old_obj);
    }
    
    public String toString() {
        return obj.toString();
    }
}
