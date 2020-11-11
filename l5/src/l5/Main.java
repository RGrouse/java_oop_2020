package l5;

/*
 * Пользователь вводит некоторое число. Записать его цифры в стек. 
 * Вывести число, у которого цифры идут в обратном порядке. 
 * Предусмотреть возможность введения произвольного количества чисел.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
    	ArrayList<Integer> arr = inputNumbers();
        System.out.println(arr);
    }

    private static ArrayList<Integer> inputNumbers() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();
        System.out.println("Введите числа:");
        boolean exit = false;

        while(!exit) {
            try {
                int number = scanner.nextInt();
                arr.add(number);
            } catch(Exception error) {
                exit = true;
            }
        }
        
        for(int i = 0; i<arr.size(); i++)
        	arr.set(i, reverseNumber(arr.get(i)));
        
        return arr;
    }

    private static int reverseNumber(int number) {
    	LinkedList<Integer> stack = new LinkedList<>();

        while(number != 0) {
        	stack.addFirst(number%10);
        	number /= 10;
        }
        
        int powValue = 0;
        int result = 0;
        while(!stack.isEmpty())
        	result += stack.pop()*Math.pow(10, powValue++);
        return result;
    }
}