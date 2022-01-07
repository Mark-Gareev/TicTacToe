package com.company;

import java.util.Scanner;

public class Game {
    ConsoleMenu consoleMenu = new ConsoleMenu();
    GameVariableHolder gameVariableHolder;
    Field field;

    public void runGame(){
        Integer x,y;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the size of the field\nFirst, enter x");

        while (true) {
            try {
                x = Integer.parseInt(scan.nextLine());
                break;
            } catch (Exception e){
                System.out.println("oops, something is wrong. Try again !");
            }
        }

        System.out.println("Now enter y");

        while (true)
        try{
            y = Integer.parseInt(scan.nextLine());
            break;
        }catch (Exception e){
            System.out.println("Something is wrong... Try again !");
        }

        field = new Field(x,y);
        GameVariableHolder instance = gameVariableHolder.getInstance(x,y);
        consoleMenu.startGame(instance, field);
    }
}
