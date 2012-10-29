/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BBK.PiJ01.linkedLists.lists;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sam Wright <swrigh11@dcs.bbk.ac.uk>
 */
public class QueueTest {
    
    public QueueTest() {
    }

    /**
     * Test of insert method, of class Queue.
     */
    @Test
    public void testInsertRetrieveSize() {
        System.out.println("insert, retrieve, and size");
        
        Queue instance = new Queue<String>();
        assertEquals(instance.size(), 0);
        
        String first_in = "Hello";
        String second_in = "World";
        instance.insert(first_in);
        instance.insert(second_in);
        
        assertEquals(instance.size(), 2);
        assertEquals(instance.retrieve(), first_in);
        assertEquals(instance.size(), 1);
        assertEquals(instance.retrieve(), second_in);
        assertEquals(instance.size(), 0);
    }
}
