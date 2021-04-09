package DailyPractice;

import java.util.ArrayList;

public class JZ41 {
	public static void main(String args[]) {
		JZ41 j = new JZ41();
		System.out.println(j.FindContinuousSequence(3));
	}

	// »¬¶¯´°¿Ú
	public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
		ArrayList<ArrayList<Integer>> aList = new ArrayList<>();
		if (sum == 0)
			return null;
		int i = 1;
		int j = 1;
		int temp;
		int result = 0;
		while (i <= sum / 2) {
			temp = i;
			while (temp < j) {
				result += temp;
				temp++;
			}
			if (result == sum) {
				ArrayList<Integer> list = new ArrayList<>();
				for (int x = i; x < j; x++) {
					list.add(x);
				}
				aList.add(list);
				i++;
			} else if (result < sum) {
				j++;
			} else {
				i++;
			}
			result =0;
		}
		return aList;
	}
}
