package com.company;

public class DisplayFieldService {

    private int limit, rowSize, columnSize;

    public void printField(int[][] field) {
        limit =  GameVariableHolder.getLimit();
        rowSize = GameVariableHolder.getRowSize();
        columnSize = GameVariableHolder.getColumnSize();

        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < columnSize; j++) {
                if ((i < limit) | (j < limit) | i > rowSize-limit | j > columnSize-limit)
                    System.out.print("-|");
                else if (field[i][j] == 1)
                    System.out.print("X|");
                else if (field[i][j] == 2)
                    System.out.print("O|");
                else
                    System.out.print(" |");
            }
            System.out.println();
        }
    }
}
