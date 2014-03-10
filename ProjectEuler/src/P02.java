public class P02 {

	public static void main(String[] args) {
		System.out.println(fib(7));
		System.out.println(fib(33));

		int res = 0;
		int x = 1;

		int z = P02.fib(x);
		while (z <= 4000000) {
			if (z % 2 == 0) {
				res += z;
			}
			z = P02.fib(++x);
		}
		
		System.out.println(res);
	}

	public static int fib(int num) {

		if (num <= 1) {
			return Math.max(0, num);
		}

		int a = fib(num - 1);
		int b = fib(num - 2);

		return a + b;
	}

}
