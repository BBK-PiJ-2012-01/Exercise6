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
    static public <T extends Comparable<T>> void sort(SortableList<T> lst) {
        while(BubbleSort.sortLoop(lst, true) && BubbleSort.sortLoop(lst, false)) {}
    }

}
