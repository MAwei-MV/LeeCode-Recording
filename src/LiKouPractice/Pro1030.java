package LiKouPractice;

import java.util.LinkedList;
import java.util.Queue;

public class Pro1030 {
	// BFS
	public static void main(String args[]) {
		Pro1030 p = new Pro1030();
		System.out.println(p.allCellsDistOrder(2, 2, 0, 0));
	}

	public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
		int[][] res = new int[R * C][2];
		int flag[][] = new int[R][C];
		if (r0 >= R || c0 >= C)
			return null;
		Queue<int[]> queue = new LinkedList<>();
		int[] start = { r0, c0 };
		queue.offer(start);
		flag[r0][c0] = 1;
		int i = 0;
		while (!queue.isEmpty()) {
			res[i] = queue.poll();
			if (res[i][0] + 1 < R && flag[res[i][0] + 1][res[i][1]] == 0) {
				int a[] = { res[i][0] + 1, res[i][1] };
				queue.offer(a);
				flag[res[i][0] + 1][res[i][1]] = 1;
			}
			if (res[i][0] - 1 >= 0 && flag[res[i][0] - 1][res[i][1]] == 0) {
				int b[] = { res[i][0] - 1, res[i][1] };
				queue.offer(b);
				flag[res[i][0] - 1][res[i][1]] = 1;
			}
			if (res[i][1] - 1 >= 0 && flag[res[i][0]][res[i][1] - 1] == 0) {
				int d[] = { res[i][0], res[i][1] - 1 };
				queue.offer(d);
				flag[res[i][0]][res[i][1] - 1] = 1;
			}
			if (res[i][1] + 1 < C && flag[res[i][0]][res[i][1] + 1] == 0) {
				int e[] = { res[i][0], res[i][1] + 1 };
				queue.offer(e);
				flag[res[i][0]][res[i][1] + 1] = 1;
			}
			i++;
		}
		return res;
	}
}
