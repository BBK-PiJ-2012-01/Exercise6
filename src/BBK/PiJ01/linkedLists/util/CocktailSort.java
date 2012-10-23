/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BBK.PiJ01.linkedLists.util;

import BBK.PiJ01.linkedLists.lists.SortableList;

/**
 *
 * @author Sam Wright <swrigh11@dcs.bbk.ac.uk>
 */
public class CocktailSort {
    static public <T extends Comparable<T>> void ascending(SortableList<T> lst) {
        while(BubbleSort.sortLoop(lst, true, true) && BubbleSort.sortLoop(lst, false, true)) {}
    }
    
    static public <T extends Comparable<T>> void descending(SortableList<T> lst) {
        while(BubbleSort.sortLoop(lst, true, false) && BubbleSort.sortLoop(lst, false, false)) {}
    }

}
