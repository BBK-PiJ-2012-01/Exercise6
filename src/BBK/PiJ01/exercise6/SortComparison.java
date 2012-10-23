/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BBK.PiJ01.exercise6;

import BBK.PiJ01.common.Exercise;
import BBK.PiJ01.linkedLists.lists.SortableList;
import BBK.PiJ01.linkedLists.util.BubbleSort;
import BBK.PiJ01.linkedLists.util.CocktailSort;
import BBK.PiJ01.linkedLists.util.QuickSort;

/**
 *
 * @author Sam Wright <swrigh11@dcs.bbk.ac.uk>
 */
public class SortComparison implements Exercise {
    long start_time;
    long duration;
    
    public String getTitle() {
        return "Compare sort algorithms";
    }
    
    public String getDescription() {
        return "Compares the time it takes to sort a large array\n"
                + "of random integers using bubblesort, cocktailsort,\n"
                + "and quicksort.";
    }
    
    public void run() {
        
        SortableList<Integer> lst1 = new SortableList<Integer>();
        SortableList<Integer> lst2 = new SortableList<Integer>();
        SortableList<Integer> lst3 = new SortableList<Integer>();
        
        int random_number;
        for (int i=0; i<20000; i++) {
            random_number = (int)Math.abs(Math.random()*1000);
            lst1.insert(random_number);
            lst2.insert(random_number);
            lst3.insert(random_number);
        }
        
        System.out.println("Sorting started...");
        
        start_stopwatch();
        BubbleSort.ascending(lst1);
        stop_stopwatch();
        System.out.format("Bubblesort took %d ms\n", duration);
        
        start_stopwatch();
        CocktailSort.ascending(lst2);
        stop_stopwatch();
        System.out.format("Cocktailsort took %d ms\n", duration);
        
        start_stopwatch();
        QuickSort.ascending(lst3);
        stop_stopwatch();
        System.out.format("Quicksort took %d ms\n", duration);
    }
    
    private void start_stopwatch() {
        start_time = System.currentTimeMillis();
    }
    
    private void stop_stopwatch() {
        duration = System.currentTimeMillis() - start_time;
    }
}
