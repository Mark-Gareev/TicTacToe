package com.company;

import java.util.Scanner;

public class TicTacToeGame {
    static FieldService fieldService = new FieldService(new Field());
    static GameVariableHolder gameVariableHolder = new GameVariableHolder();


    public static void main(String[] args) {

        String control = "y";
        while((control.equals("y")))
        {
            gameVariableHolder.setWinFlag(false);
            Scanner scan = new Scanner(System.in);
            fieldService.resetField();
            DisplayFieldService.printField(); // Только один метод отвечает за отрисовку всего поля
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
                            System.out.println("Put x pos in range [0:40]");
                            gameVariableHolder.setRow(Integer.parseInt(scan.nextLine()) + 5);
                            System.out.println("Put y pos in range [0:40]");
                            gameVariableHolder.setColumn(Integer.parseInt(scan.nextLine()) + 5);
                            if (Integer.parseInt(fieldService.getElement(gameVariableHolder.getRow(),
                                    gameVariableHolder.getColumn())) == 3) {

                                fieldService.setElement(gameVariableHolder.getRow(), gameVariableHolder.getColumn(), gameVariableHolder.getCurrentSymbolCode());
                                break;

                            }
                            System.out.println("wrong position");
                        }
                        catch (Exception e)
                        {
                            System.out.println("OUT OF RANGE");
                        }
                }
                DisplayFieldService.printField();
                gameVariableHolder.setWinFlag(CheckWinStatus.CheckCurrentSymbolAround());
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
