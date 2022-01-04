package com.company;

public class GameVariableHolder {

    static int rowSize = 50; // тут я оставил статику, так как она не сильно кретична
    static int columnSize = 50; // тут тож

    private int limit = 5;
    private boolean winFlag;
    private int row,column;
    private int currentSymbolCode;
    private boolean player = true;


    public int getLimit() {
        return limit;
    }


    public void setLimit(int limit) {
        this.limit = limit;
    }


    public boolean isWinFlag() {
        return winFlag;
    }


    public void setWinFlag(boolean winFlag) {
        this.winFlag = winFlag;
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
