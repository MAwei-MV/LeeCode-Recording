package LiKouPractice;

import java.util.Arrays;
import java.util.Comparator;

public class Pro973 {
	public int[][] kClosest(int[][] points, int K) {
		Arrays.sort(points, new Comparator<int[]>() {
			public int compare(int[] point1, int[] point2) {
				return (point1[0] * point1[0] + point1[1] * point1[1])
						- (point2[0] * point2[0] + point2[1] * point2[1]);
			}
		});
		return Arrays.copyOfRange(points, 0, K);
	}

	public static void main(String args[]) {
		Pro973 p = new Pro973();
		int a[][] = { { 1, 3 }, { -2, 2 } };

		System.out.println(p.kClosest(a, 1));
	}

}
