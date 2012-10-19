/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BBK.PiJ01.exercise6;

/**
 *
 * @author Sam Wright <swrigh11@dcs.bbk.ac.uk>
 */
public class Container <T> extends Element{
    private Element prev;
    private T obj;
    
    public Container(T obj) {
        this.obj = obj;
    }
    
    @Override
    public T getObject() {
        return obj;
    }
    
    public String toString() {
        return obj.toString();
    }
}