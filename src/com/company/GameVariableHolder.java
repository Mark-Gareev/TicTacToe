package com.company;

public class GameVariableHolder {

    private static GameVariableHolder instance;

    private static int limit ,columnSize ,rowSize ;

    private GameVariableHolder(){
    }


    public static GameVariableHolder getInstance(){
        if (instance == null){
            instance= new GameVariableHolder();
        }
        return instance;
    }

    public static int getRowSize() {
        return rowSize;
    }

    static void setRowSize(int parametr) {
        rowSize = parametr;
    }

    public static int getColumnSize() {
        return columnSize;
    }

    static void setColumnSize(int parametr) {
        columnSize = parametr;
    }


    static void setLimit(int parametr){
        limit = parametr;
    }

    public static int getLimit(){
        return limit;
    }
}
