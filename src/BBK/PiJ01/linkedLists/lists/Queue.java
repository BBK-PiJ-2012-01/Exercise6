/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BBK.PiJ01.linkedLists.lists;

import BBK.PiJ01.linkedLists.elements.Container;

/**
 *
 * @author Sam Wright <swrigh11@dcs.bbk.ac.uk>
 */
public class Queue <T> extends BaseLinkedList<Container<T>> {
    public void insert(T obj) {
        addElement(new Container<T>(obj));
    }
    
    public T retrieve() {
        return popStartElement().getObject();
    }
    
    public int size() {
        return number_of_elements;
    }
}