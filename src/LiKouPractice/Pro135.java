package LiKouPractice;

import java.util.Arrays;

public class Pro135 {
	public static void main(String args[]) {
		Pro135 p = new Pro135();
		int[] a = { 1, 3, 4, 5, 2 };
		System.out.println(p.candy(a));
	}

	public int candy(int[] ratings) {
		if (ratings.length <= 1)
			return ratings.length;
		int left[] = new int[ratings.length];
		int right[] = new int[ratings.length];
		Arrays.fill(left, 1);
		Arrays.fill(right, 1);
		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i] > ratings[i - 1])
				left[i] = left[i - 1] + 1;
		}
		for (int i = ratings.length - 2; i >= 0; i++) {
			if (ratings[i] > ratings[i + 1])
				right[i] = right[i + 1] + 1;
		}
		int sum = 0;
		for (int i = 0; i < left.length; i++) {
			sum += Math.max(left[i], right[i]);
		}
		return sum;
	}
}
