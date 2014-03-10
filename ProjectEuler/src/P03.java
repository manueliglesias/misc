import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P03 {

	public static void main(String[] args) {

		// 9007199254740881l
		// 600851475143l
		System.out.println(Arrays.toString(primeFactors(600851475143l)));
	}

	public static long[] primeFactors(long l) {

		List<Long> result = new ArrayList<>();

		long limit = (long) Math.sqrt(l);

		for (long i = 2; i <= limit;) {

			if (l % i == 0) {
				result.add(i);
				l = l / i;

				continue;
			}

			i++;
		}

		long[] r = new long[result.size()];

		int i = 0;
		for (Long n : result) {
			r[i++] = n;
		}

		return r;

	}

}
