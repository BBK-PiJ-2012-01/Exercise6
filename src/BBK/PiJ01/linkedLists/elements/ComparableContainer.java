/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BBK.PiJ01.linkedLists.elements;

/**
 *
 * @author Sam Wright <swrigh11@dcs.bbk.ac.uk>
 */
public class ComparableContainer <T extends Comparable<T>> extends Container<T> 
                            implements Comparable<ComparableContainer<T>> {
    public ComparableContainer(T obj) {
        super(obj);
    }
    
    public int compareTo(ComparableContainer<T> other) {
        return obj.compareTo( other.getObject() );
    }
}
