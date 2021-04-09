package LiKouPractice;

import java.util.HashMap;

public class Pro904 {
	// 题目理解为：选定一个子数组， 这个子数组最多只有两种数字，这个选定的子数组最大可以是多少
	// 用滑动窗口
	public static void main(String args[]) {
		int a[] = { 0, 1, 2, 2 };
		Pro904 p = new Pro904();
		System.out.println(p.totalFruit(a));
	}

	/*
	 * public int totalFruit(int[] tree) { int i = 0; int j = 0; int MaxValue = 0;
	 * HashMap<Integer, Integer> hm = new HashMap<>(); while (j < tree.length) { if
	 * (hm.containsKey(tree[j])) { hm.replace(tree[j], hm.get(tree[j]) + 1); } else
	 * if (!hm.containsKey(tree[j]) && hm.size() == 2) { MaxValue =
	 * Math.max(MaxValue, j - i); int value = 0; while (!hm.containsValue(0)) {
	 * hm.replace(tree[i], hm.get(tree[i]) - 1); value = tree[i]; i++;
	 * 
	 * } hm.remove(value); hm.put(tree[j], 1); } else if (!hm.containsKey(tree[j])
	 * && hm.size() < 2) { hm.put(tree[j], 1); } j++; } int sum = 0; for (Integer x
	 * : hm.values()) { sum += x; } return Math.max(sum, MaxValue); }
	 */
	public int totalFruit(int[] tree) {
		if (tree.length <= 2)
			return tree.length;
		Windows1 w = new Windows1();
		int left = 0;
		int max = Integer.MIN_VALUE;
		for (int right = 0; right < tree.length; right++) {
			w.addElement(tree[right]);
			while (w.getDIfferent() > 2) {
				w.shrink(tree[left]);
				left++;
			}
			max = Math.max(max, w.getValues());
		}
		if(max==Integer.MIN_VALUE)return 0;
		return max;
	}
}

class Windows1 {
	private HashMap<Integer, Integer> hm = new HashMap<>();
	private int different = 0;
	private int values = 0;

	public int getDIfferent() {
		return hm.size();
	}

	public int getValues() {
		int sum = 0;
		for (Integer x : hm.values()) {
			sum += x;
		}
		return sum;
	}

	public void addElement(int x) {
		hm.put(x, hm.getOrDefault(x, 0) + 1);
		if (hm.get(x) == 1)
			different++;
	}

	public void shrink(int x) {
		hm.put(x, hm.get(x) - 1);
		if (hm.get(x) == 0) {
			hm.remove(x);
			different--;
		}
	}
}
