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
public class StackTest {
    
    public StackTest() {
    }

    /**
     * Test of push method, of class Stack.
     */
    @Test
    public void testPushPopEmpty() {
        System.out.println("push_pop");
        
        Stack instance = new Stack<String>();
        assertEquals(instance.empty(), true);
        
        String first_in = "Hello";
        String second_in = "World";
        instance.push(first_in);
        instance.push(second_in);
        
        assertEquals(instance.empty(), false);
        assertEquals(instance.pop(), second_in);
        assertEquals(instance.empty(), false);
        assertEquals(instance.pop(), first_in);
        assertEquals(instance.empty(), true);
    }
}
