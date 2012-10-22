/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BBK.PiJ01.exercise6;

import BBK.PiJ01.linkedLists.elements.Element;
import BBK.PiJ01.common.Exercise;
import BBK.PiJ01.linkedLists.lists.Queue;

/**
 *
 * @author Sam Wright <swrigh11@dcs.bbk.ac.uk>
 */
public class QueuesExercise implements Exercise {
    public String getTitle() {
        return "Queues";
    }
    
    public String getDescription() {
        return "Demonstrates a queue (First-In-First-Out).";
    }

    public void run() {
        Queue<String> q = new Queue();
        q.insert("First in");
        q.insert("Second in");
        q.insert("Third in");
        
        System.out.format("Added first, second and third.\n");
        System.out.format("There's %d elements in the queue...\n", q.size());
        
        System.out.format("Retrieved: %s\n", q.retrieve());
        System.out.format("Retrieved: %s\n", q.retrieve());
        System.out.format("There's %d elements in the queue...\n", q.size());
        
        q.insert("Fourth in");
        System.out.format("Added fourth\n");
        
        System.out.format("Retrieved: %s\n", q.retrieve());
        System.out.format("Retrieved: %s\n", q.retrieve());
        System.out.format("There's %d elements in the queue...\n", q.size());
    }
}



/*
class Queue <T> {
    private Element<T> next_element;
    private Element<T> final_element;
    private int number_of_elements = 0;
    
    private void insertElement(Element<T> new_element) {
        if (final_element == null) {
            next_element = new_element;
            final_element = new_element;
        } else {
            final_element.setNext(new_element);
            final_element = new_element;
        }
        ++number_of_elements;
    }
    
    public void insert(T obj) {
        insertElement(new Element<T>(obj));
    }
    
    public T retrieve() {
        T next_obj;
        try {
            next_obj = next_element.getObject();
        } catch(NullPointerException e) {
            return null;
        }
        next_element = next_element.getNext();
        if (next_element == null)
            final_element = null;
        --number_of_elements;
        return next_obj;
    }
    
    public int size() {
        return number_of_elements;
    }
}
*/