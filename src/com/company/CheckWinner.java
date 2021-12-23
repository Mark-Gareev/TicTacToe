package com.company;

public class CheckWinner {

    public static boolean checkWinnerByVector ( int x,int y,int row,int column,int count,int symbolNumber,
                                           int limit){
        boolean Finish = false;
        int a = 2;
        while (count < limit) //in positive direction
        {
            if (Field.field[x + row * a][y + column * a] == symbolNumber)
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
            if (Field.field[x + (row * -a)][y + (column * -a)] == symbolNumber)
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
            Finish = true;
        return Finish;
    }


    static boolean winCheck(int x, int y, int symbolNumber, int limit)
    {
        boolean winnerExists = false;
        int row,column,innerCounter = 1;
        for(int i = -1;i < 2; i++)
        {
            for(int j = -1; j < 2; j++)
            {
                if((i != 0)|(j != 0))
                {
                    if(Field.field[x+i][y+j] == symbolNumber)
                    {
                        innerCounter += 1;
                        row = i;
                        column = j;
                        if(checkWinnerByVector(x,y,row,column,innerCounter,symbolNumber,limit))
                        {
                            winnerExists = true;
                            break;
                        }
                    }
                }
            }
        }
        return winnerExists;
    }

}
