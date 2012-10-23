/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BBK.PiJ01.linkedLists.elements;

/**
 *
 * @author Sam Wright <swrigh11@dcs.bbk.ac.uk>
 */
public class DoublyElement implements ElementInterface {
    protected ElementInterface prev;
    protected ElementInterface next;
    
    public void setPrev(ElementInterface prev) {
        this.prev = prev;

        if (prev != null && prev.getNext() != this) {
            if (prev != null)
                prev.setNext(this);
        }
    }
    
    public void setNext(ElementInterface next) {
        this.next = next;

        if (next != null && next.getPrev() != this) {
            if (next != null)
                next.setPrev(this);
        }
    }
    
    @Override
    public ElementInterface getPrev() {
        return prev;
    }
    
    @Override
    public ElementInterface getNext() {
        return next;
    }
}