public class P01 {

	public static void main(String[] args) {

		int count = 999;

		int sum = P01.sum(count);

		System.out.println(sum);

		sum = P01.sum2(3) + P01.sum2(5) - P01.sum2(15);

		System.out.println(sum);

	}
	
	private static int sum(int n) {
		int sum = 0;
		for (int i = 1; i <= n; i++) {

			if (i % 3 == 0 || i % 5 == 0) {
				sum += i;
			}

		}
		
		return sum;
	}

	private static int sum2(int n) {
		int p = 999 / n;
		return n * ((p * (p + 1)) / 2);
	}
}
