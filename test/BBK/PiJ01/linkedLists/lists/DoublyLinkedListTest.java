/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BBK.PiJ01.linkedLists.lists;

import BBK.PiJ01.linkedLists.elements.DoublyElement;
import BBK.PiJ01.linkedLists.iterators.Iterator;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sam Wright <swrigh11@dcs.bbk.ac.uk>
 */
public class DoublyLinkedListTest {
    private DoublyElement d1;
    private DoublyElement d2;
    private DoublyElement d3;
    
    public DoublyLinkedListTest() {
    }
    
    private DoublyLinkedList<DoublyElement> init() {
        DoublyLinkedList<DoublyElement> instance = new DoublyLinkedList<DoublyElement>();
        
        d1 = new DoublyElement();
        d2 = new DoublyElement();
        d3 = new DoublyElement();
        
        instance.add(d1);
        instance.add(d2);
        instance.add(d3);
        
        return instance;
    }
    

    /**
     * Test of add method, of class DoublyLinkedList.
     */
    @Test
    public void testAdd() {
        System.out.println("add and iterators");
        
        DoublyLinkedList<DoublyElement> instance = init();
        
        Iterator<DoublyElement> itr;
        
        itr = instance.getForwardItr();
        assertTrue(itr.hasNext());
        assertEquals(itr.next(), d1);
        assertEquals(itr.next(), d2);
        assertEquals(itr.next(), d3);
        assertFalse(itr.hasNext());
        
        itr = instance.getBackwardItr();
        assertTrue(itr.hasNext());
        assertEquals(itr.next(), d3);
        assertEquals(itr.next(), d2);
        assertEquals(itr.next(), d1);
        assertFalse(itr.hasNext());
    }

    /**
     * Test of delete method, of class DoublyLinkedList.
     */
    @Test
    public void testDelete() {
        System.out.println("delete and iterators");
        DoublyLinkedList<DoublyElement> instance = init();
        Iterator<DoublyElement> itr;
        
        instance.delete(d1);
        itr = instance.getForwardItr();
        assertTrue(itr.hasNext());
        assertEquals(itr.next(), d2);
        assertEquals(itr.next(), d3);
        assertFalse(itr.hasNext());
        
        instance.delete(d3);
        itr = instance.getForwardItr();
        assertTrue(itr.hasNext());
        assertEquals(itr.next(), d2);
        assertFalse(itr.hasNext());
        
        instance.delete(d2);
        itr = instance.getForwardItr();
        assertFalse(itr.hasNext());
    }
}
