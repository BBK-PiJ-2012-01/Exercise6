/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BBK.PiJ01.exercise6;

import BBK.PiJ01.common.Exercise;
import BBK.PiJ01.linkedLists.lists.SortableList;
import BBK.PiJ01.linkedLists.util.CocktailSort;

/**
 *
 * @author Sam Wright <swrigh11@dcs.bbk.ac.uk>
 */
public class CocktailSortExercise implements Exercise {
    public String getTitle() {
        return "Cocktail sort";
    }
    
    public String getDescription() {
        return "Demonstrates a cocktail sort of a linked-list of\n"
                + "a list of randomly-generated integers.\n";
    }
    
    public void run() {
        SortableList<Integer> lst = new SortableList<Integer>();
        
        for (int i=0; i<20; i++) {
            lst.insert((int)Math.abs(Math.random()*1000));
        }
        
        CocktailSort.sort(lst);
        
        lst.printUsingItr( lst.getForwardItr() );
    }
}
