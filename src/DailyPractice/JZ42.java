package DailyPractice;

import java.util.ArrayList;
import java.util.HashMap;

public class JZ42 {
	public static void main(String args[]) {
		JZ42 j = new JZ42();
		int[] a = new int[] { 1, 3, 4, 5, 6, 7 };
		System.out.println(j.FindNumbersWithSum(a, 8));
	}

	public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
		ArrayList<Integer> list = new ArrayList<>();
		HashMap<Integer, Integer> hm = new HashMap<>();
		if (array.length == 0 || array == null)
			return list;
		int start = 0;
		int end = array.length - 1;
		int minMul = 2147483647;
		while (start <= end) {
			if (array[start] + array[end] == sum) {
				hm.put(array[start], array[end]);
				start ++;
			} else if (array[start] + array[end] < sum) {
				start++;
			} else {
				end--;
			}
		}
		for (Integer key : hm.keySet()) {
			if (key * hm.get(key) < minMul) {
				list.clear();
				list.add(key);
				list.add(hm.get(key));
				minMul = key * hm.get(key);
			}
		}
		return list;
	}
}
