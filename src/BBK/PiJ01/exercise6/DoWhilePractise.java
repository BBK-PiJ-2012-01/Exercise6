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
    private int total_students;
    
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
                    ++total_students;
                    ++statistics[g.getID()];
                    break;
                }
            }
        } while(true); // I used a do-while, but the exercise
                       // didn't specify how I used it!
    }
    
    private void init() {
        statistics = new int[]{0,0,0,0};
        total_students = 0;
    }
    
    private void printResults() {
        String s = "Results are: %s\n";
        System.out.format(s,
               IOGeneric.intListToString(statistics, "[,]"));
        
        StringBuffer sbuf = new StringBuffer();
        sbuf.append(String.format("There are %d students: ", total_students));
        
        for (Grade g : Grade.values()) {
            sbuf.append( g.getMsg( statistics[g.getID()] ) );
        }
        
        IOGeneric.printResult(sbuf.toString(), "-");
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
    Distinction (70, 100, "%d distinction%s, ", "s", 0),
    Pass (50, 69, "%d pass%s, ", "es", 1),
    Fail (0, 49, "%d fail%s, ", "s", 2),
    Invalid ("(plus %d invalid%s).", "", 3);
    
    private int lower_bound, higher_bound;
    private String msg;
    private int ID;
    private boolean catch_all = false;
    private String plural_str;
    
    Grade(int lower_bound, int higher_bound, String msg, String plural_str, int ID) {
        this.lower_bound = lower_bound;
        this.higher_bound = higher_bound;
        this.msg = msg;
        this.ID = ID;
        this.plural_str = plural_str;
    }
    
    Grade(String msg, String plural_str, int ID) {
        this.msg = msg;
        this.ID = ID;
        this.plural_str = plural_str;
        catch_all = true;
    }
    
    boolean isValidFor(int mark) {
        return (mark >= lower_bound && mark <= higher_bound) || catch_all;
    }
    
    String getMsg(int number) {
        if (number != 1) 
            return String.format(msg, number, plural_str);
        
        return String.format(msg, number, "");
    }
    
    public int getID() {
        return ID;
    }
}
