package interview;

import java.util.ArrayList;
import java.util.Arrays;

public class Pro1619 {
	public static void main(String args[]) {
		int[][] a = { { 0, 2, 1, 0 }, { 0, 1, 0, 1 }, { 1, 1, 0, 1 }, { 0, 1, 0, 1 } };
		Pro1619 p = new Pro1619();
		System.out.println(p.pondSizes(a));
	}

	public int[] pondSizes(int[][] land) {
		ArrayList<Integer> list = new ArrayList<>();
		if (land == null)
			return null;
		int raw = land.length;
		int cols = land[0].length;
		int[][] flag = new int[land.length][land[0].length];
		for (int i = 0; i < flag.length; i++) {
			for (int j = 0; j < flag[0].length; j++) {
				flag[i][j] = 0;
			}
		}
		for (int i = 0; i < land.length; i++) {
			for (int j = 0; j < land[0].length; j++) {
				if (land[i][j] == 0 && flag[i][j] == 0) {
					list.add(help(land, raw, cols, i, j, flag));
				}
			}
		}
		int[] result = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			result[i] = list.get(i);
		}
		Arrays.sort(result);
		return result;
	}

	private int help(int[][] land, int raw, int cols, int i, int j, int[][] flag) {
		if (i >= raw || i < 0 || j >= cols || j < 0 || flag[i][j] == 1 || land[i][j] != 0) {
			return 0;
		}
		flag[i][j] = 1;
		int m = 1 + help(land, raw, cols, i - 1, j, flag) + help(land, raw, cols, i - 1, j - 1, flag)
				+ help(land, raw, cols, i, j - 1, flag) + help(land, raw, cols, i + 1, j - 1, flag)
				+ help(land, raw, cols, i + 1, j, flag) + help(land, raw, cols, i + 1, j + 1, flag)
				+ help(land, raw, cols, i, j + 1, flag) + help(land, raw, cols, i - 1, j + 1, flag);
		return m;
	}
}
