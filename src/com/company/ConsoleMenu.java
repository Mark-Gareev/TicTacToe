package com.company;

import java.util.Scanner;

public class ConsoleMenu {
    PlayerMoveService playerMoveService = new PlayerMoveService();
    String control;
    Scanner scan;
    Boolean player;

    public void startGame( Field field){
        control = "y";
        scan = new Scanner(System.in);
        while((control.equals("y")))
        {
            player = playerMoveService.playGame(field);
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
