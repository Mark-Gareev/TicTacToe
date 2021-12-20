package com.company;

public class CheckWinner {

    public static boolean vectorWithCheckingWinner ( int x,int y,int vect_x,int vect_y,int count,int symbolNumber, int[][] field,
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


    static boolean winCheck(int x, int y, int symbolNumber, int[][] field, int limit)
    {
        boolean innerflag = false;
        int vector_x,vector_y,innerCounter = 1;
        for(int i = -1;i < 2; i++)
        {
            for(int j = -1; j < 2; j++)
            {
                if((i != 0)|(j != 0))
                {
                    if(field[x+i][y+j] == symbolNumber)
                    {
                        innerCounter += 1;
                        vector_x = i;
                        vector_y = j;
                        if(vectorWithCheckingWinner(x,y,vector_x,vector_y,innerCounter,symbolNumber,field,limit))
                        {
                            innerflag = true;
                            break;
                        }
                    }
                }
            }
        }
        return innerflag;
    }

}
