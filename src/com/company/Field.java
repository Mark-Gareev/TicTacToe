package com.company;

public class Field {

    int[][] field = new int[GameVariableHolder.rowSize][GameVariableHolder.columnSize];

    public  int[][] getField() {
        return field;
    }

    public  void setField(int[][] field) {
        this.field = field;
    }


}
