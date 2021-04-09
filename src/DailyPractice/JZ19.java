package DailyPractice;

import java.util.ArrayList;
import java.util.List;

public class JZ19 {
	public static void main(String args[]) {
		int test[][] = new int[5][4];
		int t = 1;
		for (int i = 0; i < test.length; i++) {
			for (int j = 0; j < test[0].length; j++) {
				test[i][j] = t * (j + 1);
			}
			t++;
		}
		/*
		 * for (int i = 0; i < test.length; i++) { for (int j = 0; j < test[0].length;
		 * j++) { System.out.print(test[i][j] + ","); } System.out.println(); }
		 */
		JZ19 j = new JZ19();
		j.printMatrix(test);
	}

	public ArrayList<Integer> printMatrix(int[][] matrix) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int down = matrix.length;// 行数
		int right = matrix[0].length;// 列数
		int up = 0;
		int left = 0;
		while (down < up && left < right) {
			if (down - up == 1) {
				for (int i = left; i < right; i++) {
					list.add(matrix[up][i]);
				}
				return list;
			}
			if (right - left == 1) {
				for (int i = up; i < down; i++) {
					list.add(matrix[i][left]);
				}
				return list;
			}
			for (int i = left; i < right; i++) {
				list.add(matrix[up][i]);
			}
			up++;
			for (int i = up; i < down; i++) {
				list.add(matrix[i][right - 1]);
			}
			right--;
			for (int i = right - 1; i >= left; i--) {
				list.add(matrix[down - 1][i]);
			}
			down--;
			for (int i = down - 1; i >= up; i--) {
				list.add(matrix[i][left]);
			}
			left++;
		}
		return list;
	}
}
