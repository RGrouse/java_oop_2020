/*
 * Дана матрица. В каждой строке найти наибольший элемент. 
 * Из этих элементов найти наименьший и удалить ту строку, которой он принадлежит. 
 * Вывести исходную и получившуюся матрицы в консоль.
 */

package l2;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import java.util.Arrays;
import java.util.Comparator;

public class Main{
	public static void printArr(int[][] arr) {
		for(int i = 0; i<arr.length; i++){
            for(int j= 0; j<arr[i].length; j++)
                System.out.print(arr[i][j] + "\t");
            System.out.println();
        }
        System.out.println();
	}
	
     public static void main(String []args){
        Scanner in = new Scanner(System.in);
        int rowL = in.nextInt();
        int colL = in.nextInt();
        
        int[][] arr = new int[rowL][colL];
        
        for(int i = 0; i<rowL; i++)
            for(int j= 0; j<colL; j++)
                arr[i][j] = ThreadLocalRandom.current().nextInt(0, 100);
                
        printArr(arr);
        
        int[] tempMaxLocation = new int[colL];
        
        for(int i = 0; i<rowL; i++) {
        	int max = Integer.MIN_VALUE;
        	for (int j = 0; j < colL; j++) {
        	    if (arr[i][j] > max) {
        	        max = arr[i][j];
        	        tempMaxLocation[i] = j;
        	    }
        	}
        }
        
        int minRow = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i<rowL; i++) {
        	if (arr[i][tempMaxLocation[i]] < min) {
        		min = arr[i][tempMaxLocation[i]];
        		minRow = i;
        	}
        }
        
        int[][] arrModified = new int[rowL-1][];
        for(int i = 0, j = 0; i<rowL; i++, j++)
        	if(i!=minRow) {
        		arrModified[j] = arr[i];
        	} else {
        		j--;
        	}
        
        printArr(arrModified);
        
     }
}