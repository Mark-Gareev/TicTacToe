package com.company;

import java.util.Scanner;

public class TicTacToeGame {
    static FieldService fieldService = new FieldService(new Field());

    static int limit = 5;

    static boolean winFlag;
    static int row,column;
    static int currentSymbolCode;
    static boolean player = true;


    public static void main(String[] args) {

        String control = "y";
        while((control.equals("y")))
        {
            winFlag= false;
            Scanner scan = new Scanner(System.in);
            fieldService.resetField();
            DisplayField.printField();
            while (!winFlag)
            {
                if (player) {
                    System.out.println("Player 1 turn!");
                    currentSymbolCode = 1;
                }
                else {
                    System.out.println("Player 2 turn!");
                    currentSymbolCode = 2;
                }
                    while (true)
                    {
                        try {
                            System.out.println("Put x pos in range [0:40]");
                            row = Integer.parseInt(scan.nextLine()) + 5;
                            System.out.println("Put y pos in range [0:40]");
                            column = Integer.parseInt(scan.nextLine()) + 5;
                            if (Integer.parseInt(fieldService.getElement(row,column)) == 3) {
                                fieldService.setElement(row,column, currentSymbolCode);
                                break;
                            }
                            System.out.println("wrong position");
                        }
                        catch (Exception e)
                        {
                            System.out.println("OUT OF RANGE");
                        }
                }
                DisplayField.printField();
                winFlag = CheckWinner.winCheck(row,column,currentSymbolCode, limit);
                player = !player;
            }
            if(!player)
                System.out.println("Player 1 wins");
            else
                System.out.println("Player 2 wins");
            //ask to exit
            System.out.println("Play again?\n\ry|n");
            control = scan.nextLine();
        }
    }
}
