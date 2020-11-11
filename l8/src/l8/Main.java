package l8;

/*
 * Написать аннотацию с целочисленным параметром. Создать класс, 
 * содержащий только приватные методы (3-4шт), аннотировать любые 
 * из них. Вызвать из другого класса все аннотированные методы 
 * столько раз, сколько указано в параметре аннотации.
*/

import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args) {
		Funcs f = new Funcs();
		Class<?> funcsClass = f.getClass();
		for (Method method : funcsClass.getDeclaredMethods()) {
			if (method.isAnnotationPresent(ExecCount.class)) {
				method.setAccessible(true);
				for (int i = 0; i < method.getAnnotation(ExecCount.class).value(); i++) {
					try {
						method.invoke(f);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

}
