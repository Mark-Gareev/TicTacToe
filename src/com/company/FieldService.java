package com.company;

public class FieldService {
    private int[][] field;

    public FieldService(Field fieldObject){
        field= fieldObject.getField();
    }


    int[][] resetField(){
        field = new int[50][50];
        for(int i = 0; i < 50; i++)
            for(int j = 0; j < 50; j++)
                field[i][j] = 3; //set undefined field;
        return field;
    }
}
