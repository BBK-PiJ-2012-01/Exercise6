/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BBK.PiJ01.linkedLists.lists;

import BBK.PiJ01.linkedLists.elements.DoublyElement;

/**
 *
 * @author Sam Wright <swrigh11@dcs.bbk.ac.uk>
 */
public class DoublyLinkedList <T extends DoublyElement> extends BaseLinkedList<T> {
    public void add(T e) {
        addElement(e);
    }
    
    public void delete(T e) {
        deleteElement(e);
    }
    
    @Override
    protected void cleanDeletedElement(T e) {
        e.setNext(null);
        e.setPrev(null);
    }
    
    @Override
    protected T getPrevElement(T e) {
        return (T) e.getPrev();
    }
}
    