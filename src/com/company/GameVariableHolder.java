package com.company;

public class GameVariableHolder {

    private static GameVariableHolder instance;

    private GameVariableHolder(){
    }

        // ПРИ СОЗДАНИИ ТУТ СТАТИКИ, ТО rowsize и columnsize можно создать только если сделать их статическими, поэтому я воспользуюсь сеттером в классе Game
//    public static GameVariableHolder getInstance(Integer row, Integer column){
//        if (instance == null) {
//            instance = new GameVariableHolder();
//            this.rowSize=row;
//            this.columnSize=column;
//        }
//        return instance;
//    }


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

    public int rowSize;
    public int columnSize;

    private int limit = 5;
    private int row,column;
    private int currentSymbolCode;
    private boolean player = true;


    public int getLimit() {
        return limit;
    }


    public void setLimit(int limit) {
        this.limit = limit;
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


    public int getCurrentSymbolCode() {
        return currentSymbolCode;
    }


    public void setCurrentSymbolCode(int currentSymbolCode) {
        this.currentSymbolCode = currentSymbolCode;
    }


    public boolean isPlayer() {
        return player;
    }


    public void setPlayer(boolean player) {
        this.player = player;
    }


}
