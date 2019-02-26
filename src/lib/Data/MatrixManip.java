package lib.Data;

import java.util.ArrayList;
import java.util.Arrays;

public class MatrixManip {
    public static void printTable(int[][] table) {
        printTable(table, 4);
    }

    public static void printTable(int[][] table, int spacing) {
        for (int[] row : table) {
            for (int cell : row) {
                System.out.printf("%" + spacing + "d", cell);
            }
            System.out.println();
        }
    }

    public static void printTable(char[][] table) {
        printTable(table, 4);
    }

    public static void printTable(char[][] table, int spacing) {
        for (char[] row : table) {
            for (char cell : row) {
                System.out.printf("%" + spacing + "c", cell);
            }
            System.out.println();
        }
    }

    public static void printTable(double[][] table) {
        printTable(table, 8, 2);
    }

    public static void printTable(double[][] table, int spacing, int decimalDigits) {
        for (double[] row : table) {
            for (double cell : row) {
                System.out.printf("%" + spacing + "." + decimalDigits + "f", cell);
            }
            System.out.println();
        }
    }

    public static int[][] buildTable(int rows, int cols, int... numbers){
        int[][] table = new int[rows][cols];
        int t = 0;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if(numbers.length > t)
                    table[i][j] = numbers[t++];
                else table[i][j] = 0;
            }
        }
        return table;
    }
    public static double[][] buildTable(int rows, int cols, double... numbers){
        double[][] table = new double[rows][cols];
        int t = 0;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if(numbers.length > t)
                    table[i][j] = numbers[t++];
                else table[i][j] = 0;
            }
        }
        return table;
    }
    public static char[][] buildTable(int rows, int cols, char... chars){
        char[][] table = new char[rows][cols];
        int t = 0;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if(chars.length > t)
                    table[i][j] = chars[t++];
                else table[i][j] = 0;
            }
        }
        return table;
    }

    public static double max(double[][] table) {
        double max = table[0][0];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if (table[i][j] > max) {
                    max = table[i][j];
                }
            }
        }
        return max;
    }

    public static int[] indexOfMax(double[][] table) {
        int[] indexOfMax = {0, 0};
        double max = table[0][0];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if (table[i][j] > max) {
                    max = table[i][j];
                    indexOfMax[0] = i;
                    indexOfMax[1] = j;
                }
            }
        }
        return indexOfMax;
    }

    public static double min(double[][] table) {
        double min = table[0][0];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if (table[i][j] > min) {
                    min = table[i][j];
                }
            }
        }
        return min;
    }

    public static int[] indexOfMin(double[][] table) {
        int[] indexOfMin = {0, 0};
        double min = table[0][0];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if (table[i][j] > min) {
                    min = table[i][j];
                    indexOfMin[0] = i;
                    indexOfMin[1] = j;
                }
            }
        }
        return indexOfMin;
    }

    public static void sort(int[][] table) {
        int[] min;
        for (int h = 0; h < table[h].length; h++) {

            for (int i = 0; i < table.length; i++) {
                for (int j = i + 1; j < table.length; j++) {
                    boolean isBrother = true;
                    for (int k = 0; k < h ; k++) {
                        if(table[i][k] != table[j][k])
                            isBrother = false;
                    }
                    if ( table[i][h] > table[j][h] && ( h == 0 || isBrother ) ) {
                        min = table[j];
                        table[j] = table[i];
                        table[i] = min;
                    }
                }
            }
        }
    }
    public static void sortRows(double[][] table){
        for (int row = 0; row < table.length; row++) {
            ArrayTool.bubbleSort(table[row]);
        }
    }
    public static double[][] sortColumns(double[][] table){
        double[][] inverted = invertXY(table);
        for (int row = 0; row < inverted.length; row++) {
            ArrayTool.bubbleSort(inverted[row]);
        }
        return invertXY(inverted);
    }

    public static int sumRow(int[][] table, int rowIndex){
        if(rowIndex >= table.length || rowIndex < 0)
            return 0;
        return ArrayTool.sum(table[rowIndex]);
    }
    public static int sumColumn(int[][] table, int columnIndex){
        if(columnIndex >= table.length || columnIndex < 0)
            return 0;
        int sum = 0;
        for (int row = 0; row < table[0].length; row++) {
            sum += table[row][columnIndex];
        }
        return sum;
    }

    public static int[][] indieClone(int[][] table){
        int[][] clone = new int[table.length][table[0].length];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                clone[i][j] = table[i][j];
            }
        }
        return clone;
    }

    public static double[][] invertXY(double[][] table){
        double[][] invertedTable = new double[table[0].length][table.length];
        for (int column = 0; column < table[0].length; column++) {
            for (int row = 0; row < table.length; row++) {
                invertedTable[column][row]= table[row][column];
            }
        }
        return invertedTable;
    }
}
