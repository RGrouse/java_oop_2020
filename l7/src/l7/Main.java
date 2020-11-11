/*
С использованием streamAPI реализовать следующие методы:
-метод, возвращающий среднее значение списка целых чисел
-метод, приводящий все строки в списке в верхний регистр
-метод возвращающий список квадратов всех уникальных элементов списка
*/

package l7;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Integer> l1 = Arrays.asList(1,2,3,4,5,6,7,8,9);
        System.out.println(midVal(l1));

        List<String> strList = Arrays.asList("первое","СлоВо","дороjoe");
        System.out.println(getUpperRegister(strList));

        List<Integer> l2 = Arrays.asList(1,1,2,3,4,5,6,6,7,8,9);
        System.out.println(getPowOfElem(l2));

    }

    private static double midVal(List<Integer> list) {
        return list.stream().reduce(0, Integer::sum) / (double) list.size();
    }

    private static List<String> getUpperRegister(List<String> list) {
        return list.stream().map(String::toUpperCase).collect(Collectors.toList());
    }

    private static List<Integer> getPowOfElem(List<Integer> list) {
        return list.stream().filter(x -> Collections.frequency(list, x) == 1).map(x -> x*x).collect(Collectors.toList());
    }

}