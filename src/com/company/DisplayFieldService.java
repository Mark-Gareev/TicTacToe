package com.company;

public class DisplayFieldService {

    private GameVariableHolder gameVariableHolder;
    private int limit = GameVariableHolder.limit;

    public void printField(int[][] field) {
        System.out.println(limit + " lim");
        for (int i = 0; i < gameVariableHolder.rowSize; i++) {
            for (int j = 0; j < gameVariableHolder.columnSize; j++) {
                if ((i < limit) | (j < limit) | i > gameVariableHolder.rowSize-limit | j > gameVariableHolder.columnSize-limit)
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

    public DisplayFieldService() {
        this.gameVariableHolder = GameVariableHolder.getInstance();
    }
}
