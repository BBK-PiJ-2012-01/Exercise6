/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BBK.PiJ01.exercise6;

/**
 *
 * @author Sam Wright <swrigh11@dcs.bbk.ac.uk>
 */
public abstract class Iterator <T extends Element> {
    protected Element<T> next_element;
    protected Element<T> finishing_element;
    protected boolean iterating = true;
    
    
    public Iterator() {
        next_element = getStartingElement();
        finishing_element = getFinishingElement();
    }
    
    public boolean hasNext() {
        return iterating && finishing_element!= null;
    }
    
    public T next() {
        T obj_to_return = next_element.getObject();
        next_element = getNextElement();
        if (next_element == finishing_element)
            iterating = false;
        return obj_to_return;
    }
    
    abstract protected Element<T> getStartingElement();
    abstract protected Element<T> getFinishingElement();
    abstract protected Element<T> getNextElement();
}