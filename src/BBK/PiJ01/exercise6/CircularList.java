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
}

class OneWayPatient extends BasePatient {
    private OneWayPatient next_patient;
    
    private String name; 
    private int age;
    private String illness;

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
        return String.format("Name: %s, \tAge: %d, \tIllness code: %s", 
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
        old_patient
    }
    
    private OneWayPatient getPrevious() {
        OneWayPatient p = last_patient.getNext();
        
        do {
            
            p = p.getNext();
        } while(p != last_patient);
    }
    
}