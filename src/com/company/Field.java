package com.company;

public class Field {

    int[][] field = new int[50][50];

    public int[][] init (){
        return field;
    }


    public  int[][] getField() {
        return field;
    }

    public  void setField(int[][] field) {
        this.field = field;
    }


}
