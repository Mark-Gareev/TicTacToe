package com.company;

public class Field {

    static int[][] field = new int[50][50];

    public static int[][] init (){
        return field;
    }


    public static int[][] getField() {
        return field;
    }

    public static void setField(int[][] field) {
        Field.field = field;
    }

    public static String getElement(int row, int column){
        return String.valueOf(field[row][column]);
    }

    public static void setElement(int row, int column, Integer currentSymbolCode){
        if (currentSymbolCode==1 || currentSymbolCode == 2 || currentSymbolCode == 3) {
            field[row][column] = currentSymbolCode;
        }
    }


    static int[][] resetField(){
        field = new int[50][50];
        for(int i = 0; i < 50; i++)
            for(int j = 0; j < 50; j++)
                field[i][j] = 3; //set undefined field;
        return field;
    }

}
