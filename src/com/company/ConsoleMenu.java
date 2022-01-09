package com.company;

import java.util.Scanner;

public class ConsoleMenu {
    PlayerMoveService playerMoveService = new PlayerMoveService();

    public void startGame(GameVariableHolder gameVariableHolder, Field field){
        String control = "y";
        Scanner scan = new Scanner(System.in);
        Boolean player;
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
