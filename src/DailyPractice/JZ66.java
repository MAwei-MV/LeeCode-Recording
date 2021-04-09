package DailyPractice;

public class JZ66 {
	//DFS
	public int movingCount(int threshold, int rows, int cols) {
		int flag[][] = new int[rows][cols];
		for (int j = 0; j < flag.length; j++) {
			for (int i = 0; i < flag[0].length; i++) {
				flag[j][i] = 0;
			}
		}
		return bfs(threshold, rows, cols, 0, 0, flag);

		/*
		 * while (x <= rows - 1 && y <= cols - 1 && sum(x, y) <= threshold) { sum++;
		 * sum+ }
		 */
	}
	public int bfs(int threshold, int rows, int cols, int x, int y, int flag[][]) {
		if (x >= rows || y >= cols || sum(x, y) > threshold || flag[x][y] == 1)
			return 0;
		flag[x][y] = 1;
		return 1 + bfs(threshold, rows, cols, x + 1, y, flag) + bfs(threshold, rows, cols, x, y + 1, flag);
	}

	public int sum(int i, int j) {
		int sum = 0;
		do {
			sum += i % 10;
			sum += j % 10;
			i /= 10;
			j /= 10;
		} while (i > 0 || j > 0);
		return sum;
	}

	public static void main(String aegs[]) {
		JZ66 j = new JZ66();
		System.out.println(j.sum(222, 329));
	}
}
