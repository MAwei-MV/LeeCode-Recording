package DailyPractice;

public class JZ1 {
	public boolean Find(int target, int[][] array) {
		if (array.length == 0 || array[0].length == 0) {
			return false;
		}
		int row = 0;
		int column = array[0].length - 1;
		int val = array[row][column];
		while (row <= array.length - 1 && column <= array[0].length - 1 && row >= 0 && column >= 0) {
			if (array[row][column] == target) {
				return true;
			} else if (array[row][column] > target) {
				column--;
			} else if (array[row][column] < target) {
				row++;
			}
		}
		return false;
	}
}
