/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BBK.PiJ01.exercise6;

/**
 *
 * @author Sam Wright <swrigh11@dcs.bbk.ac.uk>
 */
public abstract class AbstractLinkedList <T extends AbstractElement> {
    protected T first_element;
    protected T last_element;
    protected int number_of_elements = 0;
    
    
    protected void addElement(T new_element) {
        
        
        if (last_element != null) {
            last_element.setNext(new_element);
            last_element = new_element;
            ++number_of_elements;
        } else {
            setAsOnlyElement(new_element);
        }
    }
    
    protected void pushElement(T new_element) {
        if (last_element != null) {
            new_element.setNext(first_element);
            first_element = new_element;
        } else {
            setAsOnlyElement(new_element);
        }
        ++number_of_elements;
    }
    
    protected T popEndElement() {
        T popped = null;
        if (last_element != null) {
            popped = last_element;
            last_element = getPrevElement(last_element);
            if (last_element == null)
                setAsOnlyElement(null);
            --number_of_elements;
        }
        return popped;
    }
    
    protected T popStartElement() {
        T popped = null;
        if (first_element != null) {
            popped = first_element;
            first_element = getNextElement(first_element);
            if (first_element == null)
                setAsOnlyElement(null);
            --number_of_elements;
        }
        return popped;
    }
    
    protected void deleteElement(T e) {
        if (first_element == e)
            popStartElement();
        else if (last_element == e)
            popEndElement();
        else if (getPrevElement(e) != null)
            deleteNextElement(getPrevElement(e));
        else {
            System.out.println("Element not in a list.");
            return; 
        }
        cleanDeletedElement(e);
        --number_of_elements;
    }
    
    protected T getNextElement(T e) {
        //T to_return = (T) e.getNext();
        //System.out.println("Trying to get next: " + e.toString());
        //System.out.println("\tfound: " + e.getNext().toString());
        if (e == null)
            return null;
        return (T) e.getNext();
        //return null;
    }
    
    protected T getFirstElement() {
        return first_element;
    }    
    
    protected T getLastElement() {
        return last_element;
    }
    
    protected T getPrevElement(T e) {
        T test_element;
        for (Iterator itr = getForwardItr(); itr.hasNext();) {
            test_element = (T) itr.next();
            if (test_element.getNext() == e)
                return test_element;
        }
        return null;
    }
    
    protected void cleanDeletedElement(T e) {
        e.setNext(null);
    }
    
    protected void setAsOnlyElement(T e) {
        first_element = e;
        last_element = e;
        number_of_elements = 1;
        if (e != null)
            cleanDeletedElement(e);
    } 
    
    protected void deleteNextElement(T before_deleted) {
        T after_deleted;
        try{
            after_deleted = (T) before_deleted.getNext().getNext();
        } catch (NullPointerException e) {
            after_deleted = null;
        }
        before_deleted.setNext(after_deleted);
    }
    
    public void printUsingItr(Iterator itr) {
        System.out.format("List has %d elements.  Here they are:\n", number_of_elements);
        
        while(itr.hasNext()) {
            System.out.println( "\t" + itr.next().toString() );
        }
        System.out.println("");   
    }
    
    public Iterator getForwardItr() {
        return new ForwardIterator();
    }
    
    public Iterator getBackwardItr() {
        return new BackwardIterator();
    }
    
    protected class ForwardIterator extends Iterator<T> {
        protected T getStartingElement() {
            return getFirstElement();
        } 
        
        protected T getFinishingElement() {
            return getLastElement();
        }
        
        protected T getNextElement() {
            return getNextElement((T) next_element);
        }
    }
    
    protected class BackwardIterator extends Iterator<T> {
        protected T getStartingElement() {
            return getLastElement();
        } 
        
        protected T getFinishingElement() {
            return getFirstElement();
        }
        
        protected T getNextElement() {
            return getPrevElement((T) next_element);
        }
    }
}

