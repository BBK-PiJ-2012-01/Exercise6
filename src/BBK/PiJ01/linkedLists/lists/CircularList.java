/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BBK.PiJ01.linkedLists.lists;

import BBK.PiJ01.linkedLists.elements.ElementInterface;

/**
 *
 * @author Sam Wright <swrigh11@dcs.bbk.ac.uk>
 */
public class CircularList <T extends ElementInterface> extends BaseLinkedList<T> {
    public void add(T e) {
        addElement(e);
        e.setNext(first_element);
    }
    
    @Override
    protected T popEndElement() {
        T popped = super.popEndElement();
        last_element.setNext(first_element);
        return popped;
    }
    
    @Override
    protected void setAsOnlyElement(T e) {
        super.setAsOnlyElement(e);
        e.setNext(e);
    }
    
    public void delete(T e) {
        deleteElement(e);
    }
}