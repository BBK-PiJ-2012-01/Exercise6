/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BBK.PiJ01.exercise6;

import BBK.PiJ01.common.Exercise;

/**
 *
 * @author Sam Wright <swrigh11@dcs.bbk.ac.uk>
 */
public class StacksExercise implements Exercise {
    public String getTitle() {
        return "Stacks";
    }
    
    public String getDescription() {
        return "Demonstrates a stack (First-In-Last-Out)";
    }
    
    public void run() {
        Stack s = new Stack();
        s.push("First in");
        s.push("Second in");
        s.push("Third in");
        
        System.out.format("Pushing first, second and third.\n");
        
        System.out.format("Popped: %s\n", s.pop());
        System.out.format("Popped: %s\n", s.pop());
        
        System.out.format("Pushed fourth.\n");
        s.push("Fourth in");
        
        System.out.format("Popped: %s\n", s.pop());
        System.out.format("Popped: %s\n", s.pop());
        System.out.format("Is the stack empty? %b\n", s.empty());
    }
}

class Stack <T> {
    private Element<T> next_element;
    
    private void pushElement(Element<T> new_element) {
        if (!empty())
            new_element.setNext(next_element);
        next_element = new_element;
    }
    
    public void push(T obj) {
        pushElement(new Element<T>(obj));
    }
    
    public boolean empty() {
        return next_element == null;
    }
    
    public T pop() {
        T next_obj = next_element.getObject();
        next_element = next_element.getNext();
        return next_obj;
    }
}
