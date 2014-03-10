import java.util.Arrays;

import com.manuel_iglesias.util.SetGenerator;

public class InsertionSort {

	public static void main(String[] args) {

		SetGenerator gen = new SetGenerator();
		
		int size = 50;

		Integer[] arr = gen.randomize(gen.range(1, gen.random(1, size)));

		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(sort(arr)));
	}

	public static <T extends Comparable<T>> T[] sort(T[] arr) {

		if (arr.length <= 1) {
			return arr;
		}

		int key = 1;
		while (key < arr.length) {

			for (int i = key; i > 0; i--) {
				if (arr[i].compareTo(arr[i - 1]) < 0) {
					T temp = arr[i - 1];
					arr[i - 1] = arr[i];
					arr[i] = temp;
				}
			}

			key++;
		}

		return arr;
	}
}
