package pl.sudokugame;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class SudokuBoard {

    //This class is responsible for adding numbers to the board and load board from a file.

    private int[][] sudokuTab;

    public SudokuBoard() {
        this.sudokuTab = new int[9][9];
    }

    public void loadSudokuTab(File sudokuTabFile) {
        try (Scanner scanner = new Scanner(sudokuTabFile)) {
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
    }

    public int[][] getSudokuTab() {
        return this.sudokuTab;
    }

    public void setSudokuTab(int[][] sudokuTab) {
        this.sudokuTab = sudokuTab;
    }

    public int testField() {
        return this.sudokuTab[5][5];
    }

    public void printBoard() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print((this.sudokuTab[i][j]) + " ");
            }
            System.out.println();
        }
    }

    public void addNumbers(int row, int column, int number) {
        this.sudokuTab[row][column] = number;
    }

    public boolean checkSudokuGame() {
        return SudokuChecker.check(this);
    }

}
