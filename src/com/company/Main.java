package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    //little codelist for field array: 1 -- x; 2 -- o; 3 -- undefined;

    //probably can change this variables
    static int[][] field = new int[50][50];//field can change size; playable size = size*2;
    static int limit = 5;//quantity of symbols to win


    static boolean winFlag;
    static int x,y;
    static int currentSymbolCode;
    static boolean player = true;
    public static void main(String[] args) {
	// tictactoe program
        //process
        String control = "y";
        while((control.equals("y")))
        {
            Scanner scan = new Scanner(System.in);
            //game
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
                //checkwin
                fieldPrint();
                winFlag = winCheck(x,y,currentSymbolCode);
                //player change
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
    static boolean winCheck(int x, int y, int symbolNumber)//x,y-position; symbolNumber -- field code to wincheck;
    {
        //System.out.println("TESTWincheck starts!");
        boolean innerflag = false;
        int vector_x,vector_y,innerCounter = 1;
        //finding vector to check it
        for(int i = -1;i < 2; i++)
        {
            for(int j = -1; j < 2; j++)
            {
                //System.out.println("TESTWinnercheck Pos = "+i+" "+j);
                if((i != 0)|(j != 0))
                {
                    //System.out.println("TESTElement is "+field[x+i][y+j]);
                    if(field[x+i][y+j] == symbolNumber)//y+1 means x position,x+1 means y position
                    {
                        innerCounter += 1;
                        //System.out.println("TESTincount = "+innerCounter);
                        vector_x = i;
                        //System.out.println("TESTvectorx = "+vector_x);
                        vector_y = j;
                        //System.out.println("TESTvectory = "+vector_y);
                        //System.out.println("TESTwincheckSymbolNumber = "+symbolNumber);
                        if(vectorWinCheck(x,y,vector_x,vector_y,innerCounter,symbolNumber))
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
    static boolean vectorWinCheck(int x,int y,int vect_x,int vect_y,int count,int symbolNumber)
    {
        boolean enough = false;
        int a = 2;
        //System.out.println("TESTvectorcheck starts");
        while (count < limit) //in positive direction
        {
            //System.out.println("TESTvectorcheckPos" + (x + (vect_x * a)-3)+" "+ (y + (vect_y * a)-3));
            //System.out.println("TESTDistance from beg: "+vect_x*a + " "+ vect_y*a);
            //System.out.println("TESTchecking : "+field[x + (vect_x * a)][y + (vect_y * a)]+" in positive direction");

            //System.out.println("TESTvectorcheckSymbolNumbler is "+ symbolNumber);
            if (field[x + vect_x * a][y + vect_y * a] == symbolNumber)
            {
                count++;
                //System.out.println("TESTcount in positive cycle= "+count);
                a++;
            }
            else
            {
                break;
            }
        }
        a = 1;
        while(count < limit) //in negative direction
        {
           // System.out.println("TESTvectorcheckPos" + (x + (vect_x * a)-3)+" "+ (y + (vect_y * a)-3));
            //System.out.println("TESTDistance from beg: "+vect_x*a + " "+ vect_y*a);
            //System.out.println("TESTchecking : "+field[x - (vect_x * a)][y - (vect_y * a)]+" in negative direction");
            //System.out.println("TESTvectorcheckPos" + (x + (vect_x * a)-3)+" "+ (y + (vect_y * a)-3));
            //System.out.println("TESTvectorcheckSymbolNumbler is "+ symbolNumber);
            if (field[x + (vect_x * -a)][y + (vect_y * -a)] == symbolNumber)
            {
                count++;
                //System.out.println("TESTCount in negtive cycle = "+ count);
                a++;
            }
            else
            {
                break;
            }
        }
        if (count == limit)
            enough = true;
        return enough;
    }
    static void fieldPrint(){
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++)
            {
                if((i<5)|(j<5)|i>43|j>43)
                    System.out.print("-|");
                else
                    if(field[i][j] == 1)
                        System.out.print("X|");
                    else
                        if(field[i][j] == 2)
                            System.out.print("O|");
                        else
                            System.out.print(" |");
            }
            System.out.println();
            //System.out.println("--------------------------");
        }

    }
}
