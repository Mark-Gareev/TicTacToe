package com.company;

public class CheckWinStatus {
    private GameVariableHolder gameVariableHolder;

    boolean CheckCurrentSymbolAround(Field field)
    {
        boolean winnerExists = false;
        int row,column,countOccurences = 1;

        int x,y;
        x=gameVariableHolder.getRow();
        y=gameVariableHolder.getColumn();

        for(int i = -1;i < 1; i++) // i < 2
        {
            for(int j = -1; j < 1; j++)
            {
                if((i != 0)|(j != 0))
                {
                    if(Integer.parseInt(field.getElement(x+i, y+j)) == gameVariableHolder.getCurrentSymbolCode())
                    {
                        countOccurences += 1;
                        row = i;
                        column = j;
                        if(checkWinnerByVector(row,column,countOccurences,field))
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


    public boolean checkWinnerByVector (int row,int column,int countOccurencesInCheck, Field field){
        int multiplierByRowAndColumn = 2;

        while (countOccurencesInCheck <= gameVariableHolder.getLimit()) //in positive direction
        {
            if (Integer.parseInt(field.getElement(gameVariableHolder.getRow() + row * multiplierByRowAndColumn,gameVariableHolder.getColumn() + column * multiplierByRowAndColumn)) == gameVariableHolder.getCurrentSymbolCode())
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
        while(countOccurencesInCheck <= gameVariableHolder.getLimit())
        {
            if (Integer.parseInt(field.getElement(gameVariableHolder.getRow() + (row * -multiplierByRowAndColumn),gameVariableHolder.getColumn() + (column * -multiplierByRowAndColumn))) == gameVariableHolder.getCurrentSymbolCode())
            {
                countOccurencesInCheck++;
                multiplierByRowAndColumn++;
            }
            else
            {
                break;
            }
        }
        return countOccurencesInCheck == gameVariableHolder.getLimit(); // Instead of finish we can use this
    }

    public CheckWinStatus() {
        this.gameVariableHolder = GameVariableHolder.getInstance();
    }
}
