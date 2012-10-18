/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BBK.PiJ01.exercise6;

/**
 *
 * @author Sam Wright <swrigh11@dcs.bbk.ac.uk>
 */
abstract public class Element <T> {
    private Element<T> next;
    private T obj;
    
    public Element(T obj) {
        this.obj = obj;
    }
    
    public void setNext(Element<T> next) {
        this.next = next;
    }
    
    public Element<T> getNext() {
        return next;
    }
    
    public T getObject() {
        return obj;
    }
    
    abstract public String toString();
}

