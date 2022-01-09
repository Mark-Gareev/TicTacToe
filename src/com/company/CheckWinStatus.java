package com.company;

public class CheckWinStatus {
    private int multiplierByRowAndColumn , row,column,countOccurences , limit;
    private boolean winnerExists;

    boolean CheckCurrentSymbolAround(Field field, int currentSymbolcode, int currentRow, int currentColumn )
    {
        winnerExists = false;
        row=1;
        column=1;
        countOccurences = 1;


        for(int i = -1;i < 1; i++) // i < 2
        {
            for(int j = -1; j < 1; j++) // j < 2
            {
                if((i != 0)|(j != 0))
                {
                    if(field.getElement(currentRow+i, currentColumn+j) == currentSymbolcode )
                    {
                        countOccurences += 1;
                        row = i;
                        column = j;
                        if(checkWinnerByVector(row,column,countOccurences,field,
                                currentSymbolcode, currentRow, currentColumn))
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


    public boolean checkWinnerByVector (int row,int column,int countOccurencesInCheck, Field field,
                                        int currentSymbolCode, int gameVarRow, int gameVarCol){
        multiplierByRowAndColumn = 2;
        limit = GameVariableHolder.getLimit();

        while (countOccurencesInCheck <= limit) //in positive direction
        {
            if (field.getElement(gameVarRow + row * multiplierByRowAndColumn,
                    gameVarCol + column * multiplierByRowAndColumn) == currentSymbolCode)
            {
                countOccurencesInCheck++;
                multiplierByRowAndColumn++;
            }
            else
            {
                break;
            }
        }

        multiplierByRowAndColumn = 1;
        while(countOccurencesInCheck <= limit)
        {
            if (field.getElement(gameVarRow + (row * -multiplierByRowAndColumn),
                    gameVarCol + (column * -multiplierByRowAndColumn)) == currentSymbolCode)
            {
                countOccurencesInCheck++;
                multiplierByRowAndColumn++;
            }
            else
            {
                break;
            }
        }
        return countOccurencesInCheck == GameVariableHolder.getLimit(); // Instead of finish we can use this
    }

}
