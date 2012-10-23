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
    
    public void setObject(T obj) {
        this.obj = obj;
    }
    
    public T getObject() {
        return obj;
    }
    
    public int compareTo(SortableContainer<T> other) {
        return obj.compareTo( other.getObject() );
    }
    
    public String toString() {
        return obj.toString();
    }
}
