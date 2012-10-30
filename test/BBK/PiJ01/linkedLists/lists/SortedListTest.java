/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BBK.PiJ01.linkedLists.lists;

import BBK.PiJ01.linkedLists.elements.SortableContainer;
import BBK.PiJ01.linkedLists.iterators.Iterator;
import java.util.Collections;
import java.util.LinkedList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sam Wright <swrigh11@dcs.bbk.ac.uk>
 */
public class SortedListTest {
    
    public SortedListTest() {
    }

    /**
     * Test of insert method, of class SortedList.
     */
    @Test
    public void testInsert() {
        SortedList<Integer> lst = new SortedList<Integer>();
        LinkedList<Integer> inbuilt_lst = new LinkedList<Integer>();
        int random_number;
        
        for (int i=-10; i<10; i++) {
            random_number = (int) Math.abs(Math.random()*100*i);
            lst.insert(random_number);
            inbuilt_lst.add(random_number);
        }
        
        Collections.sort(inbuilt_lst);
        
        Iterator<SortableContainer<Integer>> itr = lst.getForwardItr();
        java.util.Iterator<Integer> inbuilt_itr = inbuilt_lst.listIterator();
        
        while (inbuilt_itr.hasNext()) {
            assertTrue(itr.hasNext());
            assertEquals(itr.next().getObject(), inbuilt_itr.next());
        }
        assertFalse(itr.hasNext());
        
        
    }
}
