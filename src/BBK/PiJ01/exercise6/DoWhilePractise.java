/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BBK.PiJ01.exercise6;

import BBK.PiJ01.common.BadInput;
import BBK.PiJ01.common.Exercise;
import BBK.PiJ01.common.IOGeneric;

/**
 *
 * @author Sam Wright <swrigh11@dcs.bbk.ac.uk>
 */
public class DoWhilePractise implements Exercise {
    private int[] statistics;
    private void dataEntry() {
        int mark;
        
        
        do {
            System.out.print("Input a mark: ");
            try{
                mark = IOGeneric.getInteger();
            } catch (BadInput e) {
                mark = 101;
            }
            
            if (mark == -1)
                break;
            
            for (Grade g : Grade.values()) {
                if (g.isValidFor(mark)) {
                    ++statistics[g.getID()];
                    break;
                }
            }
        } while(true); // I used a do-while, but the exercise
                       // didn't specify how I used it!
    }
    
    private void init() {
        statistics = new int[]{0,0,0,0};
    }
    
    private void printResults() {
        System.out.format("Results are: %s",
                IOGeneric.intListToString(statistics, "[,]"));
    }
    
    // Exercise implementation:
    
    public String getTitle() {
        return "Do-While loop practise.";
    }
    
    public String getDescription() {
        return "Input the student";
    }
    
    public void run() {
        init();
        dataEntry();
        printResults();
    }
}

enum Grade {
    Distinction (70, 100, "distinction", 0),
    Pass (50, 69, "pass", 1),
    Fail (0, 49, "fail", 2),
    Invalid ("invalid", 3);
    
    private int lower_bound, higher_bound;
    private String msg;
    private int ID;
    private boolean catch_all = false;
    
    Grade(int lower_bound, int higher_bound, String msg, int ID) {
        this.lower_bound = lower_bound;
        this.higher_bound = higher_bound;
        this.msg = msg;
        this.ID = ID;
    }
    
    Grade(String msg, int ID) {
        this.msg = msg;
        this.ID = ID;
        catch_all = true;
    }
    
    boolean isValidFor(int mark) {
        return (mark >= lower_bound && mark <= higher_bound) || catch_all;
    }
    
    String getMsg(boolean plural) {
        if (plural && msg.endsWith("e")) {
            return msg + "s";
        }
        return msg;
    }
    
    public int getID() {
        return ID;
    }
}
