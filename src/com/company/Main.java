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
            resetArray();
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
                winFlag = winCheck(x,y,currentSymbolCode);
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
    static void resetArray(){
        for(int i = 0; i < 50; i++)
            for(int j = 0; j < 50; j++)
                field[i][j] = 3; //set undefined field;
    }
    static boolean winCheck(int x, int y, int symbolNumber)
    {
        boolean innerflag = false;
        int vector_x,vector_y,innerCounter = 1;
        for(int i = -1;i < 2; i++)
        {
            for(int j = -1; j < 2; j++)
            {
                if((i != 0)|(j != 0))
                {
                    if(field[x+i][y+j] == symbolNumber)
                    {
                        innerCounter += 1;
                        vector_x = i;
                        vector_y = j;
                        if(CheckWinner.vectorWinCheck(x,y,vector_x,vector_y,innerCounter,symbolNumber,field,limit))
                        {
                            innerflag = true;
                            break;
                        }
                    }
                }
            }
        }
        return innerflag;
    }
}
