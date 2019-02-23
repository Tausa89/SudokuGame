package pl.sudokuGame;

import java.util.Arrays;

public class SudokuChecker {

    //Program check if sudoku board is correct and return value true or false.


    public boolean sudokuChecker(int[][] sudokuTab) {

        int[] goodNumbers = new int[9];

        int row = 0;

        int col = 0;

        int[] sortedNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};


        for (row = 0; row < sudokuTab.length; row++) {

            for (col = 0; col < sudokuTab.length; col++) {

                goodNumbers[col] = sudokuTab[row][col];

            }


            Arrays.sort(goodNumbers);

            //Program check if numbers in row are not duplicated.

            if (!Arrays.equals(goodNumbers, sortedNumbers)) {

                return false;
            }

        }

        return true;

    }


}

