/*
 * Дана строка. Разделить строку на фрагменты по три подряд идущих символа. 
 * В каждом фрагменте средний символ заменить на случайный символ, не совпадающий 
 * ни с одним из символов этого фрагмента. Вывести в консоль фрагменты, 
 * упорядоченные по алфавиту.
 */

package l3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = in.next();
		
		if(str.length() % 3 != 0)
			System.out.println("Input string should be 3*x length");
		
		ArrayList<String> fragments = new ArrayList<>();
		for(int i = 0; i<str.length(); i=i+3)
			fragments.add(str.substring(i, i+3));
		
		for(int i = 0; i<fragments.size(); i++) {
			String s = fragments.get(i);
			char c;
			do {
				c = (char) ThreadLocalRandom.current().nextInt(32, 127);
			} while(s.indexOf(c) >= 0);
			fragments.set(i, new String(new char[] {s.charAt(0), c, s.charAt(2)}));		
		}
		
		Collections.sort(fragments);
		System.out.println(fragments);
	}
}
