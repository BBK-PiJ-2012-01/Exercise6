/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BBK.PiJ01.exercise6;

import BBK.PiJ01.common.Exercise;
import BBK.PiJ01.linkedLists.lists.SortedList;
/**
 *
 * @author Sam Wright <swrigh11@dcs.bbk.ac.uk>
 */
public class SortedListExercise implements Exercise {
    public String getTitle() {
        return "Always-sorted list";
    }
    
    public String getDescription() {
        return "Demonstrates a list which always inserts new\n"
                + "values in the correct place to keep the list\n"
                + "always sorted.";
    }
    
    public void run() {
        SortedList<Integer> lst = new SortedList<Integer>();
        lst.insert(3);
        lst.insert(4);
        lst.insert(2);
        
        lst.insert(1);
        
        for (int i=0; i<20; i++) {
            lst.insert((int)Math.abs(Math.random()*1000));
        }
        
        lst.printUsingItr( lst.getForwardItr() );
    }
}

