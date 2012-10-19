/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BBK.PiJ01.exercise6;

/**
 *
 * @author Sam Wright <swrigh11@dcs.bbk.ac.uk>
 */
public class Element extends AbstractElement {
    protected AbstractElement next;
    
    public void setNext(AbstractElement next) {
        this.next = next;
    }
    
    public AbstractElement getNext() {
        return next;
    }
    
    public void setPrev(AbstractElement e) {}
    public AbstractElement getPrev() {return null;}
}


abstract class AbstractElement {
    abstract public void setNext(AbstractElement e);
    abstract public void setPrev(AbstractElement e);
    
    abstract public AbstractElement getNext();
    abstract public AbstractElement getPrev();
}