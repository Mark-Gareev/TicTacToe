package com.company;

public class GameVariableHolder {

    private static GameVariableHolder instance;
    public static int rowSize;
    public static int columnSize;

    public static int limit;
    private int row,column;

    private GameVariableHolder(){
    }


    public static GameVariableHolder getInstance(){
        if (instance == null){
            instance= new GameVariableHolder();
        }
        return instance;
    }

    public int getRowSize() {
        return rowSize;
    }

    public void setRowSize(int rowSize) {
        this.rowSize = rowSize;
    }

    public int getColumnSize() {
        return columnSize;
    }

    public void setColumnSize(int columnSize) {
        this.columnSize = columnSize;
    }

    public int getRow() {
        return row;
    }


    public void setRow(int row) {
        this.row = row;
    }


    public int getColumn() {
        return column;
    }


    public void setColumn(int column) {
        this.column = column;
    }

}
