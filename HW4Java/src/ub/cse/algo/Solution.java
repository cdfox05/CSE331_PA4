package ub.cse.algo;

import java.sql.Array;
import java.util.*;

public class Solution {
    
    private int _n_battles;
    private ArrayList<int[]> _battles;
    
    public Solution (int n_battles, ArrayList<int[]> battles){
        _n_battles = n_battles;
        _battles = battles;
    }

    class BattleComparator implements Comparator<int[]> //priority queue comparator
    {
        @Override
        public int compare(int[] a, int[] b) {
            if (a[2] == b[2]) //if final time equals each other go based off duration (doesn't matter really)
            {
                if (a[1] > b[1])
                    return 1;
            }
            else
            {
                if (a[2] > b[2]) //if final of @a is bigger return 1
                    return 1;
            }
            return -1; //else return -1
        }
    }
    /**
     * You should fill this in on your own. battles is list of tuples, in the form (battle duration, battle deadline).
     * Your output should also be a list of tuples, of the form (battle id, start time of battle). If no possible
     * schedule exists, you should return an empty list.
     * @return
     */
    public ArrayList<int[]> getSchedule(){
        ArrayList<int[]> schedule = new ArrayList<int[]>();

        PriorityQueue<int[]> battle = new PriorityQueue<>(_n_battles, new BattleComparator());

        for (int i = 0; i < _n_battles; i++)
        {
            int[] b = {i, _battles.get(i)[0], _battles.get(i)[1]}; //sets up the pq with indexes that were not originally added
            battle.add(b);
        }

        int time = 0; //battle start time

        while (!battle.isEmpty())
        {
            int[] temp = battle.poll();
            if (temp != null)
            {
                //System.out.println(temp[0] + " Duration: " + temp[1] + ", Deadline: " + temp[2] + ", Current time: " + time);

                time += temp[1];
                if (time > temp[2]) { //if time is greater than deadline return empty
                    return new ArrayList<int[]>();
                }

                int[] b = {temp[0], time-temp[1]}; //adds battle number and start time
                schedule.add(b);
            }
        }

        //System.out.println("IMPLEMENT ME!");
        return schedule;
    }
}
