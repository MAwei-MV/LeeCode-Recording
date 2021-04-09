package LiKouPractice;

public class Pro134 {
	public static void main(String args[]) {
		Pro134 p = new Pro134();
		int a[] = { 1, 2, 3, 4, 5, 5, 70 };
		int b[] = { 2, 3, 4, 3, 9, 6, 2 };
		System.out.println(p.canCompleteCircuit(a, b));
	}

	public int canCompleteCircuit(int[] gas, int[] cost) {
		int len = gas.length;
		for (int i = 0; i < len; i++) {
			int x = 0;
			if (gas[i] >= cost[i]) {
				x = gas[i] - cost[i];
				int j = (i + 1) % len;
				while (j != i && x >= 0) {
					x += (gas[j] - cost[j]);
					j = (j + 1) % len;
				}
				if (x >= 0)
					return i;
			}
		}
		return -1;
	}
}
