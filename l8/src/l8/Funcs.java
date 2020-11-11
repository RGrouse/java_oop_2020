package l8;

public class Funcs {
	private void func1() {
		System.out.println("FUNC 1");
	}

	@ExecCount(2)
	private void func2() {
		System.out.println("FUNC 2");
	}

	@ExecCount(3)
	private void func3() {
		System.out.println("FUNC 3");
	}

	private void func4() {
		System.out.println("FUNC 4");
	}
}
