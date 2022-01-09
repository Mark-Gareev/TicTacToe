package com.company;

public class CheckWinStatus {
    private GameVariableHolder gameVariableHolder;
    private int limit = GameVariableHolder.limit;

    boolean CheckCurrentSymbolAround(Field field, int currentSymbolcode)
    {
        boolean winnerExists = false;
        int row,column,countOccurences = 1;

        int x,y;
        x=gameVariableHolder.getRow();
        y=gameVariableHolder.getColumn();
        //currentSymbolcode = gameVariableHolder.getCurrentSymbolCode();

        for(int i = -1;i < 1; i++) // i < 2
        {
            for(int j = -1; j < 1; j++)
            {
                if((i != 0)|(j != 0))
                {
                    if(field.getElement(x+i, y+j) == currentSymbolcode )
                    {
                        countOccurences += 1;
                        row = i;
                        column = j;
                        if(checkWinnerByVector(row,column,countOccurences,field, currentSymbolcode))
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


    public boolean checkWinnerByVector (int row,int column,int countOccurencesInCheck, Field field, int currentSymbolCode){
        int multiplierByRowAndColumn = 2;
        int gameVarRow = gameVariableHolder.getRow();
        int gameVarCol = gameVariableHolder.getColumn();

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
        return countOccurencesInCheck == GameVariableHolder.limit; // Instead of finish we can use this
    }

    public CheckWinStatus() {
        this.gameVariableHolder = GameVariableHolder.getInstance();
    }
}
