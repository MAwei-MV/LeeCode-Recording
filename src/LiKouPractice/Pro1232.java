package LiKouPractice;

public class Pro1232 {
	public static void main(String args[]) {
		Pro1232 p = new Pro1232();
		int a[][] = { { -4, -3 }, { 1, 0 }, { 3, -1 }, { 0, -1 }, { -5, 2 } };
		p.checkStraightLine(a);
	}

	public boolean checkStraightLine(int[][] coordinates) {
		if (coordinates.length <= 2)
			return true;
		int x;
		int y;
		if (coordinates[1][0] == coordinates[0][0]) {
			x = -1001;
			y = -1001;
		} else {
			x = coordinates[1][0] - coordinates[0][0];
			y = coordinates[1][1] - coordinates[0][1];
		}
		for (int i = 2; i < coordinates.length; i++) {
			int flag1;
			int flag2;
			if (coordinates[i][0] == coordinates[i - 1][0]) {
				flag2 = -1001;
			} else {
				flag1 = coordinates[i][0] - coordinates[i - 1][0];
				flag2 = (coordinates[i][1] - coordinates[i - 1][1]) * x / flag1;
			}
			if (flag2 != y)
				return false;
		}
		return true;
	}
}
