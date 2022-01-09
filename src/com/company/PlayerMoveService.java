package com.company;

import java.util.Scanner;

public class PlayerMoveService {
    GameVariableHolder gameVariableHolder = GameVariableHolder.getInstance();
    DisplayFieldService displayFieldService = new DisplayFieldService();
    CheckWinStatus checkWinStatus = new CheckWinStatus();
    Integer move;
    int currentSymbolCode;
    int limit = GameVariableHolder.limit;
    boolean winflag;
    boolean player;
    Scanner scan;


    public PlayerMoveService(){
    }

    public Boolean playGame(Field field){
        winflag=false;
        scan = new Scanner(System.in);
        player=true;

        field.resetField();
        displayFieldService.printField(field.getField());

        while (!winflag)
        {
            currentSymbolCode = (checkWhoseMove(player));
            while (true){
                try {
                    setRowAndColumn(scan);
                    //System.out.println(gameVariableHolder.getRow() + " " + gameVariableHolder.getColumn());
                    if (field.getElement(gameVariableHolder.getRow(), gameVariableHolder.getColumn()) == 3) {
                        field.setElement(gameVariableHolder.getRow(), gameVariableHolder.getColumn(), currentSymbolCode);
                        break;
                    }
                    System.out.println("wrong position");
                }
                catch (Exception e)
                {
                    System.out.println("OUT OF RANGE");
                }
            }
            displayFieldService.printField(field.getField());
            winflag=(checkWinStatus.CheckCurrentSymbolAround(field,currentSymbolCode));
            player= !player;
        }
//        if(!player)
//            System.out.println("Player 1 wins");
//        else
//            System.out.println("Player 2 wins");
//        //ask to exit
//        System.out.println("Play again?\n\ry|n");
//        control = scan.nextLine();
        return player;
    }


    public void setRowAndColumn(Scanner scan){
        System.out.println("Put x pos in range [0:14]");
        gameVariableHolder.setRow(Integer.parseInt(scan.nextLine())+limit);
        System.out.println("Put y pos in range [0:14]");
        gameVariableHolder.setColumn(Integer.parseInt(scan.nextLine())+limit);
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
