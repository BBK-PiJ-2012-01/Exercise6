/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BBK.PiJ01.exercise6;

import BBK.PiJ01.common.Exercise;
import BBK.PiJ01.common.IOGeneric;




/**
 *
 * @author Sam Wright <swrigh11@dcs.bbk.ac.uk>
 */
public class DoublyLinkedListExercise implements Exercise {
    public String getTitle() {
        return "Doubly-linked lists";
    }
    
    public String getDescription() {
        return "Creates a doubly-linked waiting list of patients, \n"
                + "traverse through it, delete a few, then \n"
                + "traverse through it again.";
    }
    
    public void run() {
        
        DoubleLinkedList<Patient> lst = new DoubleLinkedList();
        
        Patient[] patients = new Patient[10];
        String[] names = new String[]{"Andy", "Ben", "Charlie", "Dan", "Emily", 
                                    "Fran", "Gerald", "Harry", "Isaac", "John"};
        
        for (int i=0; i<10; i++) {
            patients[i] = new Patient(names[i], 20+i, "abcdefghij".substring(i,i+1));
            lst.add(patients[i]);
        }
        
        lst.printUsingItr(lst.getForwardItr());
        lst.printUsingItr(lst.getBackwardItr());
        
        
        lst.delete(patients[2]);
        lst.delete(patients[8]);
        IOGeneric.printTitle("Charlie and Isaac opted out of the waiting list.", "-");
        
        lst.printUsingItr(lst.getForwardItr());
        lst.printUsingItr(lst.getBackwardItr());
        
        Patient extra = new Patient("Kelly", 30, "k");
        lst.add(extra);
        
        IOGeneric.printTitle("Added Kelly to the list.", "-");
        lst.printUsingItr(lst.getForwardItr());
        lst.printUsingItr(lst.getBackwardItr());
        
        IOGeneric.printTitle("Trying to delete Xander from the list...", "-");
        Patient non_existant = new Patient("Xander", 80, "x");
        lst.delete(non_existant);
    }
}
class DoublyElement extends AbstractElement {
    protected AbstractElement prev;// = Patient.test_element;
    protected AbstractElement next;// = Patient.test_element;
    
    public void setPrev(AbstractElement prev) {
        this.prev = prev;

        if (prev != null && prev.getNext() != this) {
            if (prev != null)
                prev.setNext(this);
        }
    }
    
    public void setNext(AbstractElement next) {
        this.next = next;

        if (next != null && next.getPrev() != this) {
            if (next != null)
                next.setPrev(this);
        }
    }
    
    public AbstractElement getPrev() {
        return prev;
    }
    
    public AbstractElement getNext() {
        return next;
    }
}


class Patient extends DoublyElement {
    protected String name; 
    protected int age;
    protected String illness;
    
    static public Patient test_element = new Patient("Null", 0, "z");
    
    public Patient(String name, int age, String illness) {
        this.name = name;
        this.age = age;
        this.illness = illness;
    }
    
    public String toString() {
        return String.format("Name: %s, \tAge: %d, \tIllness code: %s\n", 
                                        name, age, illness);
    }
}


class DoubleLinkedList <T extends DoublyElement> extends AbstractLinkedList<T> {
    public void add(T e) {
        addElement(e);
    }
    
    public void delete(T e) {
        deleteElement(e);
    }
    
    @Override
    protected void cleanDeletedElement(T e) {
        e.setNext(null);
        e.setPrev(null);
    }
    
    @Override
    protected T getPrevElement(T e) {
        return (T) e.getPrev();
    }
}
