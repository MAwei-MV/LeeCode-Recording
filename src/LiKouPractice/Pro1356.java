package LiKouPractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Pro1356 {
	public static void main(String args[]) {
		Pro1356 p = new Pro1356();
		int a[] = { 1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1 };
		System.out.println(p.sortByBits(a));
	}

	public int[] sortByBits(int[] arr) {
		List<Integer> list = new ArrayList<Integer>();
		for (int x : arr) {
			list.add(x);
		}
		int[] bit = new int[10001];
		for (int i = 1; i <= 10000; ++i) {
			bit[i] = bit[i >> 1] + (i & 1);
		}
		Collections.sort(list, new Comparator<Integer>() {
			public int compare(Integer x, Integer y) {
				if (bit[x] != bit[y]) {
					return bit[x] - bit[y];
				} else {
					return x - y;
				}
			}
		});
		for (int i = 0; i < arr.length; ++i) {
			arr[i] = list.get(i);
		}
		return arr;
	}

	/*
	 * public int[] sortByBits(int[] arr) { List<Integer> list = new ArrayList<>();
	 * int[] bits = new int[10001]; for (int x : arr) { list.add(x); // bits[i] =
	 * count1(arr[i]); bits[x] = count1(x); } Collections.sort(list, new
	 * Comparator<Integer>() { public int compare(Integer x, Integer y) {
	 * //x,y是数组里面的值啊 if (bits[x] != bits[y]) { return bits[x] - bits[y]; } else {
	 * return x - y; } } }); for (int i = 0; i < arr.length; ++i) { arr[i] =
	 * list.get(i); } return arr; }
	 * 
	 * public int count1(int x) { int res = 0; while (x != 0) { res += x % 2; x /=
	 * 2; } return res; }
	 */
}
