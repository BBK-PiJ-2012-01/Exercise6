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
public class DoublyLinkedList implements Exercise {
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
            patients[i] = new Patient(names[i], 20+i, "abcdefghij".substring(i));
            lst.add(patients[i]);
        }
        
        lst.print();
        
        
        lst.delete(patients[2]);
        lst.delete(patients[8]);
        System.out.println("\nCharlie and Isaac opted out of the waiting list.");
        
        
        
        lst.print();
        
    }
}


class Patient {
    private Patient next_patient;
    private Patient prev_patient;
    
    public String name; 
    public int age;
    public String illness;

    public Patient(String name, int age, String illness) {
        this.name = name;
        this.age = age;
        this.illness = illness;
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
    
    public String toString() {
        return String.format("Name: %s, Age: %d, Illness code: %s", 
                                        name, age, illness);
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
        } else {
            setAsOnlyPatient(new_patient);
        }
    }
    
    public void delete(Patient old_patient) {
        if (old_patient.getPrev() != null)
            old_patient.getPrev().setNext( old_patient.getNext() );
        else if (old_patient.getNext() != null)
            old_patient.getNext().setPrev( old_patient.getPrev() );
        else if(number_of_patients != 0)
            System.out.println("Patient is not in list.");
        else
            setAsOnlyPatient(null);
    }
    
    private void setAsOnlyPatient(Patient only_patient) {
        last_patient = only_patient;
        first_patient = only_patient;
    }
    
    public void printForwards() {
        System.out.format("List has %d patients:\n", number_of_patients);
        
        for (Patient p=first_patient; p.getNext()!=null; p=p.getNext()) {
            System.out.println( "\t" + p.toString() );
        }
    }
    
}