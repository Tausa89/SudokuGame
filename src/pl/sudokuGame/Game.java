package pl.sudokuGame;

import java.util.Scanner;

public class Game {


    public static void main(String args[]) {

        options();

    }
    //Program print out game Menu.

    static void gameMenu() {

        System.out.println("If you want start new game press: n.\n"
                + "If you want to continue game press: k.\n"
                + "If you want to check your suddoku table: c.\n"
                + "If you want to exit game press: e");

    }

    //Program working depend on chose form gameMenu

    static void options() {

        String options = "";
        Scanner input = new Scanner(System.in);
        System.out.println("");

        AddingNumbers sudoku = new AddingNumbers();

        Checking check = new Checking();


        while (!options.equalsIgnoreCase("e")) {

            gameMenu();
            options = input.nextLine();


            if (options.equalsIgnoreCase("n")) {

                System.out.println("You can add your number to Sudoku board be giving \n"
                        + "coordinates on board. For example if you write 0 \n"
                        + "pres Enter, 0 pres Enter then write your number and \n"
                        + "confirm it with Enter you will see your number in the \n"
                        + "first row and first column. \n"
                        + "Example: if your number was 1 you will see\n"
                        + "1 0 0 0 0 0 0 0 0\n"
                        + "0 0 0 0 0 0 0 0 0\n");
                System.out.println();

                System.out.println("If you want to stop adding numbers to the Sudoku board \n"
                        + "input -1 and confirm it with Enter \n"
                        + "You will go back to main menu where you can check your board, \n"
                        + "start a new one, continue old one or close game. ");
                System.out.println();

                System.out.println("This is your Sudoku board \n"
                        + "Have Fun!!!");
                System.out.println();


                sudoku.setSudokuTab(sudoku.loadingSudokuTab());
                sudoku.addingNumbers();


            } else if (options.equalsIgnoreCase("k")) {

                if (sudoku.testField() == 0) {
                    System.out.println("You need to start game first");
                } else if (!(sudoku.testField() == 0)) {

                    sudoku.printBoard();
                    sudoku.addingNumbers();
                }

            } else if (options.equalsIgnoreCase("c")) {

                boolean answer = check.sudokuChecker(sudoku.getSudokuTab());

                if (answer) {

                    System.out.println("Your Sudoku is correct!!!! Congratulations!!! ");

                } else System.out.println("Unfortunately your Sudoku is wrong but you can try again if you pres k" +
                        "or start new game if you pres n");
                System.out.println();

            } else if (options.equalsIgnoreCase("e")) {

                System.out.println("Thank you for playing\n"
                        +"See you next time.");

            } else
                System.out.println("Input was wrong try again");

        }
    }


}

