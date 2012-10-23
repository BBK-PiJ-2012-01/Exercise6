/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BBK.PiJ01.exercise6;

import BBK.PiJ01.common.Exercise;
import BBK.PiJ01.common.IOGeneric;
import BBK.PiJ01.linkedLists.iterators.Iterator;
import BBK.PiJ01.linkedLists.lists.LinkedList;

/**
 *
 * @author Sam Wright <swrigh11@dcs.bbk.ac.uk>
 */
public class ArrayToList implements Exercise {
    public String getTitle() {
        return "Tests the array-to-list functionality";
    }
    
    public String getDescription() {
        return "Creates int[], Integer[], and Person[] arrays,\n"
                + "and converts them to LinkedLists.";
    }
    
    public void run() {
        int[] nums = new int[]{1,2,3,4,5,6};
        Integer[] nums2 = new Integer[]{1,2,3,4,5,6};
        Person[] people = new Person[]{new Person(1),
                                        new Person(2),
                                        new Person(3)};
        
        LinkedList nums_lst, nums2_lst, people_lst;
        
        nums_lst = LinkedList.fromArray(nums);
        nums2_lst = LinkedList.fromArray(nums2);
        people_lst = LinkedList.fromArray(people);
        
        IOGeneric.printTitle("int[] list", "-");
        nums_lst.printUsingItr(nums_lst.getForwardItr());
        
        IOGeneric.printTitle("Integer[] list", "-");
        nums2_lst.printUsingItr(nums2_lst.getForwardItr());
        
        IOGeneric.printTitle("Person[] list", "-");
        people_lst.printUsingItr(people_lst.getForwardItr());
    }
}


class Person {
    int i;
    
    public Person(int i) {
        this.i = i;
    }
    
    public String toString() {
        return "Person " + i;
    }
}