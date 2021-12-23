package com.company;

public class CheckWinStatus { // Бля, я ваще не ебу, как по-другому еще это можно назвать

    static FieldService fieldService = TicTacToeGame.fieldService;
    static GameVariableHolder gameVariableHolder = TicTacToeGame.gameVariableHolder;


    public static boolean checkWinnerByVector (int row,int column,int countOccurencesInCheck){
        int multiplierByRowAndColumn = 2;
        while (countOccurencesInCheck <= gameVariableHolder.getLimit()) //in positive direction
        {
            if (Integer.parseInt(fieldService.getElement(gameVariableHolder.getRow() + row * multiplierByRowAndColumn,gameVariableHolder.getColumn() + column * multiplierByRowAndColumn)) == gameVariableHolder.getCurrentSymbolCode())
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
            if (Integer.parseInt(fieldService.getElement(gameVariableHolder.getRow() + (row * -multiplierByRowAndColumn),gameVariableHolder.getColumn() + (column * -multiplierByRowAndColumn))) == gameVariableHolder.getCurrentSymbolCode())
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


    static boolean CheckCurrentSymbolAround()
    {
        boolean winnerExists = false;
        int row,column,countOccurences = 1;

        for(int i = -1;i < 2; i++)
        {
            for(int j = -1; j < 2; j++)
            {
                if((i != 0)|(j != 0))
                {
                    if(Integer.parseInt(fieldService.getElement(gameVariableHolder.getRow()+i, gameVariableHolder.getColumn()+j)) == gameVariableHolder.getCurrentSymbolCode())
                    {
                        countOccurences += 1;
                        row = i;
                        column = j;
                        if(checkWinnerByVector(row,column,countOccurences))
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
