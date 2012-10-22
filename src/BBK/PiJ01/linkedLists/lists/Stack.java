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

public class Stack <T> extends BaseLinkedList<Container<T>> {
    public void push(T obj) {
        addElement(new Container<T>(obj));
    }
    
    public T pop() {
        return popEndElement().getObject();
    }
    
    public boolean empty() {
        return number_of_elements == 0;
    }
}