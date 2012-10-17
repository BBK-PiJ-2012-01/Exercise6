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
public class CircularList implements Exercise {
    public String getTitle() {
        return "Circular List";
    }
    
    public String getDescription() {
        return "Demonstrates a singly-linked list based on the previous\n"
                + "'hospitals and patients' doubly-linked list.  For example\n"
                + "Doctors in hospitals have to do their 'rounds', where\n"
                + "they check in on their patients over and over again...";
    }
    
    public void run() {
        Rounds lst = new Rounds();
        
        OneWayPatient[] patients = new OneWayPatient[10];
        String[] names = new String[]{"Andy", "Ben", "Charlie", "Dan", "Emily", 
                                    "Fran", "Gerald", "Harry", "Isaac", "John"};
    
        for (int i=0; i<10; i++) {
            patients[i] = new OneWayPatient(names[i], 20+i, "abcdefghij".substring(i,i+1));
            lst.add(patients[i]);
        }
        
        lst.printForwards();
        
        lst.delete(patients[2]);
        lst.delete(patients[8]);
        System.out.println("\nCharlie and Isaac opted out of the waiting list.");
        
        lst.printForwards();
        
        OneWayPatient extra = new OneWayPatient("Kelly", 30, "k");
        lst.add(extra);
        
        System.out.println("\nAdded Kelly to the list.");
        lst.printForwards();
        
        System.out.println("\nTrying to delete Xander from the list...");
        OneWayPatient non_existant = new OneWayPatient("Xander", 80, "x");
        lst.delete(non_existant);
    }
}

class OneWayPatient extends BasePatient {
    private OneWayPatient next_patient;
    
    public OneWayPatient(String name, int age, String illness) {
        super(name, age, illness);
    }
    
    public void setNext(OneWayPatient p) {
        next_patient = p;
    }
    
    public OneWayPatient getNext() {
        return next_patient;
    }
    
    public String toString() {
        return String.format("Name: %s, \tAge: %d, \tIllness code: %s\n", 
                                        name, age, illness);
    }
}

class Rounds {
    private OneWayPatient last_patient;
    
    public void add(OneWayPatient new_patient) {
        if (last_patient == null) {
            last_patient = new_patient;
            last_patient.setNext(last_patient);
        } else {
            new_patient.setNext(last_patient.getNext());
            last_patient.setNext(new_patient);
            last_patient = new_patient;
        }
    }
    
    public void delete(OneWayPatient old_patient) {
        OneWayPatient prev = getPrev(old_patient);
        if (prev == null) {
            System.out.println("Patient not in list.");
            return;
        } else if (prev == old_patient) {
            setAsOnlyPatient(null);
        } else {
            prev.setNext(old_patient.getNext());
        }
        cleanDeletedPatient(old_patient);
    }
    
    private OneWayPatient getPrev(OneWayPatient next) {
        if (last_patient == null)
            return null;
        OneWayPatient p = last_patient;
        
        do {
            p = p.getNext();
            if (p.getNext() == next)
                return p;
        } while(p != last_patient);
        return null;
    }
    
    private void setAsOnlyPatient(OneWayPatient only_patient) {
        last_patient = only_patient;
        if (last_patient != null)
            last_patient.setNext(last_patient);
    }
    
    private void cleanDeletedPatient(OneWayPatient deleted_patient) {
        deleted_patient.setNext(null);
    }
    
    public void printForwards() {
        if (last_patient == null) {
            System.out.println("The list is empty!");
            return;
        }
        
        System.out.println("Printing the list going forwards...");
        OneWayPatient p = last_patient;
        
        do {
            p = p.getNext();
            System.out.append( "\t" + p.toString());
        } while(p != last_patient);
    }
}