/*
Дан массив без повторяющихся элементов. Перемешать его элементы случайным образом так,
чтобы каждый элемент оказался на новом месте. Вывести исходный и получившийся массивы в консоль.
*/

package l1;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
		Scanner inputVal = new Scanner(System.in);
	    
	    var size = inputVal.nextInt();

        int[] array = generateArray(size);

        outputArray(array);

        var newArray = shuffleSattolo(array);

        outputArray(newArray);
        
        inputVal.close();
    }

    private static int[] generateArray(int size) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }

    private static void outputArray(int[] array) {
        for (int i : array)
            System.out.print(i + "\t");
        System.out.println("\n");
    }
    
    private static int[] shuffleSattolo(int[] array) {
        Random random = new Random();
        int i = array.length;
        while(i > 1) {
            int j = random.nextInt(--i);
            var tmp = array[j];
            array[j] = array[i];
            array[i] = tmp;
        }
        return array;
    }

}
