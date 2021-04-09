package LiKouPractice;

import java.util.Arrays;

public class Pro5653 {
	public int countGoodRectangles(int[][] rectangles) {
		if (rectangles.length == 0)
			return 0;
		int res[] = new int[rectangles.length];
		for (int i = 0; i < rectangles.length; i++) {
			res[i] = Math.min(rectangles[i][0], rectangles[i][1]);
		}
		Arrays.sort(res);
		int flag = res[res.length - 1];
		int count = 0;
		for (int i = res.length - 1; i >= 0; i--) {
			if (res[i] == flag)
				count++;
			else {
				break;
			}
		}
		return count;
	}

}
