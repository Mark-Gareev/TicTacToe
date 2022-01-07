package com.company;

import java.util.Scanner;

public class ConsoleMenu {
    CheckWinStatus checkWinStatus = new CheckWinStatus();
    DisplayFieldService displayFieldService = new DisplayFieldService();
    PlayerMoveService playerMoveService = new PlayerMoveService();

    public void startGame(GameVariableHolder gameVariableHolder, Field field){
        int limit = gameVariableHolder.getLimit();
        String control = "y";
        boolean winflag;
        while((control.equals("y")))
        {
            winflag=false;
            Scanner scan = new Scanner(System.in);
            field.resetField();
            displayFieldService.printField(field.getField());
            while (!winflag)
            {
                gameVariableHolder.setCurrentSymbolCode(playerMoveService.checkWhoseMove(gameVariableHolder.isPlayer()));
                while (true)
                {
                    try {
                        System.out.println("Put x pos in range [0:14]");
                        gameVariableHolder.setRow(Integer.parseInt(scan.nextLine())+limit);
                        System.out.println("Put y pos in range [0:14]");
                        gameVariableHolder.setColumn(Integer.parseInt(scan.nextLine())+limit);
                        //System.out.println(gameVariableHolder.getRow() + " " + gameVariableHolder.getColumn());
                        if (field.getElement(gameVariableHolder.getRow(), gameVariableHolder.getColumn()) == 3) {

                            field.setElement(gameVariableHolder.getRow(), gameVariableHolder.getColumn(), gameVariableHolder.getCurrentSymbolCode());
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
                winflag=(checkWinStatus.CheckCurrentSymbolAround(field));
                gameVariableHolder.setPlayer(!gameVariableHolder.isPlayer());
            }
            if(!gameVariableHolder.isPlayer())
                System.out.println("Player 1 wins");
            else
                System.out.println("Player 2 wins");
            //ask to exit
            System.out.println("Play again?\n\ry|n");
            control = scan.nextLine();
        }
    }
}
