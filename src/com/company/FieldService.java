package com.company;

public class FieldService {
    Field fieldObject;
    int[][] field;
    static GameVariableHolder gameVariableHolder = TicTacToeGame.gameVariableHolder;


    public FieldService(Field fieldObject){
        this.fieldObject = fieldObject;
        field= this.fieldObject.getField();
    }


    public  String getElement(int row, int column){
        return String.valueOf(field[row][column]);
    }


    public  void setElement(int row, int column, Integer currentSymbolCode){
        if (currentSymbolCode==1 || currentSymbolCode == 2 || currentSymbolCode == 3) {
            field[row][column] = currentSymbolCode;
        }
    }


    public int[][] getField(){
        return field;
    }


    void resetField(){
        field = new int[50][50];
        for(int i = 0; i < 50; i++)
            for(int j = 0; j < 50; j++)
                field[i][j] = 3; //set undefined field;
    }
}
