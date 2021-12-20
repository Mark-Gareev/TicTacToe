package com.company;

public class CheckWinner {

    public static boolean vectorWinCheck ( int x,int y,int vect_x,int vect_y,int count,int symbolNumber, int[][] field,
                                           int limit){
        boolean enough = false;
        int a = 2;
        while (count < limit) //in positive direction
        {
            if (field[x + vect_x * a][y + vect_y * a] == symbolNumber)
            {
                count++;
                a++;
            }
            else
            {
                break;
            }
        }
        a = 1;
        while(count < limit)
        {
            if (field[x + (vect_x * -a)][y + (vect_y * -a)] == symbolNumber)
            {
                count++;
                a++;
            }
            else
            {
                break;
            }
        }
        if (count == limit)
            enough = true;
        return enough;
    }
}
