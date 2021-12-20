package com.company;

public class StringField {

    public static void printField(int[][] field) {
        //String result = "";
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                if ((i < 5) | (j < 5) | i > 43 | j > 43)
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
        //return result;
    }
}