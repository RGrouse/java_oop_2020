/*
Описать класс, представляющий треугольник. 
Предусмотреть методы для создания объектов, 
вычисления площади, периметра и точки пересечения медиан. 
Описать свойства для получения состояния объекта.
*/

package l4;

public class Main {

    public static void main(String[] args) {

        Point a, b, c;
        a = new Point(0.0,0.0);
        b = new Point(10.0,0.0);
        c = new Point(3.0,6.0);

        Triangle treangle = new Triangle(a, b, c);

        System.out.println(treangle);

        double per = treangle.perimeter();

        System.out.println("P = " + per + "\n");

        double area = treangle.area();

        System.out.println("S = " + area + "\n");

        Point centroid = treangle.centroid();

        System.out.println("Centroid:" + centroid);

    }
}
