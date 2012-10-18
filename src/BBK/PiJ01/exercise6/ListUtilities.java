/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BBK.PiJ01.exercise6;

/**
 *
 * @author Sam Wright <swrigh11@dcs.bbk.ac.uk>
 */
public class ListUtilities {
    static <T> List<T> ArrayToList(T[] array) {
        List<T> lst = new List<T>;
        
        for (int i=0; i<array.length; i++) {
            lst.add( new Element<T>(array[i]));
        }
        return lst;
    }
}

int[] int_list = new int[]{1,2,3,4};
List<int> output = ListUtilities.ArrayToList<int>( int_list );