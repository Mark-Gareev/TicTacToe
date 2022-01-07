package com.company;

import java.util.Scanner;

public class Game {
    ConsoleMenu consoleMenu = new ConsoleMenu();
    private final GameVariableHolder gameVariableHolder = GameVariableHolder.getInstance();
    Field field;

    public void runGame(){
        Integer x,y, limit;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the size of the field\nFirst, enter x");

        // подуматьь че делать с этой ебалой (как оптимизировать ее)
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


        System.out.println("Now enter your limit until the win");

        while (true)
            try{
                limit = Integer.parseInt(scan.nextLine());
                break;
            }catch (Exception e){
                System.out.println("Something is wrong... Try again !");
            }

        field = new Field(x,y);

        gameVariableHolder.setRowSize(x);
        gameVariableHolder.setColumnSize(y);
        gameVariableHolder.setLimit(limit);

        DisplayFieldService displayFieldService = new DisplayFieldService();
        displayFieldService.printField(field.getField());
        consoleMenu.startGame(gameVariableHolder, field);
    }
}
