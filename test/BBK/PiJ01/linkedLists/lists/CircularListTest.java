/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BBK.PiJ01.linkedLists.lists;

import BBK.PiJ01.linkedLists.elements.Element;
import BBK.PiJ01.linkedLists.iterators.Iterator;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sam Wright <swrigh11@dcs.bbk.ac.uk>
 */
public class CircularListTest {
    Element d1;
    Element d2;
    Element d3;
    
    public CircularListTest() {
    }
    
    private CircularList<Element> init() {
        CircularList<Element> instance = new CircularList<Element>();
        
        d1 = new Element();
        d2 = new Element();
        d3 = new Element();
        
        instance.add(d1);
        instance.add(d2);
        instance.add(d3);
        
        return instance;
    }
    

    /**
     * Test of add method, of class CircularList.
     */
    @Test
    public void testAdd() {
        System.out.println("add and iterators");
        
        CircularList<Element> instance = init();
        Iterator<Element> itr;
        
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
     * Test of popEndElement method, of class CircularList.
     */
    @Test
    public void testPopEndElement() {
        System.out.println("popEndElement");
        
        CircularList<Element> instance = init();
        assertEquals(instance.popEndElement(), d3);
        Iterator<Element> itr;
        
        itr = instance.getForwardItr();
        assertTrue(itr.hasNext());
        assertEquals(itr.next(), d1);
        assertEquals(itr.next(), d2);
        assertFalse(itr.hasNext());
        
        assertEquals(instance.popEndElement(), d2);
        itr = instance.getForwardItr();
        assertTrue(itr.hasNext());
        assertEquals(itr.next(), d1);
        assertFalse(itr.hasNext());
        
        assertEquals(instance.popEndElement(), d1);
        itr = instance.getForwardItr();
        assertFalse(itr.hasNext());
        
    }

    /**
     * Test of delete method, of class CircularList.
     */
    @Test
    public void testDelete() {
        CircularList<Element> instance = init();
        instance.delete(d3);
        Iterator<Element> itr;
        
        itr = instance.getForwardItr();
        assertTrue(itr.hasNext());
        assertEquals(itr.next(), d1);
        assertEquals(itr.next(), d2);
        assertFalse(itr.hasNext());
        
        instance.delete(d1);
        itr = instance.getForwardItr();
        assertTrue(itr.hasNext());
        assertEquals(itr.next(), d2);
        assertFalse(itr.hasNext());
        
        instance.delete(d2);
        itr = instance.getForwardItr();
        assertFalse(itr.hasNext());
    }
}
