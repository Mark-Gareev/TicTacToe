package com.company;

public class Field {
    private int[][] field;

    public Field(Integer row, Integer column) {
        this.field = new int[row][column];
    }

    public int[][] getField() {
        return field;
    }

    public  void setField(int[][] field) {
        this.field = field;
    }

    public  String getElement(int row, int column){
        return String.valueOf(field[row][column]);
    }


    public  void setElement(int row, int column, Integer currentSymbolCode) {
        if (currentSymbolCode == 1 || currentSymbolCode == 2 || currentSymbolCode == 3) {
            field[row][column] = currentSymbolCode;
        }
    }


    int[][] resetField(int[][] field, int row, int column){
        for(int i = 0; i < row; i++)
            for(int j = 0; j < column; j++)
                field[i][j] = 3; //set undefined field;
        return field;
    }
}
