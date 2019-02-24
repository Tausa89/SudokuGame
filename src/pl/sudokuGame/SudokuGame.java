package pl.sudokuGame;

import java.util.Scanner;

public class SudokuGame {


    public static void main(String args[]) {

        String options = "";
        Scanner input = new Scanner(System.in);
        System.out.println("");
        NumbersAdder sudoku = new NumbersAdder();
        SudokuChecker check = new SudokuChecker();


        while (!options.equalsIgnoreCase("e")) {

            System.out.println(gameMenu(options));
            options = input.nextLine();


            switch (options.toUpperCase()){
                case "N":
                    startNewSudokuBoard(sudoku);
                    break;
                case "K":
                    continueSudokuBoard(sudoku);
                    break;
                case "C":
                    checkSudokuGame(sudoku,check);
                    break;
                case "E":
                    closeGame();
                    break;
                default:
                    System.out.println("Input was wrong try again");
                    break;

            }
        }

    }
    //Program print out game Menu.

    static String gameMenu(String option) {

        System.out.println("If you want start new game press: n.\n"
                + "If you want to continue game press: k.\n"
                + "If you want to check your suddoku table: c.\n"
                + "If you want to exit game press: e");

        return option;

    }


    public static void closeGame() {

        System.out.println("Thank you for playing\n"
                +"See you next time.");
    }

    public static void checkSudokuGame(NumbersAdder sudoku,SudokuChecker check) {


        boolean answer = check.sudokuChecker(sudoku.getSudokuTab());

        if (answer) {

            System.out.println("Your Sudoku is correct!!!! Congratulations!!! ");

        } else System.out.println("Unfortunately your Sudoku is wrong but you can try again if you pres k" +
                "or start new game if you pres n");
        System.out.println();
    }

    public static void continueSudokuBoard(NumbersAdder sudoku) {




        if (sudoku.testField() == 0) {
            System.out.println("You need to start game first");
        } else if ((sudoku.testField() !=0)) {

            sudoku.printBoard();
            sudoku.addingNumbers();

        }
    }

    public static void startNewSudokuBoard(NumbersAdder sudoku) {


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


        sudoku.setSudokuTab(sudoku.loadSudokuTab());
        sudoku.addingNumbers();
    }


}

