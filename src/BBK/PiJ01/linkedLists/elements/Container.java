/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BBK.PiJ01.linkedLists.elements;

import BBK.PiJ01.linkedLists.elements.Element;

/**
 *
 * @author Sam Wright <swrigh11@dcs.bbk.ac.uk>
 */
public class Container <T> extends Element {
    protected Element prev;
    protected T obj;
    
    public Container(T obj) {
        this.obj = obj;
    }
    
    public T getObject() {
        return obj;
    }
    
    public String toString() {
        return obj.toString();
    }
}