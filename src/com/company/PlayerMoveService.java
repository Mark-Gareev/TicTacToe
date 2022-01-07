package com.company;

public class PlayerMoveService {
    GameVariableHolder gameVariableHolder = GameVariableHolder.getInstance();
    Integer move;

    public PlayerMoveService(){
    }


    public int checkWhoseMove(Boolean player){

        if (player) {
            System.out.println("Player 1 turn!");
            move=1;
        } else {
            System.out.println("Player 2 turn!");
            move=2;
        }
        return move;

    }
}
