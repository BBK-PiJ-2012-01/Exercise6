/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BBK.PiJ01.linkedLists.lists;

import BBK.PiJ01.linkedLists.elements.Container;
import BBK.PiJ01.linkedLists.elements.ElementInterface;
import BBK.PiJ01.linkedLists.iterators.Iterator;

/**
 *
 * @author Sam Wright <swrigh11@dcs.bbk.ac.uk>
 */
public class LinkedList <T> extends BaseLinkedList<Container<T>> {
    static public <Obj> LinkedList<Obj> fromArray(Obj[] array) {
        LinkedList<Obj> lst = new LinkedList<Obj>();
        for(int i=0; i<array.length; i++) {
            lst.addElement( new Container(array[i]) );
        }
        return lst;
    }
    
    static public LinkedList fromArray(int[] array) {
        Integer[] boxed_list = new Integer[array.length];
        for (int i=0; i<array.length; i++) {
            boxed_list[i] = (Integer) array[i];
        }
        return fromArray(boxed_list);
    }
}
