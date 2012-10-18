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
public class DoublyLinkedList2 implements Exercise {
    public String getTitle() {
        return "Doubly-linked lists";
    }
    
    public String getDescription() {
        return "Creates a doubly-linked waiting list of patients, \n"
                + "traverse through it, delete a few, then \n"
                + "traverse through it again.";
    }
    
    public void run() {
        
        WaitingList lst = new WaitingList();
        
        Patient[] patients = new Patient[10];
        String[] names = new String[]{"Andy", "Ben", "Charlie", "Dan", "Emily", 
                                    "Fran", "Gerald", "Harry", "Isaac", "John"};
    
        for (int i=0; i<10; i++) {
            patients[i] = new Patient(names[i], 20+i, "abcdefghij".substring(i,i+1));
            lst.add(patients[i]);
        }
        
        lst.printForwards();
        lst.printBackwards();
        
        
        lst.delete(patients[2]);
        lst.delete(patients[8]);
        System.out.println("\nCharlie and Isaac opted out of the waiting list.");
        
        lst.printForwards();
        lst.printBackwards();
        
        Patient extra = new Patient("Kelly", 30, "k");
        lst.add(extra);
        
        System.out.println("\nAdded Kelly to the list.");
        lst.printForwards();
        lst.printBackwards();
        
        System.out.println("\nTrying to delete Xander from the list...");
        Patient non_existant = new Patient("Xander", 80, "x");
        lst.delete(non_existant);
    }
}
abstract class BasePatient {
    protected String name; 
    protected int age;
    protected String illness;

    public BasePatient(String name, int age, String illness) {
        this.name = name;
        this.age = age;
        this.illness = illness;
    }
    
    public String toString() {
        return String.format("Name: %s, \tAge: %d, \tIllness code: %s\n", 
                                        name, age, illness);
    }
}

class Patient extends BasePatient {
    private Patient next_patient;
    private Patient prev_patient;
    
    public Patient(String name, int age, String illness) {
        super(name, age, illness);
    }
    
    public void setPrev(Patient prev_patient) {
        this.prev_patient = prev_patient;
        if (prev_patient != null)
            prev_patient.next_patient = this;
    }
    
    public void setNext(Patient next_patient) {
        this.next_patient = next_patient;
        if (next_patient != null)
            next_patient.prev_patient = this;
    }
    
    public Patient getPrev() {
        return prev_patient;
    }
    
    public Patient getNext() {
        return next_patient;
    }
}


class WaitingList {
    private Patient first_patient;
    private Patient last_patient;
    private int number_of_patients = 0;
    
    public void add(Patient new_patient) {
        if (last_patient != null) {
            last_patient.setNext(new_patient);
            last_patient = new_patient;
            ++number_of_patients;
        } else {
            setAsOnlyPatient(new_patient);
        }
    }
    
    public void delete(Patient old_patient) {
        if (old_patient.getPrev() != null) {
            old_patient.getPrev().setNext( old_patient.getNext() );
            --number_of_patients;
            
        } else if (old_patient.getNext() != null) {
            old_patient.getNext().setPrev( old_patient.getPrev() );
            --number_of_patients;
            
        } else if(number_of_patients != 0) {
            System.out.println("Patient is not in list.");
            return;
        } else {
            setAsOnlyPatient(null);
        }
        
        cleanDeletedPatient(old_patient);
    }
    
    private void setAsOnlyPatient(Patient only_patient) {
        last_patient = only_patient;
        first_patient = only_patient;
        if (only_patient == null)
            number_of_patients = 0;
        else
            number_of_patients = 1;
    }
    
    public void printForwards() {
        System.out.format("List has %d patients.  Here they are:\n", number_of_patients);
        
        for (Patient p=first_patient; p!=null; p=p.getNext()) {
            System.out.println( "\t" + p.toString() );
        }
        System.out.println("");
    }
    
    public void printBackwards() {
        System.out.format("List has %d patients.  Here they are in reverse order:\n", number_of_patients);
        
        for (Patient p=last_patient; p!=null; p=p.getPrev()) {
            System.out.println( "\t" + p.toString() );
        }
        System.out.println("");
    }
    
    private void cleanDeletedPatient(Patient deleted_patient) {
        deleted_patient.setNext(null);
        deleted_patient.setPrev(null);
    }
}