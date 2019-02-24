package pl.sudokuGame;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class SudokuBoard {

    //This class is responsible for adding numbers to the board and load board from a file.

    private int[][] sudokuTab;

    public SudokuBoard() {

        this.sudokuTab = new int[9][9];

    }

    public int[][] loadSudokuTab() {

        String inputPath = "C:\\Users\\Lukasz\\Desktop\\Programowanie\\sudoku.txt";

        File file = new File(inputPath);

        //Program load sudoku board from a file and print it.


        try (Scanner scanner = new Scanner(file)) {

            for (int i = 0; i < 9; i++) {

                for (int j = 0; j < 9; j++) {

                    if (scanner.hasNext()) {

                        this.sudokuTab[i][j] = scanner.nextInt();

                    } else {

                        throw new IOException("File input error");
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        printBoard();


        return this.sudokuTab;
    }

    public int[][] getSudokuTab() {

        return this.sudokuTab;

    }

    public int testField() {

        return this.sudokuTab[5][5];
    }

    public void setSudokuTab(int[][] sudokuTab) {

        this.sudokuTab = sudokuTab;
    }

    public void printBoard() {

        for (int i = 0; i < 9; i++) {

            for (int j = 0; j < 9; j++) {

                System.out.print((this.sudokuTab[i][j]) + " ");
            }
            System.out.println();

        }
    }

    public void addingNumbers() {

        Scanner input = new Scanner(System.in);


        while (true) {

            int cor1 = Integer.parseInt(input.nextLine());

            if (cor1 == -1) {

                break;

            } else {

                int cor2 = Integer.parseInt(input.nextLine());

                int sudokuNumber = Integer.parseInt(input.nextLine());

                this.sudokuTab[cor1][cor2] = sudokuNumber;

                printBoard();

            }

        }
    }

    public boolean checkSudokuGame() {

        SudokuChecker check = new SudokuChecker();

        return check.sudokuChecker(this.sudokuTab);
    }

}
