package com.company;

public class Field {
    private int[][] field;
    private int row;
    private int column;

    public Field(Integer row, Integer column) {
        this.field = new int[row][column];
        this.row=row;
        this.column=column;
    }

    public int[][] getField() {
        return field;
    }

    public  void setField(int[][] field) {
        this.field = field;
    }

    public  Integer getElement(int row, int column){
        return (field[row][column]);
    }


    public  void setElement(int row, int column, Integer currentSymbolCode) {
        if (currentSymbolCode == 1 || currentSymbolCode == 2 || currentSymbolCode == 3) {
            field[row][column] = currentSymbolCode;
        }
    }


    void resetField(){
        this.field = new int[row][column];
        for(int i = 0; i < row; i++)
            for(int j = 0; j < column; j++)
                field[i][j] = 3; //set undefined field;
    }
}
