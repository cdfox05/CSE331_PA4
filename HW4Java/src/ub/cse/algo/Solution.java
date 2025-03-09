package ub.cse.algo;

import java.util.ArrayList;

public class Solution {
    
    private int _n_battles;
    private ArrayList<int[]> _battles;
    
    public Solution (int n_battles, ArrayList<int[]> battles){
        _n_battles = n_battles;
        _battles = battles;
    }
    
    /**
     * You should fill this in on your own. battles is list of tuples, in the form (battle duration, battle deadline).
     * Your output should also be a list of tuples, of the form (battle id, start time of battle). If no possible
     * schedule exists, you should return an empty list.
     * @return
     */
    public ArrayList<int[]> getSchedule(){
        ArrayList<int[]> schedule = new ArrayList<int[]>();

        //System.out.println("IMPLEMENT ME!");
        return schedule;
    }
}
