package com.company;

import java.util.Scanner;

public class Game {
    ConsoleMenu consoleMenu = new ConsoleMenu();
    private final GameVariableHolder gameVariableHolder = GameVariableHolder.getInstance();
    private Field field;
    private Integer x,y, limit;
    private Scanner scan;


    public void runGame(){
        scan = new Scanner(System.in);
        System.out.println("Enter the size of the field\nFirst, enter row size");

        // вся ниже херня нужна для ввода пользователя. Не обращай внимания
        while (true) {
            try {
                x = Integer.parseInt(scan.nextLine());
                break;
            } catch (Exception e){
                System.out.println("oops, something is wrong. Try again !");
            }
        }


        System.out.println("Now enter column size");

        while (true)
        try{
            y = Integer.parseInt(scan.nextLine());
            break;
        }catch (Exception e){
            System.out.println("Something is wrong... Try again !");
        }


        System.out.println("Now enter your limit until the win (min is 2)");

        while (true)
            try{
                limit = Integer.parseInt(scan.nextLine());
                if (limit<=1) {
                        limit = 2;
                }
                break;
            }catch (Exception e){
                System.out.println("Something is wrong... Try again !");
            }

        field = new Field(x,y);

        setData(x,y,limit);

        //DisplayFieldService displayFieldService = new DisplayFieldService();
        //displayFieldService.printField(field.getField());
        consoleMenu.startGame( field);
    }

    private static void setData(int row, int column, int limit){
        GameVariableHolder.setRowSize(row);
        GameVariableHolder.setColumnSize(column);
        GameVariableHolder.setLimit(limit);



    }
}
