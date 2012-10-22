/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BBK.PiJ01.linkedLists.elements;

/**
 *
 * @author Sam Wright <swrigh11@dcs.bbk.ac.uk>
 */
public class Element implements ElementInterface {
    protected ElementInterface next;
    
    public void setNext(ElementInterface next) {
        this.next = next;
    }
    
    public ElementInterface getNext() {
        return next;
    }
    
    public void setPrev(ElementInterface e) {}
    public ElementInterface getPrev() {return null;}
}


