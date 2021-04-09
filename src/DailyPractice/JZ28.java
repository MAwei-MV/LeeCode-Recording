package DailyPractice;

public class JZ28 {
	public int MoreThanHalfNum_Solution(int[] array) {
		int count = 0;
		int index = -1;
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			if (count == 0) {
				index = array[i];
				count++;
			} else {
				if (array[i] != index)
					count--;
				else {
					count++;
				}
			}
		}
		for (int j = 0; j < array.length; j++) {
			if (array[j] == index)
				sum++;

		}
		if (sum > array.length / 2) {
			return index;
		} else {
			return 0;
		}
	}
}