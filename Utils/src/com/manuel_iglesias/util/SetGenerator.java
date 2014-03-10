package com.manuel_iglesias.util;

import java.util.Random;

public class SetGenerator {

	private Random rnd = new Random();

	public int random(int min, int max) {
		return min + rnd.nextInt(max - min + 1);
	}

	public Integer[] range(int start, int end) {
		int size = end - start + 1;

		Integer[] result = new Integer[size];

		for (int i = 0; i < size; i++) {
			result[i] = i + start;
		}

		return result;
	}

	public <T> T[] randomize(T[] arr) {

		for (int j = 0; j < arr.length; j++) {
			int k = this.random(0, arr.length - 1);
			T temp = arr[j];
			arr[j] = arr[k];
			arr[k] = temp;
		}

		return arr;
	}
}
