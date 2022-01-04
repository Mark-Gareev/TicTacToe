package com.company;

public class Field {

    private int[][] field = new int[GameVariableHolder.rowSize][GameVariableHolder.columnSize];

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
}
