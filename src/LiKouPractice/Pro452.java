package LiKouPractice;

import java.util.Arrays;
import java.util.Comparator;

public class Pro452 {
	public static void main(String args[]) {
		Pro452 p = new Pro452();
		int[][] x = { { 10, 16 }, { 2, 8 }, { 1, 6 }, { 7, 12 } };
		System.out.println(p.findMinArrowShots(x));
	}

	public int findMinArrowShots(int[][] points) {
		if (points.length == 0 || points.length == 1)
			return points.length;
		Arrays.sort(points, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] > o2[1]) {
					return 1;
				} else if (o1[1] < o2[1]) {
					return -1;
				} else {
					return 0;
				}
			}
		});
		int a = 1;
		int flag = points[0][1];
		for (int i = 1; i < points.length; i++) {
			if (points[i][0] > flag) {
				flag = points[i][1];
				a++;
			}
		}
		return a;
	}
}
