package com.company;

import java.util.Scanner;

public class PlayerMoveService {
    private GameVariableHolder gameVariableHolder = GameVariableHolder.getInstance();
    private DisplayFieldService displayFieldService = new DisplayFieldService();
    private CheckWinStatus checkWinStatus = new CheckWinStatus();
    private Integer move, currentSymbolCode , limit , row , column;
    private boolean winflag, player;
    private Scanner scan;


    public Boolean playGame(Field field){
        winflag=false;
        scan = new Scanner(System.in);
        player=true;
        limit = GameVariableHolder.getLimit();

        field.resetField();
        displayFieldService.printField(field.getField());

        while (!winflag)
        {
            currentSymbolCode = (checkWhoseMove(player));
            while (true){
                try {
                    setRowAndColumn(scan);

                    //System.out.println(gameVariableHolder.getRow() + " " + gameVariableHolder.getColumn());
                    if (field.getElement(row, column) == 3) {
                        field.setElement(row, column, currentSymbolCode);
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
            winflag=(checkWinStatus.CheckCurrentSymbolAround(field,currentSymbolCode, row, column));
            player= !player;
        }
        return player;
    }


    private void setRowAndColumn(Scanner scan){
        System.out.println("Put x pos in range [0:14]");
//        gameVariableHolder.setRow(Integer.parseInt(scan.nextLine())+limit);
        row=(Integer.parseInt(scan.nextLine())+limit);

        System.out.println("Put y pos in range [0:14]");
        //gameVariableHolder.setColumn(Integer.parseInt(scan.nextLine())+limit);
        column = (Integer.parseInt(scan.nextLine())+limit);
        //return (row, column);
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
