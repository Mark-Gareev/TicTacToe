package com.company;

import java.util.Scanner;

public class ConsoleMenu {
    CheckWinStatus checkWinStatus = new CheckWinStatus();
    DisplayFieldService displayFieldService = new DisplayFieldService();

    public void startGame(GameVariableHolder gameVariableHolder, Field field){
        int limit = gameVariableHolder.getLimit();
        String control = "y";
        while((control.equals("y")))
        {
            gameVariableHolder.setWinFlag(false);
            Scanner scan = new Scanner(System.in);
            field.resetField(field.getField(), gameVariableHolder.getRowSize(), gameVariableHolder.getColumnSize());
            displayFieldService.printField(field.getField());
            while (!gameVariableHolder.isWinFlag())
            {
                if (gameVariableHolder.isPlayer()) {
                    System.out.println("Player 1 turn!");
                    gameVariableHolder.setCurrentSymbolCode(1);
                }
                else {
                    System.out.println("Player 2 turn!");
                    gameVariableHolder.setCurrentSymbolCode(2);
                }
                while (true)
                {
                    try {
                        System.out.println("Put x pos in range [0:14]");
                        gameVariableHolder.setRow(Integer.parseInt(scan.nextLine())+limit);
                        System.out.println("Put y pos in range [0:14]");
                        gameVariableHolder.setColumn(Integer.parseInt(scan.nextLine())+limit);
                        System.out.println(gameVariableHolder.getRow() + " " + gameVariableHolder.getColumn());
                        if (Integer.parseInt(field.getElement(gameVariableHolder.getRow(),
                                gameVariableHolder.getColumn())) == 3) {

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
                gameVariableHolder.setWinFlag(checkWinStatus.CheckCurrentSymbolAround(field));
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
