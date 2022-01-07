package com.company;

public class PlayerMoveService {
    private int[][] field;

    public PlayerMoveService(Field fieldObject){
        field= fieldObject.getField();
    }

}
