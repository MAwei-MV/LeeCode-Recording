package LiKouPractice;

import java.util.Arrays;
import java.util.Comparator;

public class Pro406 {
	public static void main(String args[]) {
		int[][] people = { { 6, 1 }, { 5, 2 }, { 7, 1 }, { 7, 0 }, { 4, 4 }, { 5, 0 } };
		Pro406 p = new Pro406();
		System.out.println(p.reconstructQueue(people));
	}

	public int[][] reconstructQueue(int[][] people) {
		Arrays.sort(people, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0])
					return o1[1] - o2[1];
				return o2[0] - o1[0];
			}
		});
		for (int i = 0; i < people.length; i++) {
			if (people[i][1] < i) {
				int flag = people[i][1];
				for (int j = i; j > flag; j--) {
					int temp[] = people[j];
					people[j] = people[j - 1];
					people[j - 1] = temp;
				}
			}
		}
		return people;
	}
}
