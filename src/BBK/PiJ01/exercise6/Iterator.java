/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BBK.PiJ01.exercise6;

/**
 *
 * @author Sam Wright <swrigh11@dcs.bbk.ac.uk>
 */
public abstract class Iterator <T extends AbstractElement> {
    protected T next_element;
    protected T finishing_element;
    protected boolean iterating = true;
    
    
    public Iterator() {
        next_element = getStartingElement();
        finishing_element = getFinishingElement();
        if (finishing_element == null)
            iterating = false;
    }
    
    public boolean hasNext() {
        return iterating;
    }
    
    public T next() {
        T element_to_return = next_element;
        next_element = getNextElement();
        if (element_to_return == finishing_element)
            iterating = false;
        return element_to_return;
    }
    
    abstract protected T getStartingElement();
    abstract protected T getFinishingElement();
    abstract protected T getNextElement();
}