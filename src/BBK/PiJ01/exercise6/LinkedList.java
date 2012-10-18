/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BBK.PiJ01.exercise6;

import java.util.HashSet;
import javax.swing.text.AbstractDocument;

/**
 *
 * @author Sam Wright <swrigh11@dcs.bbk.ac.uk>
 */
class LinkedList <T extends Element> {
    protected Element<T> first_element;
    protected Element<T> last_element;
    protected int number_of_elements = 0;
    
    
    protected void addElement(Element<T> new_element) {
        if (last_element != null) {
            last_element.setNext(new_element);
            last_element = new_element;
            ++number_of_elements;
        } else {
            setAsOnlyElement(new_element);
        }
    }
    
    protected void pushElement(Element<T> new_element) {
        if (last_element != null) {
            new_element.setNext(first_element);
            first_element = new_element;
        } else {
            setAsOnlyElement(new_element);
        }
        ++number_of_elements;
    }
    
    protected Element<T> popEndElement() {
        Element<T> popped = null;
        if (last_element != null) {
            popped = last_element;
            last_element = getPrevElement(last_element);
            --number_of_elements;
        }
        return popped;
    }
    
    protected Element<T> popStartElement() {
        Element<T> popped = null;
        if (first_element != null) {
            popped = last_element;
            last_element = getPrevElement(last_element);
        }
        return popped;
    }
    
    protected void deleteElement(Element<T> e) {
        deleteNextElement(getPrevElement(e));
        cleanDeletedElement(e);
    }
    
    protected Element<T> getNextElement(Element<T> e) {
        return e.getNext();
    }
    
    protected Element<T> getFirstElement() {
        return first_element;
    }    
    
    protected Element<T> getLastElement() {
        return last_element;
    }
    
    protected Element<T> getPrevElement(Element<T> e) {
        Element<T> test_element;
        for (Iterator itr = getForwardItr(); itr.hasNext();) {
            test_element = itr.next();
            if (test_element.getNext() == e)
                return test_element;
        }
        return null;
    }
    
    protected void cleanDeletedElement(Element<T> e) {
        e.setNext(null);
    }
    
    protected void setAsOnlyElement(Element<T> e) {
        first_element = e;
        last_element = e;
        if (e != null)
            cleanDeletedElement(e);
    } 
    
    protected void deleteNextElement(Element<T> before_deleted) {
        Element<T> after_deleted;
        try{
            after_deleted = before_deleted.getNext().getNext();
        } catch (NullPointerException e) {
            after_deleted = null;
        }
        before_deleted.setNext(after_deleted);
    }
    
    public void printForwards() {
        System.out.format("List has %d elements.  Here they are:\n", number_of_elements);
        
        for (Iterator itr = getForwardItr(); itr.hasNext();) {
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
    
    public class ForwardIterator extends Iterator {
        protected Element<T> getStartingElement() {
            return getFirstElement();
        } 
        
        protected Element<T> getFinishingElement() {
            return getLastElement();
        }
        
        protected Element<T> getNextElement() {
            return getNextElement(this.next_element);
        }
    }
    
    public class BackwardIterator extends Iterator {
        protected Element<T> getStartingElement() {
            return getLastElement();
        } 
        
        protected Element<T> getFinishingElement() {
            return getFirstElement();
        }
        
        protected Element<T> getNextElement() {
            return getPrevElement(this.next_element);
        }
    }
}

