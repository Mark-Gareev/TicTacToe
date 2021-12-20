package com.company;

import java.util.Scanner;

public class Main {
    static int[][] field = new int[50][50];
    static int limit = 5;


    static boolean winFlag;
    static int x,y;
    static int currentSymbolCode;
    static boolean player = true;


    public static void main(String[] args) {

        String control = "y";
        while((control.equals("y")))
        {
            Scanner scan = new Scanner(System.in);
            field=StringField.resetArray(field);
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
                            x = Integer.parseInt(scan.nextLine()) + 5;
                            System.out.println("Put y pos in range [0:40]");
                            y = Integer.parseInt(scan.nextLine()) + 5;
                            if (field[x][y] == 3) {
                                field[x][y] = currentSymbolCode;
                                break;
                            }
                            System.out.println("wrong position");
                        }
                        catch (Exception e)
                        {
                            System.out.println("OUT OF RANGE");
                        }
                }
                    StringField.printField(field);
                winFlag = CheckWinner.winCheck(x,y,currentSymbolCode, field, limit);
                player = !player;
            }
            if(!player)
                System.out.println("Player 1 wins");
            else
                System.out.println("Player 2 wins");
            //ask to exit
            System.out.println("Play again?\n\r y|n");
            control = scan.nextLine();
        }
    }
}
