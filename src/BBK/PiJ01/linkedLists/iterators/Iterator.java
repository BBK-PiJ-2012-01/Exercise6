/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BBK.PiJ01.linkedLists.iterators;

import BBK.PiJ01.linkedLists.elements.Element;
import BBK.PiJ01.linkedLists.elements.ElementInterface;
import BBK.PiJ01.linkedLists.lists.BaseLinkedList;

/**
 *
 * @author Sam Wright <swrigh11@dcs.bbk.ac.uk>
 */
public abstract class Iterator <T extends ElementInterface> {
    protected T next_element;
    protected T finishing_element;
    protected T this_element;
    protected T prev_element;
    protected boolean iterating = true;
    
    
    public Iterator() {
        next_element = getStartingElement();
        finishing_element = getFinishingElement();
        if (finishing_element == null)
            iterating = false;
        System.out.format("FINISH: %s", finishing_element);
    }
    
    public boolean hasNext() {
        return iterating;
    }
    
    public T next() {
        System.out.format("prev: %s\t\tthis: %s\t\tnext: %s\n", prev_element,this_element,next_element);
        try {
            Thread.sleep(500);
        } catch(InterruptedException e) {}
        prev_element = this_element;
        this_element = next_element;
        next_element = getNextElement();
        if (this_element == finishing_element)
            iterating = false;
        return this_element;
    }
    
    public void insertAhead(T e) {
        insertAfterRef(e, this_element);
        
        finishing_element = getFinishingElement();
        iterating = true;
        
        next_element = e;
    }
    
    public void insertBehind(T e) {
        insertBeforeRef(e, this_element);
        prev_element = e;
    }
    
    public void swapWith(Iterator itr) {
        // swapWithOneBehind expects that 
        // 'this_element' should come later than 'itr.this_element'
        
        if (prev_element == itr.this_element)
            swapWithOneBehind(itr);
        else if (itr.prev_element == this_element)
            swapWithOneBehind(itr);
        else
            swapWithDistant(itr);
    }
    
    /**
     * This swaps this_element with itr.this_element, where
     * this is one ahead of itr.
     * 
     * @param itr 
     */
    protected void swapWithOneBehind(Iterator itr) {
        // First we swap the element's positions in
        // the actual list.  This doesn't affect either
        // iterators' instance variables.
        try {
            itr.prev_element.setNext(this_element);
        } catch(NullPointerException err1) {
            this_element.setPrev(null);
            setStartingElement(this_element);
        }
        
        this_element.setNext(itr.this_element);
        
        if (next_element == null)
            setFinishingElement((T) itr.this_element);
        itr.this_element.setNext(next_element);
        
        
        
        // Now we change the iterator's instance variables.
        // itr is behind, so only its 'this_element' and
        // 'next_element' change.
        T e = (T) itr.this_element;
        itr.next_element = itr.this_element;
        itr.this_element = this_element;
        
        // this iterator is ahead, so only its 'this_element'
        // and 'prev_element' change.
        prev_element = this_element;
        this_element = e;
    }
    
    protected void swapWithDistant(Iterator itr) {
        // First, we swap the element's positions in
        // the actual list.  This doesn't affect either
        // iterators' instance variables.
        T e_prev = (T) itr.prev_element;
        T e_next = (T) itr.next_element;
        
        try {
            prev_element.setNext(itr.this_element);
        } catch(NullPointerException err1) {
            itr.this_element.setPrev(null);
            setStartingElement((T) itr.this_element);
        }
        
        if (next_element == null)
            setFinishingElement((T) itr.this_element);
        itr.this_element.setNext(next_element);
        
        try{
            itr.prev_element.setNext(this_element);
        } catch (NullPointerException err2) {
            this_element.setPrev(null);
            setStartingElement(this_element);
        }
        
        if (itr.next_element == null)
            setFinishingElement((T) this_element);
        this_element.setNext(itr.next_element);
        
        // Now we change the iterator's instance variables.
        // The iterators stay at the same index in the list,
        // so their next and previous elements are the same.
        // All that changes is this_element.
        T e = (T) itr.this_element;
        itr.this_element = this_element;
        this_element = e;
    }
    
    abstract protected T getStartingElement();
    abstract protected void setStartingElement(T e);
    abstract protected T getFinishingElement();
    abstract protected void setFinishingElement(T e);
    abstract protected T getNextElement();
    abstract protected void setNextElement(T e, T next);
    abstract protected void insertAfterRef(T e, T ref);
    abstract protected void insertBeforeRef(T e, T ref);
}