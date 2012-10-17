/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BBK.PiJ01.exercise6;

import BBK.PiJ01.common.Exercise;

/**
 *
 * @author Sam Wright <swrigh11@dcs.bbk.ac.uk>
 */
public class Spy {
    private static int spyCount = 0;
    private int ID;
    
    public Spy(int ID) {
        this.ID = ID;
        spyCount++;
        System.out.format("New spy's ID: %d.  Total number of spies: %d\n",
                                                  ID, spyCount);
    }
    
    public void die() {
        spyCount--;
        System.out.format("Spy %d was KIA.  Total number of spies: %d\n",
                                                    ID, spyCount);
    }
    
    public static void main(String[] args) {
        Spy s1 = new Spy(1);
        Spy s2 = new Spy(2);
        Spy s3 = new Spy(3);
        
        s2.die();
        s3.die();
        s1.die();
    }
}

class SpyExercise implements Exercise {
    public String getTitle() { 
        return "Spy";
    }
    
    public String getDescription() {
        return "Enlists three spies, then watches them die.";
    }
            
    public void run() {
        Spy.main(new String[]{});
    }
}